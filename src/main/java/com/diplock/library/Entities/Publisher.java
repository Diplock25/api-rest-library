package com.diplock.library.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisherid")
    private Long publisherid;

    @Column(name = "publisher", length = 50)
    private String publisher;

    @Column(name = "location", length =  100)
    private String location;

    @Column(name = "country", length = 30)
    private String country;
}
