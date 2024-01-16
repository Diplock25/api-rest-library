package com.diplock.library.services.loan;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDto;
import java.util.List;

public interface LoanService {

  List<LoanDto> findAll();

  LoanDto findById(Long id);

  LoanDto save(LoanDh loanDh);

  LoanDto update(Long id, LoanDh loanDh);

  Boolean delete(Long id);
}
