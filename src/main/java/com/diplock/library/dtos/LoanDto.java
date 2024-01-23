package com.diplock.library.dtos;

import com.diplock.library.entities.Book;
import com.diplock.library.entities.User;
import lombok.Data;

@Data
public class LoanDto {

  private Long loanId;

  private String loanDate;

  private String returnDate;

  private User user;

  private Book book;

}
