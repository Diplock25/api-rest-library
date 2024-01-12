package com.diplock.library.controllers;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import com.diplock.library.services.author.AuthorService;
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
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

  @NonNull
  private AuthorService authorService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthorDto> create(@Valid @RequestBody final AuthorDh authorDh) {
    return ResponseEntity.ok(this.authorService.save(authorDh));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthorDto> findById(@Valid @PathVariable final Long id) {
    return ResponseEntity.ok(this.authorService.findById(id));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AuthorDto>> findAll() {
    return ResponseEntity.ok(this.authorService.findAll());
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthorDto> updateById(@Valid @PathVariable final Long id,
      @Valid @RequestBody final AuthorDh authorDh) {
    return ResponseEntity.ok(this.authorService.updateById(id, authorDh));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> deleteById(@Valid @PathVariable final Long id) {
    return ResponseEntity.ok(this.authorService.deleteById(id));
  }
}
