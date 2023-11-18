package com.mcEnvioEmail.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.mcEnvioEmail.enums.StatusEmail;
import com.mcEnvioEmail.model.EmailModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmailDTO {

	@NotBlank
	private String ownerRef;
	
	@Email
	@NotBlank
	private String emailFrom;
	
	@Email
	@NotBlank
	private String emailTo;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;

	public EmailDTO(EmailModel em) {
		BeanUtils.copyProperties(em, this);
	}

}
