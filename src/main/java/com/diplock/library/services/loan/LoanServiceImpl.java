package com.diplock.library.services.loan;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDto;
import com.diplock.library.entities.Loan;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.LoanMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.repositories.LoanRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  private BdParser bdParser = new BdParser();

  @Override
  public List<LoanDto> findAll() {
    final List<Loan> loanList = (List<Loan>) loanRepository.findAll();
    if (CollectionUtils.isEmpty(loanList)) {
      log.warn("There are no loan in the database");
      return Collections.emptyList();
    } else {
      return loanMapper.asDTOList(loanList);
    }
  }

  @Override
  public LoanDto findById(final Long id) {
    final Optional<Loan> loan = loanRepository.findById(id);
    if (loan.isPresent()) {
      return loanMapper.asDTO(loan.get());
    } else {

      throw new BdNotFoundException("GET - There is no loan in the database with the id: " + id);
    }
  }

  @Override
  public LoanDto save(final LoanDh loanDh) {
    bdParser.Evaluator(loanDh, "POST");


    final Loan loan = loanMapper.asEntity(loanDh);
    final Loan loanSaved = loanRepository.save(loan);
    return loanMapper.asDTO(loanSaved);
  }

  @Override
  public LoanDto update(final Long id, final LoanDh loanDh) {
    bdParser.Evaluator(loanDh, "PUT");

    if (loanDh.getLoanId() != id) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field LoanId: " + loanDh.getLoanId() + " is different at id: " + id);
    }

    final Loan loan = loanMapper.asEntity(loanDh);
    if (loanRepository.existsById(id)) {
      return loanMapper.asDTO(loanRepository.save(loan));
    }

      throw new BdNotFoundException("PUT - There is no loan in the database with the id: " + id);
  }

  @Override
  public Boolean delete(final Long id) {
    if (loanRepository.existsById(id)) {
      loanRepository.deleteById(id);
      return true;
    }

    throw new BdNotFoundException("DELETE - There is no loan in the database with the id: " + id);
  }
}
