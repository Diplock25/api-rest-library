package com.diplock.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

  @Column(name = "title", length = 50)
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

  @ManyToMany
  @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name = "isbn")},
      inverseJoinColumns = {@JoinColumn(name = "author_id")})
  private List<Author> authors;

  @ManyToOne
  @JoinColumn(name = "categoryId", referencedColumnName = "category_id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
  @JsonIgnore
  private List<Loan> loanList;

}
