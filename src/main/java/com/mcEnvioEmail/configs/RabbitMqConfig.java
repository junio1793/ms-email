package com.mcEnvioEmail.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${spring.rabbitmq.queue}")
	String queue;
	
	@Bean
	public Queue fila() {
		return new Queue(queue,true);
	}
}
