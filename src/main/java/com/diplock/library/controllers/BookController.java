package com.diplock.library.controllers;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.services.book.BookService;
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
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

  @NonNull
  private BookService bookService;

  @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
  public ResponseEntity<BookDto> createBook(@Valid @RequestBody final BookDh bookDh) {
    return ResponseEntity.ok(this.bookService.save(bookDh));
  }

  @PostMapping(value = "/create/all", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<BookDto>> createBooks(
      @Valid @RequestBody final List<BookDh> bookDhList) {
    return ResponseEntity.ok(this.bookService.saveAll(bookDhList));
  }

  @GetMapping(value = "/find/{id}", produces = "application/json")
  public ResponseEntity<BookDto> findBook(@Valid @PathVariable final String id) {
    return ResponseEntity.ok(this.bookService.findById(id));
  }

  @PostMapping(value = "/find", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<BookDto>> findBooks(@Valid @RequestBody final List<String> ids) {
    return ResponseEntity.ok(this.bookService.findByIds(ids));
  }

  @GetMapping(value = "/find/all", produces = "application/json")
  public ResponseEntity<List<BookDto>> findAllBooks() {
    return ResponseEntity.ok(this.bookService.findAll());
  }


  @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
  public ResponseEntity<BookDto> updateBook(@Valid @RequestBody final BookDh bookDh) {
    return ResponseEntity.ok(this.bookService.update(bookDh));
  }

  @PutMapping(value = "/update/all", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<BookDto>> updateBooks(
      @Valid @RequestBody final List<BookDh> bookDhList) {
    return ResponseEntity.ok(this.bookService.updateAll(bookDhList));
  }

  @DeleteMapping(value = "/delete/{id}", produces = "application/json")
  public ResponseEntity<Boolean> deleteBook(@Valid @PathVariable final String id) {
    return ResponseEntity.ok(this.bookService.deleteById(id));
  }

  @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Boolean> deleteBooks(@Valid @RequestBody final List<String> ids) {
    this.bookService.deleteByIds(ids);
    return ResponseEntity.ok(true);
  }

  @DeleteMapping(value = "/delete/all", produces = "application/json")
  public ResponseEntity<Boolean> deleteAllBooks() {
    this.bookService.deleteAll();
    return ResponseEntity.ok(true);
  }
}
