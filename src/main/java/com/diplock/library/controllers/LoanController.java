package com.diplock.library.controllers;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDTO;

import com.diplock.library.services.LoanService;
import jakarta.validation.Valid;
import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@Slf4j
@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

  @NonNull
  private final LoanService loanService;


  // Se establece explícitamente, si la lógica del método se completa correctamente,
  // enviando una respuesta con un código de estado HTTP 200
  @GetMapping(value = "/{loanid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<LoanDTO> findById(@Valid @PathVariable("loanid") final Long loanid) {
      return ResponseEntity.ok(loanService.findById(loanid));
  }


  // Se establece explícitamente, si la lógica del método se completa correctamente,
  // enviando una respuesta con un código de estado HTTP 200
  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<LoanDTO>> findAll() {
    return ResponseEntity.ok(loanService.findAll());
  }


  // Se establece explícitamente que, si la lógica del método se completa correctamente
  // y se crea un nuevo recurso, se enviará una respuesta con un código de estado
  // HTTP 201 (CREATED)
  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<LoanDTO> save(@Valid @RequestBody final LoanDh loanDh) {
    return ResponseEntity.ok(loanService.save(loanDh));
  }


  // Se establece explícitamente, si la lógica del método se completa correctamente,
  // enviando una respuesta con un código de estado HTTP 200
  @PutMapping(value = "/{loanid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<LoanDTO> update(@Valid @PathVariable("loanid") final Long loanid, @RequestBody final LoanDh loanDh) {
      return ResponseEntity.ok(loanService.update(loanid, loanDh));
  }


  // Si la lógica de búsqueda determina que el recurso no existe, se activará la excepción.
  // La excepción se capturará y se enviará una respuesta con un código de estado HTTP 404.
  @DeleteMapping(value = "/{loanid}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Boolean> deleteById(@Valid @PathVariable("loanid") final Long loanid) {
        return ResponseEntity.ok(loanService.delete(loanid));
  }

}
