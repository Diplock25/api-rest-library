package com.diplock.library.Daos;

import com.diplock.library.Entities.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanDao {
  List<Loan> findAll();
  Optional<Loan> findById(Long loanid);
  Loan save(Loan loan);
  Loan update(Loan loan);
  void delete(Long loanid);
}
