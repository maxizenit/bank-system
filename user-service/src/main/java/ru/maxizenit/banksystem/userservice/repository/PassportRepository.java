package ru.maxizenit.banksystem.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.maxizenit.banksystem.userservice.entity.Passport;

public interface PassportRepository extends CrudRepository<Passport, Integer> {}
