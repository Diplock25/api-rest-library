package com.diplock.library.services.loan;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDTO;
import java.util.List;

public interface LoanService {

  List<LoanDTO> findAll();

  LoanDTO findById(Long id);

  LoanDTO save(LoanDh loanDh);

  LoanDTO update(Long id, LoanDh loanDh);

  Boolean delete(Long id);
}
