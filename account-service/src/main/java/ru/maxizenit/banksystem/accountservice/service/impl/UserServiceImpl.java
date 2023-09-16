package ru.maxizenit.banksystem.accountservice.service.impl;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.accountservice.entity.User;
import ru.maxizenit.banksystem.accountservice.repository.UserRepository;
import ru.maxizenit.banksystem.accountservice.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = (String) authentication.getPrincipal();

    return getUserByEmail(username);
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserById(Integer id) {
    User currentUser = getCurrentUser();

    if (currentUser.getId().equals(id)) {
      return currentUser;
    } else {
      throw new AccessDeniedException("Пользователю запрещён доступ к данному ресурсу");
    }
  }

  @Override
  public User getUserByEmail(String email) {
    return userRepository.findUserByEmail(email).orElseThrow();
  }
}
