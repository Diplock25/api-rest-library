package com.diplock.library.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanid")
    private Long loanid;

    @Column(name = "isbn", nullable = false)
    private Long isbn;

    @Column(name = "bookid", nullable = false)
    private Long bookid;

    @Column(name = "loandate", length = 10)
    private String loandate;

    @Column(name = "returndate", length =10)
    private String returndate;

}
