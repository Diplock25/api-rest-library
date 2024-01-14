package com.diplock.library.dtos;

import com.diplock.library.entities.Book;
import com.diplock.library.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoanDTO {

  private Long loanId;

  private String loanDate;

  private String returnDate;

  private User user;

  private Book book;

}
