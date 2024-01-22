package com.diplock.library.dtos;

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

  private List<AuthorDto> authors;

  private CategoryDto category;

  // private List<LoanDto> loanList;

}
