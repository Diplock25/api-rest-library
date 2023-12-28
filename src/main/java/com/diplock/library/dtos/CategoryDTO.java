package com.diplock.library.dtos;

import com.diplock.library.entities.Book;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryDTO {

  private Long categoryid;
  private String name;
  private String subtopic;
  private List<Book> bookList = new ArrayList<>();
}
