package ru.maxizenit.banksystem.accountservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.maxizenit.banksystem.accountservice.entity.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {}
