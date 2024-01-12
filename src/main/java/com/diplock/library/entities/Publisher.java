package com.diplock.library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "location", length =  100)
    private String location;

    @Column(name = "country", length = 30)
    private String country;

    //@OneToMany (mappedBy = "publishers")
    //private List<Book> books;
}
