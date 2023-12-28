package com.diplock.library.dtos;

import com.diplock.library.entities.Book;
import com.diplock.library.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoanDTO {

  private Long loanid;
  private String loandate;
  private String returndate;
  private User user;
  private Book book;

}
