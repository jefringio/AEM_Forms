package com.silverseatest.core.service;

import org.apache.commons.mail.EmailException;

public interface MailService {
	
	public void sendMail(String recipient, String subject, String message) throws EmailException;

}
