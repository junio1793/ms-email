package com.mcEnvioEmail.service;

import java.time.LocalDateTime;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mcEnvioEmail.enums.StatusEmail;
import com.mcEnvioEmail.model.EmailModel;
import com.mcEnvioEmail.repository.EmailRepository;

@Service
public class EmailService {
	
	private final EmailRepository repository;
	
	private final JavaMailSender mailSender;
	
	public EmailService(EmailRepository repository,JavaMailSender mailSender) {
		this.repository = repository;
		this.mailSender = mailSender;
	}
	
	public void sendEmail(EmailModel em) {
		em.setSendDateEmail(LocalDateTime.now());
		
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(em.getEmailFrom());
			mailMessage.setTo(em.getEmailTo());
			mailMessage.setSubject(em.getSubject());
			mailMessage.setText(em.getText());
			
			mailSender.send(mailMessage);
			
			em.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			e.printStackTrace();
		}finally {
			repository.save(em);
		}
		
	}

}
