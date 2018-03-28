package com.sensefilms.common.handlers;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailHandler implements IMailHandler
{
	private JavaMailSenderImpl javaMailSender;	
	
	@Autowired
	public EmailHandler(JavaMailSenderImpl javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMailMessage(String to, String subject, String body) throws MessagingException 
	{		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); 
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body); 
		
		javaMailSender.send(message);			
	}
}
