package com.diplock.library.controllers;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDTO;

import com.diplock.library.services.loan.LoanService;
import jakarta.validation.Valid;
import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

  @NonNull
  private final LoanService loanService;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoanDTO> findById(@Valid @PathVariable final Long id) {
      return ResponseEntity.ok(loanService.findById(id));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<LoanDTO>> findAll() {
    return ResponseEntity.ok(loanService.findAll());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoanDTO> save(@Valid @RequestBody final LoanDh loanDh) {
    return ResponseEntity.ok(loanService.save(loanDh));
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoanDTO> update(@Valid @PathVariable final Long id, @RequestBody final LoanDh loanDh) {
      return ResponseEntity.ok(loanService.update(id, loanDh));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> deleteById(@Valid @PathVariable final Long id) {
        return ResponseEntity.ok(loanService.delete(id));
  }

}
