package com.sensefilms.common.handlers;

import javax.mail.MessagingException;

public interface IMailHandler 
{
	void sendMailMessage(String to, String subject, String body) throws MessagingException;
}
