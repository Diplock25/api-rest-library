package com.diplock.library.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long id_book;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "isbn", length = 30)
    private String isbn;

    @Column(name = "pages", length = 11)
    private Integer pages;

    @Column(name = "id_language", nullable = false)
    private Long id_language;

    @Column(name = "Edition", length = 11)
    private String Edition;

    @Column(name = "id_author", nullable = false)
    private Long id_author;

    @Column(name = "id_publisher", nullable = false)
    private Long id_publisher;

    @Column(name = "id_category", nullable = false)
    private Long id_category;

    @Column(name = "summary", length = 255)
    private String summary;

}
