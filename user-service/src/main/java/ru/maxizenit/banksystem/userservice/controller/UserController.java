package ru.maxizenit.banksystem.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxizenit.banksystem.userservice.entity.User;
import ru.maxizenit.banksystem.userservice.service.UserService;
import ru.maxizenit.banksystem.userserviceapi.dto.UserDto;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final ModelMapper modelMapper;

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
    User user = userService.getUserById(id);
    return new ResponseEntity<>(modelMapper.map(user, UserDto.class), HttpStatus.OK);
  }
}
