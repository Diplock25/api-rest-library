package com.diplock.library.dataholders;

import java.util.List;
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

  private List<AuthorDh> authors;

  private CategoryDh category;

  // private LoanDh loanList;

}
