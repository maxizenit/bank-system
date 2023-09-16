package ru.maxizenit.banksystem.accountservice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfiguration {

  @Bean
  public Queue userRegistrationQueue() {
    return new Queue("user-registration-queue");
  }
}
