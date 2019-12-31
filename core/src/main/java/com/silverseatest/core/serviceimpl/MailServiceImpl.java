package com.silverseatest.core.serviceimpl;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.silverseatest.core.service.MailService;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;


@Component(service = MailService.class, immediate=true)
public class MailServiceImpl implements MailService{
	
	@Reference
	private MessageGatewayService messageGatewayService;

	@Override
	public void sendMail(String recipient, String subject, String message) throws EmailException {
		
		MessageGateway<Email> messageGateway;
		Email email = new SimpleEmail();
		email.addTo(recipient);
		email.setSubject(subject);
		email.setMsg(message);
		messageGateway = messageGatewayService.getGateway(Email.class);
		messageGateway.send((Email) email);
	}

}
