package com.diplock.library.dtos;

import com.diplock.library.entities.Book;
import java.util.List;
import lombok.Data;

@Data
public class CategoryDto {

  private Long categoryId;

  private String name;

  private String subtopic;

  private List<Book> bookList;

}
