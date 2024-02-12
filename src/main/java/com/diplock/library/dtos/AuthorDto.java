package com.diplock.library.dtos;


import com.diplock.library.entities.Book;
import java.util.List;
import lombok.Data;

@Data
public class AuthorDto {

  private Long authorId;

  private String firstName;

  private String lastName;

  private List<Book> bookList;

}
