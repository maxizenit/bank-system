package ru.maxizenit.banksystem.userserviceapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegistrationUserDto {

  private String email;

  private String phoneNumber;

  private String password;

  private Date birthdate;

  private String lastName;

  private String firstName;

  private String middleName;

  private String passportSeries;

  private String passportNumber;

  private Date passportIssuedDate;
}
