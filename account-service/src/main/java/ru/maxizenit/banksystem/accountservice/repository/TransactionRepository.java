package ru.maxizenit.banksystem.accountservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.maxizenit.banksystem.accountservice.entity.Transfer;

public interface TransactionRepository extends CrudRepository<Transfer, Integer> {}
