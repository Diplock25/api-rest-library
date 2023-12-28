package com.diplock.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "books")
public class Book {

  @Id
  @Column(name = "isbn", length = 13)
  private String isbn;

  @Column(name = "title", length = 50)
  private String title;

  @Column(name = "summary", length = 255)
  private String summary;

  @Column(name = "pages")
  private Integer pages;

  @Column(name = "editiondate", length = 10)
  private String editiondate;

  @Column(name = "coverimage", length = 55)
  private String coverimage;

  @Column(name = "filebook", length = 55)
  private String filebook;

  @Column(name = "filepath", length = 100)
  private String filepath;

  @Column(name = "languagues", length = 20)
  private String languagues;

  @ManyToOne
  @JoinColumn(name = "categoryid", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
  @JsonIgnore
  private List<Loan> loanList = new ArrayList<>();
}
