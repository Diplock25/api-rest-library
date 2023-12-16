package com.diplock.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher")
    private Long id_publisher;

    @Column(name = "publisher", length = 50)
    private String publisher;

    @Column(name = "location", length =  50)
    private String location;
}
