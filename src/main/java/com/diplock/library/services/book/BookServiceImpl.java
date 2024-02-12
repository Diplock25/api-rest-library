package com.diplock.library.services.book;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.entities.Book;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.BookMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.repositories.BookRepository;
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
public class BookServiceImpl implements BookService {

  @NonNull
  private final BookRepository bookRepository;

  @NonNull
  private final BookMapper bookMapper;

  private BdParser bdParser = new BdParser();

  @Override
  public BookDto save(final BookDh bookDh) {
    bdParser.Evaluator(bookDh, "POST");
    final Book book = this.bookMapper.asEntity(bookDh);

    if (this.bookRepository.existsById(book.getIsbn())) {
      throw new BdNotSaveException("The ISBN value already exists in the database: " + book.getIsbn());
    } else {
            final Book bookSaved = this.bookRepository.save(book);
            final BookDto bookDto = this.bookMapper.asDto(bookSaved);
            return bookDto;
           }
  }

  @Override
  public BookDto findById(final String id) {
    final Optional<Book> book = this.bookRepository.findById(id);
    if (book.isPresent()) {
      final BookDto bookDto = this.bookMapper.asDto(book.get());
      return bookDto;
    } else {
      throw new BdNotFoundException("GET - There is no book in the database with the id: " + id);
    }
  }

  @Override
  public List<BookDto> findAll() {
    final List<Book> books = (List<Book>) this.bookRepository.findAll();
    if (CollectionUtils.isEmpty(books)) {
      log.warn("There are no books in the database");
      return Collections.emptyList();
    } else {
      final List<BookDto> bookDtoList = this.bookMapper.asDtoList(books);
      return bookDtoList;
    }
  }

  @Override
  public BookDto updateById(final String id, final BookDh bookDh) {
    bdParser.Evaluator(bookDh, "PUT");

    if (!bookDh.getIsbn().equals(id)) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field categorId: " + bookDh.getIsbn() + " is different at id: " + id);
    }

    final Book book = this.bookMapper.asEntity(bookDh);
    final boolean existsBook = this.bookRepository.existsById(id);
    if (existsBook) {
      final Book bookSaved = this.bookRepository.save(book);
      final BookDto bookDto = this.bookMapper.asDto(bookSaved);
      return bookDto;
    }
    throw new BdNotFoundException("PUT - There is no book in the database with the id: " + id);

  }

  @Override
  public Boolean deleteById(final String id) {
    final boolean existsBook = this.bookRepository.existsById(id);
    if (existsBook) {
      this.bookRepository.deleteById(id);
      return true;
    }
    throw new BdNotFoundException("DELETE - There is no book in the database with the id: " + id);
  }
}
