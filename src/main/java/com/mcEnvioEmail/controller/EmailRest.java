package com.mcEnvioEmail.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcEnvioEmail.DTO.EmailDTO;
import com.mcEnvioEmail.model.EmailModel;
import com.mcEnvioEmail.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping 
public class EmailRest {
	
	private final EmailService getEmailService;
	
	public EmailRest(EmailService es) {
		this.getEmailService = es;
	}
	
	@PostMapping("/sending_email")
	public ResponseEntity<EmailModel> sendEmail(
				@RequestBody @Valid EmailDTO emailDTO
			){
		EmailModel em = new  EmailModel();
		BeanUtils.copyProperties(emailDTO, em);
		getEmailService.sendEmail(em);
				return new ResponseEntity<>(em,HttpStatus.CREATED);
	}

}
