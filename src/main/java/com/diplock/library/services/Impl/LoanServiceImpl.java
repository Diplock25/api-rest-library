package com.diplock.library.services.Impl;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDTO;
import com.diplock.library.entities.loan.Loan;
import com.diplock.library.mapper.LoanMapper;
import com.diplock.library.repositories.LoanRepository;
import com.diplock.library.services.LoanService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

  @NonNull
  private final LoanRepository loanRepository;

  @NonNull
  private final LoanMapper loanMapper;

  @Override
  public List<LoanDTO> findAll() {
    final List<Loan> loanList = (List<Loan>) loanRepository.findAll();
    if (CollectionUtils.isEmpty(loanList)) {
      log.warn("There are not loans in table loans");
      return Collections.emptyList();
    } else {
      return loanMapper.asDTOList(loanList);
    }
  }

  @Override
  public LoanDTO findById(final Long loanid) {
    final Optional<Loan> loan = loanRepository.findById(loanid);
    if (loan.isPresent()) {
      return loanMapper.asDTO(loan.get());
    } else {
      log.warn("There is not loan in the table loans with the id: {}", loanid);
      return null;
    }
  }

  @Override
  public LoanDTO save(final LoanDh loanDh) {
    final Loan loan = loanMapper.asEntity(loanDh);
    final Loan loanSaved = loanRepository.save(loan);
    return loanMapper.asDTO(loanSaved);
  }

  @Override
  public LoanDTO update(final Long loanid, final LoanDh loanDh) {
    final Loan loan = loanMapper.asEntity(loanDh);
    if (loanRepository.existsById(loanid)) {
      return loanMapper.asDTO(loanRepository.save(loan));
    } else {
      log.warn("Update failed.  There is not loan in the table loans with the id: {}", loanid);
      return null;
    }
  }

  @Override
  public Boolean delete(final Long loanid) {
    if (loanRepository.existsById(loanid)) {
      loanRepository.deleteById(loanid);
      return true;
    }
    log.warn("Delete failed.  Ther is not loan in the table loans with the id: {}", loanid);
    return false;
  }
}
