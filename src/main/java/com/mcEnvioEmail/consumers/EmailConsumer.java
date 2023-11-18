package com.mcEnvioEmail.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.mcEnvioEmail.DTO.EmailDTO;
import com.mcEnvioEmail.model.EmailModel;
import com.mcEnvioEmail.service.EmailService;

@Component
public class EmailConsumer {

	private final EmailService emailService;
	
	public EmailConsumer(EmailService emailService) {
		this.emailService = emailService;
	}
	
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listener(@Payload EmailDTO emailDto) {
		EmailModel emailmodel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailmodel);
		emailService.sendEmail(emailmodel);
		System.out.println("Email status: " + emailmodel.getStatusEmail().toString());
	}
}
