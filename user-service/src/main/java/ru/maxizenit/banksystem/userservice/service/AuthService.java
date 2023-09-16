package ru.maxizenit.banksystem.userservice.service;

import ru.maxizenit.banksystem.userservice.entity.Passport;
import ru.maxizenit.banksystem.userservice.entity.User;

public interface AuthService {

  User registerUser(User user, Passport passport);

  String loginUser(String email, String password);
}
