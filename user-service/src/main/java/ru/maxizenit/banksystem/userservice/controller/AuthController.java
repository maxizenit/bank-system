package ru.maxizenit.banksystem.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxizenit.banksystem.userserviceapi.dto.LoginUserDto;
import ru.maxizenit.banksystem.userserviceapi.dto.PassportDto;
import ru.maxizenit.banksystem.userserviceapi.dto.RegistrationUserDto;
import ru.maxizenit.banksystem.userserviceapi.dto.UserDto;
import ru.maxizenit.banksystem.userservice.entity.Passport;
import ru.maxizenit.banksystem.userservice.entity.User;
import ru.maxizenit.banksystem.userservice.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  private final ModelMapper modelMapper;

  private final PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public ResponseEntity<UserDto> registerUser(
      @RequestBody RegistrationUserDto registrationUserDto) {
    User user = new User();
    user.setEmail(registrationUserDto.getEmail());
    user.setPhoneNumber(registrationUserDto.getPhoneNumber());
    user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));

    Passport passport = new Passport();
    passport.setBirthdate(registrationUserDto.getBirthdate());
    passport.setLastName(registrationUserDto.getLastName());
    passport.setFirstName(registrationUserDto.getFirstName());
    passport.setMiddleName(registrationUserDto.getMiddleName());
    passport.setSeries(registrationUserDto.getPassportSeries());
    passport.setNumber(registrationUserDto.getPassportNumber());
    passport.setIssuedDate(registrationUserDto.getPassportIssuedDate());

    User registeredUser = authService.registerUser(user, passport);
    return new ResponseEntity<>(modelMapper.map(registeredUser, UserDto.class), HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@RequestBody LoginUserDto loginUserDto) {
    String token = authService.loginUser(loginUserDto.getEmail(), loginUserDto.getPassword());
    return new ResponseEntity<>(token, HttpStatus.CREATED);
  }
}
