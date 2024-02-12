package com.diplock.library.dtos;

import com.diplock.library.entities.Author;
import com.diplock.library.entities.Category;
import com.diplock.library.entities.Publisher;
import java.util.List;
import lombok.Data;

@Data
public class BookDto {

  private String isbn;

  private String title;

  private Integer pages;

  private String summary;

  private String editionDate;

  private String coverImage;

  private String bookFile;

  private String filePath;

  private String language;

  private Author author;

  private Category category;

  private Publisher publisher;

  // private List<Loan> loanList;

}
