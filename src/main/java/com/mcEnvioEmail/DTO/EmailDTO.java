package com.mcEnvioEmail.DTO;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.mcEnvioEmail.enums.StatusEmail;
import com.mcEnvioEmail.model.EmailModel;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
	
	@NotBlank
	private UUID emailId;
	@NotBlank
    private String ownerRef;
	@NotBlank
    private String emailFrom;
	@NotBlank
    private String emailTo;
	@NotBlank
    private String subject;
	@NotBlank
    private String text;
	@NotBlank
    private LocalDateTime sendDateEmail;
	@NotBlank
    private StatusEmail statusEmail;
	
	public EmailDTO(EmailModel em) {
		BeanUtils.copyProperties(em, this);
	}

}
