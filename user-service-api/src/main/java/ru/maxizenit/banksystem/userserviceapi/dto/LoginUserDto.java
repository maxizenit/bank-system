package ru.maxizenit.banksystem.userserviceapi.dto;

import lombok.Data;

@Data
public class LoginUserDto {

  private String email;

  private String password;
}
