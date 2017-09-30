package com.companyname.service.business.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.companyname.service.business.messaging.model.Message;

@Component
public class SendMessageServiceImpl implements SendMessageService {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public void sendMessage(Message message) {
		simpMessagingTemplate.convertAndSend(message.getUrl(), message);
	}

}
