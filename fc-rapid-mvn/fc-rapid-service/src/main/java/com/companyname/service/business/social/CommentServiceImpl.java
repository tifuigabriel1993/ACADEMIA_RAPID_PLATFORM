package com.companyname.service.business.social;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.companyname.integration.repository.platform.UserRepository;
import com.companyname.integration.repository.social.CommentRepository;
import com.companyname.integration.repository.social.PostRepository;
import com.companyname.integration.util.DateUtil;
import com.companyname.persitence.entity.platform.User;
import com.companyname.persitence.entity.social.Comment;
import com.companyname.persitence.entity.social.Post;
import com.companyname.service.business.messaging.SendMessageService;
import com.companyname.service.business.messaging.builder.CommentMessageBuilder;
import com.companyname.service.business.messaging.builder.MessagingUrlBuilder;
import com.companyname.service.business.messaging.model.CommentMessage;
import com.companyname.service.dto.social.CommentDTO;
import com.companyname.service.transformer.CommentTransformer;
import com.companyname.service.util.SocialUtil;

@Component
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SendMessageService sendMessageService;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private MessagingUrlBuilder messagingUrlBuilder;

	@Autowired
	private CommentMessageBuilder commentMessageBuilder;

	@Autowired
	private CommentTransformer commentTransformer;

	private static int USER_COMMENTS_FIRST_PAGE = 0;

	@Override
	public List<CommentDTO> getUserLastComments(String username, int page_size) {
		PageRequest pageRequest = new PageRequest(USER_COMMENTS_FIRST_PAGE, page_size, Direction.DESC, "commentDate");
		Page<Comment> userLastComments = commentRepository.findUserLastComments(username, pageRequest);
		return commentTransformer.toDtoList(userLastComments.getContent(), true);
	}

	@Transactional
	@Override
	public void saveCommentAndSend(CommentDTO commentDto) {
		Comment comment = commentTransformer.toEntity(commentDto);

		User author = userRepository.findUserByUsername(commentDto.getUsername());
		comment.setAuthor(author);
		comment.setPost(getPost(commentDto.getPostId()));
		comment.setCommentDate(new Date());
		commentRepository.saveAndFlush(comment);

		String comment_url = messagingUrlBuilder.getCommentToPostUrl(commentDto.getPostId());
		CommentMessage commentMessage = commentMessageBuilder.createComment(commentDto, comment_url);
		commentMessage.setUserPhotoUrl(SocialUtil.buildFacebookPhotoUrl(author.getFacebookId()));
		commentMessage.setDate(DateUtil.formatActivityDate(comment.getCommentDate()));
		sendMessageService.sendMessage(commentMessage);
	}

	private Post getPost(long postId) {
		return postRepository.findOne(postId);
	}
}