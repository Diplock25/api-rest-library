package com.diplock.library.entities.loan;

import com.diplock.library.entities.Book;
import com.diplock.library.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "loans")
public class Loan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "loanid")
  private Long loanid;

  @Column(name = "loandate", length = 10)
  private String loandate;

  @Column(name = "returndate", length =10)
  private String returndate;

  @ManyToOne
  @JoinColumn(name = "userid", nullable = false)
  @JsonIgnore
  private User user;

  @ManyToOne
  @JoinColumn(name = "isbn", nullable = false)
  @JsonIgnore
  private Book book;
}
