package ru.maxizenit.banksystem.userserviceapi.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProducingUserDto implements Serializable {

  private Integer id;

  private String email;

  private String lastName;

  private String firstName;

  private String middleName;
}
