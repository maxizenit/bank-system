package ru.maxizenit.banksystem.userservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.maxizenit.banksystem.userservice.entity.User;

public interface UserService extends UserDetailsService {

  User getCurrentUser();

  User getUserById(Integer id);

  User getUserByEmail(String email);

  User saveUser(User user);
}
