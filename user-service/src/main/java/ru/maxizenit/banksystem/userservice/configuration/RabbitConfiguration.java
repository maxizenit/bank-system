package ru.maxizenit.banksystem.userservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfiguration {

  @Bean
  public DirectExchange userRegistrationExchange() {
    return new DirectExchange("user-registration-exchange");
  }

  @Bean
  public Queue userRegistrationQueue() {
    return new Queue("user-registration-queue");
  }

  @Bean
  public Binding userRegistrationBinding(
      DirectExchange userRegistrationExchange, Queue userRegistrationQueue) {
    return BindingBuilder.bind(userRegistrationQueue)
        .to(userRegistrationExchange)
        .with("user.registration");
  }
}
