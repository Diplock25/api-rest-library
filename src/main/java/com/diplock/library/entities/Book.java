package com.diplock.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

  @Id
  @Column(name = "isbn", length = 13)
  private String isbn;

  @Column(name = "title", length = 50, nullable = false)
  private String title;

  @Column(name = "pages", length = 11)
  private Integer pages;

  @Column(name = "summary")
  private String summary;

  @Column(name = "edition_date", length = 11)
  private String editionDate;

  @Column(name = "cover_image", length = 55)
  private String coverImage;

  @Column(name = "book_file", length = 55)
  private String bookFile;

  @Column(name = "file_path", length = 100)
  private String filePath;

  @Column(name = "language", length = 20)
  private String language;

  @ManyToOne
  @JoinColumn(name = "authorId", referencedColumnName = "author_id")
  @JsonIgnore
  private Author authors;

  @ManyToOne
  @JoinColumn(name = "categoryId", referencedColumnName = "category_id")
  @JsonIgnore
  private Category category;

  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
  @JsonIgnore
  private List<Loan> loanList;

  @ManyToOne
  @JoinColumn(name = "publisherId", referencedColumnName = "publisher_id")
  @JsonIgnore
  private Publisher publisher;

}
