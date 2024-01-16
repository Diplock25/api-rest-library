package com.diplock.library.controllers;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.services.book.BookService;
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
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {

  @NonNull
  private BookService bookService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookDto> create(@Valid @RequestBody final BookDh bookDh) {
    return ResponseEntity.ok(this.bookService.save(bookDh));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookDto> findById(@Valid @PathVariable final String id) {
    return ResponseEntity.ok(this.bookService.findById(id));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookDto>> findAll() {
    return ResponseEntity.ok(this.bookService.findAll());
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookDto> updateById(@Valid @PathVariable final String id,
      @Valid @RequestBody final BookDh bookDh) {
    return ResponseEntity.ok(this.bookService.updateById(id, bookDh));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> deleteById(@Valid @PathVariable final String id) {
    return ResponseEntity.ok(this.bookService.deleteById(id));
  }
}
