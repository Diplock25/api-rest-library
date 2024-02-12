package com.diplock.library.dataholders;

import lombok.Data;

@Data
public class BookDh {

  private String isbn;

  private String title;

  private Integer pages;

  private String summary;

  private String editionDate;

  private String coverImage;

  private String bookFile;

  private String filePath;

  private String language;

  private AuthorDh author;

  private CategoryDh category;

  private PublisherDh publisher;

  // private LoanDh loanList;

}
