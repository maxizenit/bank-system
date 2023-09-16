package ru.maxizenit.banksystem.accountservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;

@Entity
@Data
public class Transfer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Timestamp timestamp;

  @ManyToOne
  @JoinColumn(name = "sender_account_id")
  private Account sender;

  @ManyToOne
  @JoinColumn(name = "receiver_account_id")
  private Account receiver;

  private BigDecimal amount;
}
