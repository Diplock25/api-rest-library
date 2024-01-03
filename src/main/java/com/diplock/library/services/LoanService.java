package com.diplock.library.services;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDTO;
import java.util.List;

public interface LoanService {
  List<LoanDTO> findAll();
  LoanDTO findById(Long loanid);
  LoanDTO save(LoanDh loanDh);
  LoanDTO update(Long loanid, LoanDh loanDh);
  Boolean delete(Long loanid);
}
