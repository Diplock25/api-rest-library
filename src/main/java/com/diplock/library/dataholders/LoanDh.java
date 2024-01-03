package com.diplock.library.dataholders;

import com.diplock.library.entities.Book;
import com.diplock.library.entities.User;
import lombok.Data;

@Data
public class LoanDh {
  private Long loanid;
  private String loandate;
  private String returndate;
  private User user;
  private Book book;
}
