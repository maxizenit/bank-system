package ru.maxizenit.banksystem.userserviceapi.dto;

import lombok.Data;

@Data
public class UserDto {

  private Integer id;

  private String email;

  private String phoneNumber;
}
