package com.diplock.library.dataholders;

import com.diplock.library.entities.Book;
import com.diplock.library.entities.User;
import lombok.Data;

@Data
public class LoanDh {

  private Long loanId;

  private String loanDate;

  private String returnDate;

  private User user;

  private Book book;

}
