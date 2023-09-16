package ru.maxizenit.banksystem.accountservice.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import ru.maxizenit.banksystem.accountservice.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findUserByEmail(String email);
}
