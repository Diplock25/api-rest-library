package com.diplock.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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
