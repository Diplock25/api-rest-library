package com.diplock.library.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "copies")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_copy")
    private Long id_copy;

    @Column(name = "id_book")
    private Long id_book;

    @Column(name = "status")
    private Boolean status;

}
