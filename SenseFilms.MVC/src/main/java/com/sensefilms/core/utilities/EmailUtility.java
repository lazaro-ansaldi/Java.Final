package com.sensefilms.core.utilities;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility implements IMailUtility
{
	private JavaMailSenderImpl javaMailSender;	
	
	@Autowired
	public EmailUtility(JavaMailSenderImpl javaMailSender)
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
