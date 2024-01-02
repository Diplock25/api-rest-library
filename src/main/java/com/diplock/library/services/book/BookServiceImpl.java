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
    final Book book = this.bookMapper.asEntity(bookDh);
    final Book bookSaved = this.bookRepository.save(book);
    return this.bookMapper.asDto(bookSaved);
  }

  @Override
  public BookDto findById(final String id) {
    final Optional<Book> book = this.bookRepository.findById(id);
    if (book.isPresent()) {
      return this.bookMapper.asDto(book.get());
    } else {
      log.warn("There is no book in the database with the id: {}", id);
      return null;
    }
  }

  @Override
  public List<BookDto> findAll() {
    final List<Book> books = (List<Book>) this.bookRepository.findAll();
    if (CollectionUtils.isEmpty(books)) {
      log.warn("There are no books in the database");
      return Collections.emptyList();
    } else {
      return this.bookMapper.asDtoList(books);
    }
  }

  @Override
  public BookDto updateById(final String id, final BookDh bookDh) {
    final Book book = this.bookMapper.asEntity(bookDh);
    if (this.bookRepository.existsById(id)) {
      return this.bookMapper.asDto(this.bookRepository.save(book));
    }
    log.warn("Update failed. There is no book in the database with the id: {}", id);
    return null;
  }

  @Override
  public Boolean deleteById(final String id) {
    if (this.bookRepository.existsById(id)) {
      this.bookRepository.deleteById(id);
      return true;
    }
    log.warn("Delete failed. There is no book in the database with the id: {}", id);
    return false;
  }
}
