package com.diplock.library.entities;

import com.diplock.library.entities.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "loan_id")
  private Long loanId;

  @Column(name = "loan_date", length = 10)
  private String loanDate;

  @Column(name = "return_date", length =10)
  private String returnDate;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  @JsonIgnore
  private User user;

  @ManyToOne
  @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false)
  @JsonIgnore
  private Book book;

}
