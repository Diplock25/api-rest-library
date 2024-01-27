package com.diplock.library.services.loan;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDto;
import com.diplock.library.entities.Loan;
import com.diplock.library.exceptions.CategoryNotFoundException;
import com.diplock.library.exceptions.CategoryNotSaveException;
import com.diplock.library.exceptions.LoanNotFoundException;
import com.diplock.library.mapper.LoanMapper;
import com.diplock.library.repositories.LoanRepository;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

      throw new LoanNotFoundException("GET - There is no loan in the database with the id: " + id);
    }
  }

  @Override
  public LoanDto save(final LoanDh loanDh) {
    if (Objects.equals(loanDh.getLoanDate(), null)) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field LoanDate - name is null");
    } else if (loanDh.getLoanDate().isBlank()) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field LoanDate - name is blank");
    }

    if (Objects.equals(loanDh.getReturnDate(), null)) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field ReturnDate - name is null");
    } else if (loanDh.getReturnDate().isBlank()) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field ReturnDate - name is blank");
    }

    final Loan loan = loanMapper.asEntity(loanDh);
    final Loan loanSaved = loanRepository.save(loan);
    return loanMapper.asDTO(loanSaved);
  }

  @Override
  public LoanDto update(final Long id, final LoanDh loanDh) {
    if (Objects.equals(loanDh.getLoanDate(), null)) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field LoanDate - name is null");
    } else if (loanDh.getLoanDate().isBlank()) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field LoanDate - name is blank");
    }

    if (Objects.equals(loanDh.getReturnDate(), null)) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field ReturnDate - name is null");
    } else if (loanDh.getReturnDate().isBlank()) {
      throw new CategoryNotSaveException("POST - Parameters are incorrect for field ReturnDate - name is blank");
    }

    if (loanDh.getLoanId() != id) {
      throw new CategoryNotSaveException("PUT - Parameters are incorrect for field LoanId: " + loanDh.getLoanId() + " is different at id: " + id);
    }

    final Loan loan = loanMapper.asEntity(loanDh);
    if (loanRepository.existsById(id)) {
      return loanMapper.asDTO(loanRepository.save(loan));
    }

      throw new LoanNotFoundException("PUT - There is no loan in the database with the id: " + id);
  }

  @Override
  public Boolean delete(final Long id) {
    if (loanRepository.existsById(id)) {
      loanRepository.deleteById(id);
      return true;
    }

    throw new LoanNotFoundException("DELETE - There is no loan in the database with the id: " + id);
  }
}
