package ru.maxizenit.banksystem.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.maxizenit.banksystem.userservice.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);
}
