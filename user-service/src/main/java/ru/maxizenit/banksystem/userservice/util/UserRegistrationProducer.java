package ru.maxizenit.banksystem.userservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.maxizenit.banksystem.userserviceapi.dto.ProducingUserDto;

@Component
@RequiredArgsConstructor
public class UserRegistrationProducer {

  private final RabbitTemplate rabbitTemplate;

  public void sendUserRegistration(ProducingUserDto producingUserDto) {
    rabbitTemplate.convertAndSend(
        "user-registration-exchange", "user.registration", producingUserDto);
  }
}
