package com.companyname.service.business.social;

import java.util.List;

import com.companyname.service.dto.social.CommentDTO;

public interface CommentService {

	void saveCommentAndSend(CommentDTO commentDto);

	List<CommentDTO> getUserLastComments(String username, int page_size);

}
