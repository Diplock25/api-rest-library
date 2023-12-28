package com.diplock.library.services.Impl;

import com.diplock.library.entities.Loan;
import com.diplock.library.repositories.LoanRepository;
import com.diplock.library.services.LoanService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

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
  public void update(Loan loan) {

    loanRepository.save(loan);
  }

  @Override
  public void delete(Long loanid) {

    loanRepository.deleteById(loanid);
  }
}
