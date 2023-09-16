package ru.maxizenit.banksystem.accountservice.service;

import ru.maxizenit.banksystem.accountservice.entity.User;

public interface UserService {

  User getCurrentUser();

  User saveUser(User user);

  User getUserById(Integer id);

  User getUserByEmail(String email);
}
