package ru.maxizenit.banksystem.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxizenit.banksystem.userservice.entity.Passport;
import ru.maxizenit.banksystem.userservice.repository.PassportRepository;
import ru.maxizenit.banksystem.userservice.service.PassportService;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

  private final PassportRepository passportRepository;

  @Override
  public Passport savePassport(Passport passport) {
    return passportRepository.save(passport);
  }
}
