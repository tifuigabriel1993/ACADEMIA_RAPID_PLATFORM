package com.companyname.service.business.social;

import java.util.List;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.integration.repository.platform.UserRepository;
import com.companyname.integration.repository.social.AddressRepository;
import com.companyname.integration.repository.social.CommentRepository;
import com.companyname.integration.repository.social.PostRepository;
import com.companyname.persitence.entity.platform.User;
import com.companyname.persitence.entity.social.Address;
import com.companyname.persitence.entity.social.Profile;
import com.companyname.service.dto.platform.AddressDTO;
import com.companyname.service.dto.platform.PostDTO;
import com.companyname.service.dto.platform.UserDTO;
import com.companyname.service.dto.social.CommentDTO;
import com.companyname.service.dto.social.ProfileDTO;
import com.companyname.service.dto.social.SimpleActivityDTO;
import com.companyname.service.exception.UserNotFoundException;
import com.companyname.service.transformer.AddressTransformer;
import com.companyname.service.transformer.ProfileTransformer;
import com.companyname.service.util.SocialUtil;
import com.companyname.service.util.builder.ActivityBuilder;
import com.companyname.service.util.collection.SetUtil;
import com.companyname.service.util.comparator.ActivityComparator;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private PostService postService;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ActivityBuilder activityBuilder;

	@Autowired
	private ProfileTransformer profileTransformer;

	@Autowired
	private AddressTransformer addressTransformer;

	private static int MAX_ACTIVITIES_NUMBER = 5;

	@Override
	public ProfileDTO findProfile(String username) {
		User userWithProfile = userRepository.findUserWithProfile(username);

		if (userWithProfile == null) {
			throw new UserNotFoundException();
		}
		ProfileDTO profileDto = profileTransformer.toDto(userWithProfile);
		profileDto.setUrlPhoto(SocialUtil.buildFacebookPhotoUrl(userWithProfile.getFacebookId()));
		profileDto.setActivities(findUserActivities(userWithProfile));
		profileDto.setUserCommentsNumber(commentRepository.findUserCommentsNumber(username));
		profileDto.setUserPostsNumber(postRepository.findUserPostsNumber(username));

		return profileDto;
	}

	@Transactional
	@Override
	public void updateUserProfile(ProfileDTO profileDto) {
		Profile profile = profileTransformer.toEntity(profileDto);
		User user = userRepository.findUserByUsername(profileDto.getUserDto().getUsername());
		updateUser(user, profileDto.getUserDto());

		AddressDTO addressDto = profileDto.getAddressDto();
		Address address = addressRepository.findByCityAndCountry(addressDto.getCountry(), addressDto.getCity());
		if (address == null) {
			address = addressTransformer.toEntity(addressDto);
		}

		profile.setUser(user);
		user.setUserProfile(profile);

		profile.setAddress(address);
		userRepository.save(user);
	}

	private TreeSet<SimpleActivityDTO> findUserActivities(User user) {
		TreeSet<SimpleActivityDTO> profileActivities = new TreeSet<>(new ActivityComparator());
		profileActivities.add(activityBuilder.buildRegistrationActivity(user));

		List<PostDTO> userPosts = postService.getUserLastPosts(user.getUsername(), MAX_ACTIVITIES_NUMBER);
		profileActivities.addAll(activityBuilder.buildPostingActivities(userPosts));

		List<CommentDTO> userLastComments =
				commentService.getUserLastComments(user.getUsername(), MAX_ACTIVITIES_NUMBER);
		profileActivities.addAll(activityBuilder.buildCommentingActivities(userLastComments));

		return SetUtil.getFirstActivities(MAX_ACTIVITIES_NUMBER, profileActivities);
	}

	private void updateUser(User user, UserDTO userDto) {
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getSecondName());
	}

}