package ru.maxizenit.banksystem.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.userservice.entity.Passport;
import ru.maxizenit.banksystem.userservice.entity.User;
import ru.maxizenit.banksystem.userservice.service.AuthService;
import ru.maxizenit.banksystem.userservice.service.PassportService;
import ru.maxizenit.banksystem.userservice.service.UserService;
import ru.maxizenit.banksystem.userservice.util.JwtTokenUtils;
import ru.maxizenit.banksystem.userservice.util.UserRegistrationProducer;
import ru.maxizenit.banksystem.userserviceapi.dto.ProducingUserDto;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserService userService;

  private final PassportService passportService;

  private final JwtTokenUtils jwtTokenUtils;

  private final AuthenticationManager authenticationManager;

  private final UserRegistrationProducer userRegistrationProducer;

  @Override
  public User registerUser(User user, Passport passport) {
    User savedUser = userService.saveUser(user);
    passport.setUser(savedUser);
    passportService.savePassport(passport);

    ProducingUserDto producingUserDto = new ProducingUserDto();
    producingUserDto.setId(user.getId());
    producingUserDto.setEmail(user.getEmail());
    producingUserDto.setLastName(passport.getLastName());
    producingUserDto.setFirstName(passport.getFirstName());
    producingUserDto.setMiddleName(passport.getMiddleName());

    userRegistrationProducer.sendUserRegistration(producingUserDto);

    return savedUser;
  }

  @Override
  public String loginUser(String email, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    User user = userService.getUserByEmail(email);

    return jwtTokenUtils.generateToken(user);
  }
}
