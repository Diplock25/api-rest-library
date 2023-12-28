package com.diplock.library.controllers;

import com.diplock.library.dtos.LoanDTO;
import com.diplock.library.entities.Loan;
import com.diplock.library.services.LoanService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

  @Autowired
  private LoanService loanService;

  @GetMapping("/find/{loanid}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> findById(@PathVariable Long loanid) {
    Optional<Loan> loanOptional = loanService.findById(loanid);

    if (loanOptional.isPresent()) {
      Loan loan = loanOptional.get();

      LoanDTO loanDTO = LoanDTO.builder()
          .loanid(loan.getLoanid())
          .loandate(loan.getLoandate())
          .returndate(loan.getReturndate())
          .user(loan.getUser())
          .book(loan.getBook())
          .build();

      return ResponseEntity.ok(loanDTO);
    }

    return ResponseEntity.notFound().build();
  }

  @GetMapping("/find/All")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> findAll() {
    List<LoanDTO> loanList = loanService.findAll()
        .stream()
        .map(loan -> LoanDTO.builder()
            .loanid(loan.getLoanid())
            .loandate(loan.getLoandate())
            .returndate(loan.getReturndate())
            .user(loan.getUser())
            .book(loan.getBook())
            .build())
        .toList();
    return ResponseEntity.ok(loanList);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> save(@RequestBody LoanDTO loanDTO) {

    if (loanDTO.getLoandate().isBlank()) {
      return ResponseEntity.badRequest().build();
    }

    Loan loan = loanService.save(Loan.builder()
        .loandate(loanDTO.getLoandate())
        .returndate(loanDTO.getReturndate())
        .user(loanDTO.getUser())
        .book(loanDTO.getBook())
        .build());

    LoanDTO loanReturnDTO = LoanDTO.builder()
        .loanid(loan.getLoanid())
        .loandate(loan.getLoandate())
        .returndate(loan.getReturndate())
        .user(loan.getUser())
        .book(loan.getBook())
        .build();

    return ResponseEntity.ok(loanReturnDTO);
  }

  @PutMapping("/update/{loanid}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> update(@PathVariable Long loanid, @RequestBody LoanDTO loanDTO) {
    Optional<Loan> loanOptional = loanService.findById(loanid);

    if (loanOptional.isPresent()) {
      Loan loan = loanOptional.get();
      loan.setLoandate(loanDTO.getLoandate());
      loan.setReturndate(loanDTO.getReturndate());
      loan.setUser(loanDTO.getUser());
      loan.setBook(loanDTO.getBook());

      loanService.update(loan);

      return ResponseEntity.ok("Update registre");
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/delete/{loanid}")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<?> deleteById(@PathVariable Long loanid) {
    if (loanid != null) {
      Optional<Loan> loanOptional = loanService.findById(loanid);

      if (loanOptional.isPresent()){
        loanService.delete(loanid);
        return ResponseEntity.ok("Delete registre");
      }
    }

    return ResponseEntity.badRequest().build();
  }

}
