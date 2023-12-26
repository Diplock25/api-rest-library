package com.diplock.library.services.book;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.entities.Book;
import com.diplock.library.mapper.BookMapper;
import com.diplock.library.repositories.BookRepository;
import java.util.ArrayList;
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
  public List<BookDto> saveAll(final List<BookDh> bookDhList) {
    final List<Book> books = this.bookMapper.asEntityList(bookDhList);
    final List<Book> booksSaved = (List<Book>) this.bookRepository.saveAll(books);
    return this.bookMapper.asDtoList(booksSaved);
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
  public List<BookDto> findByIds(final List<String> ids) {
    final List<Book> books = (List<Book>) this.bookRepository.findAllById(ids);
    if (CollectionUtils.isEmpty(books)) {
      log.warn("There are no books in the database with the ids: {}", ids);
      return Collections.emptyList();
    } else {
      return this.bookMapper.asDtoList(books);
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
  public BookDto update(final BookDh bookDh) {
    final Book book = this.bookMapper.asEntity(bookDh);
    if (this.bookRepository.existsById(bookDh.getIsbn())) {
      return this.bookMapper.asDto(this.bookRepository.save(book));
    }
    log.warn("Update failed. There is no book in the database with the id: {}", bookDh.getIsbn());
    return null;
  }

  @Override
  public List<BookDto> updateAll(final List<BookDh> bookDhList) {
    final List<Book> books = this.bookMapper.asEntityList(bookDhList);
    final List<BookDto> bookDtoList = new ArrayList<>(books.size());
    books.forEach(book -> {
      if (this.bookRepository.existsById(book.getIsbn())) {
        bookDtoList.add(this.bookMapper.asDto(this.bookRepository.save(book)));
      }
      log.warn("Update failed. There is no book in the database with the id: {}", book.getIsbn());
    });
    return bookDtoList;
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

  @Override
  public void deleteByIds(final List<String> ids) {
    ids.forEach(id -> {
      if (this.bookRepository.existsById(id)) {
        this.bookRepository.deleteById(id);

      }
      log.warn("Delete failed. There is no book in the database with the id: {}", id);
    });
  }

  @Override
  public void deleteAll() {
    this.bookRepository.deleteAll();
  }
}
