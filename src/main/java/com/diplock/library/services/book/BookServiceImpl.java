package com.diplock.library.services.book;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.entities.Book;
import com.diplock.library.mapper.BookMapper;
import com.diplock.library.repositories.BookRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  @NonNull
  private final BookRepository bookRepository;

  @NonNull
  private final BookMapper bookMapper;

  @Override
  public BookDto save(final BookDh bookDh) {
    final StopWatch stopWatch = new StopWatch("Create book process.");
    stopWatch.start("Transform book data holder to entity.");
    final Book book = this.bookMapper.asEntity(bookDh);
    stopWatch.stop();
    stopWatch.start("Save book in database.");
    final Book bookSaved = this.bookRepository.save(book);
    stopWatch.stop();
    stopWatch.start("Transform book entity to dto.");
    final BookDto bookDto = this.bookMapper.asDto(bookSaved);
    stopWatch.stop();
    log.info(stopWatch.prettyPrint());
    return bookDto;
  }

  @Override
  public BookDto findById(final String id) {
    final StopWatch stopWatch = new StopWatch("Search an book by id process.");
    stopWatch.start("Search an book by id in database.");
    final Optional<Book> book = this.bookRepository.findById(id);
    stopWatch.stop();
    if (book.isPresent()) {
      stopWatch.start("Transform book entity to dto.");
      final BookDto bookDto = this.bookMapper.asDto(book.get());
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return bookDto;
    } else {
      log.warn("There is no book in the database with the id: {}", id);
      log.info(stopWatch.prettyPrint());
      return null;
    }
  }

  @Override
  public List<BookDto> findAll() {
    final StopWatch stopWatch = new StopWatch("Search all books process.");
    stopWatch.start("Search all books in database.");
    final List<Book> books = (List<Book>) this.bookRepository.findAll();
    stopWatch.stop();
    if (CollectionUtils.isEmpty(books)) {
      log.warn("There are no books in the database");
      log.info(stopWatch.prettyPrint());
      return Collections.emptyList();
    } else {
      stopWatch.start("Transform books entity list to dto list.");
      final List<BookDto> bookDtoList = this.bookMapper.asDtoList(books);
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return bookDtoList;
    }
  }

  @Override
  public BookDto updateById(final String id, final BookDh bookDh) {
    final StopWatch stopWatch = new StopWatch("Update an book by id process.");
    stopWatch.start("Transform book data holder to entity.");
    final Book book = this.bookMapper.asEntity(bookDh);
    stopWatch.stop();
    stopWatch.start("Check if exists an book by id in database.");
    final boolean existsBook = this.bookRepository.existsById(id);
    stopWatch.stop();
    if (existsBook) {
      stopWatch.start("Save book in database.");
      final Book bookSaved = this.bookRepository.save(book);
      stopWatch.stop();
      stopWatch.start("Transform book entity to dto.");
      final BookDto bookDto = this.bookMapper.asDto(bookSaved);
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return bookDto;
    }
    log.warn("Update failed. There is no book in the database with the id: {}", id);
    log.info(stopWatch.prettyPrint());
    return null;
  }

  @Override
  public Boolean deleteById(final String id) {
    final StopWatch stopWatch = new StopWatch("Delete an book by id process.");
    stopWatch.start("Check if exists an book by id in database.");
    final boolean existsBook = this.bookRepository.existsById(id);
    stopWatch.stop();
    if (existsBook) {
      stopWatch.start("Delete an book by id in database.");
      this.bookRepository.deleteById(id);
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return true;
    }
    log.warn("Delete failed. There is no book in the database with the id: {}", id);
    log.info(stopWatch.prettyPrint());
    return false;
  }
}
