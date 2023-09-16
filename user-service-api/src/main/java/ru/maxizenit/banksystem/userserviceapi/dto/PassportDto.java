package ru.maxizenit.banksystem.userserviceapi.dto;

import java.util.Date;
import lombok.Data;

@Data
public class PassportDto {

  private Integer id;

  private Date birthDate;

  private String lastName;

  private String firstName;

  private String middleName;

  private String series;

  private String number;

  private Date issuedDate;

  private UserDto user;
}
