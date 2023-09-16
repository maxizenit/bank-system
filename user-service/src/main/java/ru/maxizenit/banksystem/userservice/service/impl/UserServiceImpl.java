package ru.maxizenit.banksystem.userservice.service.impl;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.userservice.entity.User;
import ru.maxizenit.banksystem.userservice.repository.UserRepository;
import ru.maxizenit.banksystem.userservice.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = getUserByEmail(username);

    return new org.springframework.security.core.userdetails.User(
        user.getEmail(), user.getPassword(), Collections.emptyList());
  }

  @Override
  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = (String) authentication.getPrincipal();

    return getUserByEmail(username);
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

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
