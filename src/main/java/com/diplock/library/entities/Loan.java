package com.diplock.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_loan")
  private Long id_loan;

  @Column(name = "id_user", nullable = false)
  private Long id_user;

  @Column(name = "id_copy")
  private Long id_copy;

  @Column(name = "issue_date", length = 11)
  private String issue_date;

  @Column(name = "due_date", length = 11)
  private String due_date;

}
