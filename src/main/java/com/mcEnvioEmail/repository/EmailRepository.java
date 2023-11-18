package com.mcEnvioEmail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcEnvioEmail.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
