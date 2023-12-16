package com.diplock.library.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
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

    @Column(name = "due_date", length =11)
    private String due_date;

}
