package ru.maxizenit.banksystem.accountservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "\"user\"")
@Data
public class User {

  @Id private Integer id;

  private String email;

  private String lastName;

  private String firstName;

  private String middleName;
}
