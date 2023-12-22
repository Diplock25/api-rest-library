package com.diplock.library.Daos.Impl;

import com.diplock.library.Daos.LoanDao;
import com.diplock.library.Entities.Loan;
import com.diplock.library.Repositories.LoanRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanDaoImpl implements LoanDao {

  @Autowired
  private LoanRepository loanRepository;

  @Override
  public List<Loan> findAll() {
    return (List<Loan>) loanRepository.findAll();
  }

  @Override
  public Optional<Loan> findById(Long loanid) {
    return loanRepository.findById(loanid);
  }

  @Override
  public Loan save(Loan loan) {
    return loanRepository.save(loan);
  }

  @Override
  public Loan update(Loan loan) {
    return loanRepository.save(loan);
  }

  @Override
  public void delete(Long loanid) {
    loanRepository.deleteById(loanid);
  }
}
