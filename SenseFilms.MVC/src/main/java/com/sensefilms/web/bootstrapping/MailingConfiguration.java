package com.sensefilms.web.bootstrapping;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:mail.properties")
public class MailingConfiguration 
{
    @Value("${mail.transport.protocol}")
    private String transportProtocol;
    
    @Value("${mail.host}")
    private String host;
    
    @Value("${mail.port}")
    private int port;
    
    @Value("${mail.smtp.auth}")
    private boolean auth;
    
    @Value("${mail.smtp.starttls.enable}")
    private boolean starttls;
    
    @Value("${mail.from}")
    private String from;
    
    @Value("${mail.username}")
    private String username;
    
    @Value("${mail.password}")
    private String password;
    
    @Value("${mail.ssl.trust}")
    private String sslTrust;

    @Bean
    public JavaMailSenderImpl javaMailSender() 
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();       
        
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);        
        
        mailSender.setJavaMailProperties(getMailSenderProperties());
        
        return mailSender;
    }
    
    private Properties getMailSenderProperties()
    {
    	Properties mailProperties = new Properties();
    	
        mailProperties.put("mail.smtp.auth", auth);
        mailProperties.put("mail.smtp.starttls.enable", starttls);
        mailProperties.put("mail.transport.protocol", transportProtocol);  
        mailProperties.put("mail.smtp.ssl.trust", sslTrust);
        
        return mailProperties;
    }
}
