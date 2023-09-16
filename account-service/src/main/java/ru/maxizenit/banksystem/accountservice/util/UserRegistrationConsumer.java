package ru.maxizenit.banksystem.accountservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.maxizenit.banksystem.accountservice.entity.User;
import ru.maxizenit.banksystem.accountservice.service.UserService;
import ru.maxizenit.banksystem.userserviceapi.dto.ProducingUserDto;

@Component
@RequiredArgsConstructor
public class UserRegistrationConsumer {

  private final UserService userService;

  @RabbitListener(queues = "user-registration-queue")
  public void receiveUserRegistration(ProducingUserDto producingUserDto) {
    User user = new User();

    user.setId(producingUserDto.getId());
    user.setEmail(producingUserDto.getEmail());
    user.setLastName(producingUserDto.getLastName());
    user.setFirstName(producingUserDto.getFirstName());
    user.setMiddleName(producingUserDto.getMiddleName());

    userService.saveUser(user);
  }
}
