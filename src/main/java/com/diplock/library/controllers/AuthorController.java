package com.diplock.library.controllers;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import com.diplock.library.services.author.AuthorService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("author")
@RequiredArgsConstructor
public class AuthorController {

  @NonNull
  private AuthorService authorService;

  @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
  public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody final AuthorDh authorDh) {
    return ResponseEntity.ok(this.authorService.save(authorDh));
  }

  @PostMapping(value = "/create/all", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<AuthorDto>> createAuthors(
      @Valid @RequestBody final List<AuthorDh> authorDhList) {
    return ResponseEntity.ok(this.authorService.saveAll(authorDhList));
  }

  @GetMapping(value = "/find/{id}", produces = "application/json")
  public ResponseEntity<AuthorDto> findAuthor(@Valid @PathVariable final Long id) {
    return ResponseEntity.ok(this.authorService.findById(id));
  }

  @PostMapping(value = "/find", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<AuthorDto>> findAuthors(@Valid @RequestBody final List<Long> ids) {
    return ResponseEntity.ok(this.authorService.findByIds(ids));
  }

  @GetMapping(value = "/find/all", produces = "application/json")
  public ResponseEntity<List<AuthorDto>> findAllAuthors() {
    return ResponseEntity.ok(this.authorService.findAll());
  }


  @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
  public ResponseEntity<AuthorDto> updateAuthor(@Valid @RequestBody final AuthorDh authorDh) {
    return ResponseEntity.ok(this.authorService.update(authorDh));
  }

  @PutMapping(value = "/update/all", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<AuthorDto>> updateAuthors(
      @Valid @RequestBody final List<AuthorDh> authorDhList) {
    return ResponseEntity.ok(this.authorService.updateAll(authorDhList));
  }

  @DeleteMapping(value = "/delete/{id}", produces = "application/json")
  public ResponseEntity<Boolean> deleteAuthor(@Valid @PathVariable final Long id) {
    return ResponseEntity.ok(this.authorService.deleteById(id));
  }

  @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Boolean> deleteAuthors(@Valid @RequestBody final List<Long> ids) {
    this.authorService.deleteByIds(ids);
    return ResponseEntity.ok(true);
  }

  @DeleteMapping(value = "/delete/all", produces = "application/json")
  public ResponseEntity<Boolean> deleteAllAuthors() {
    this.authorService.deleteAll();
    return ResponseEntity.ok(true);
  }
}
