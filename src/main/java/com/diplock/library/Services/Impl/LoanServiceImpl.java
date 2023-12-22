package com.diplock.library.Services.Impl;

import com.diplock.library.Daos.LoanDao;
import com.diplock.library.Entities.Loan;
import com.diplock.library.Services.LoanService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

  @Autowired
  private LoanDao loanDao;

  @Override
  public List<Loan> findAll() {
    return loanDao.findAll();
  }

  @Override
  public Optional<Loan> findById(Long loanid) {
    return loanDao.findById(loanid);
  }

  @Override
  public Loan save(Loan loan) {
    return loanDao.save(loan);
  }

  @Override
  public Loan update(Loan loan) {
    return loanDao.update(loan);
  }

  @Override
  public void delete(Long loanid) {
    loanDao.delete(loanid);
  }
}
