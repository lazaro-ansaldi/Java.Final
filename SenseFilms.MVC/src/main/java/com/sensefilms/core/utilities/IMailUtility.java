package com.sensefilms.core.utilities;

import javax.mail.MessagingException;

public interface IMailUtility 
{
	void sendMailMessage(String to, String subject, String body) throws MessagingException;
}
