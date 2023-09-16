package ru.maxizenit.banksystem.accountservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.maxizenit.banksystem.accountservice.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {}
