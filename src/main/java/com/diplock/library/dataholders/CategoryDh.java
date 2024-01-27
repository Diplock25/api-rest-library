package com.diplock.library.dataholders;

import com.diplock.library.entities.Book;
import java.util.List;
import lombok.Data;

@Data
public class CategoryDh {

  private Long categoryId;

  private String name;

  private String subtopic;

  private List<Book> bookList;

}
