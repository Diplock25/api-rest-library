package com.diplock.library.services.book;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import java.util.List;

public interface BookService {

  BookDto save(BookDh bookDh);

  List<BookDto> saveAll(List<BookDh> bookDhList);

  BookDto findById(String id);

  List<BookDto> findByIds(List<String> ids);

  List<BookDto> findAll();

  BookDto update(BookDh bookDh);

  List<BookDto> updateAll(List<BookDh> bookDhList);

  Boolean deleteById(String id);

  void deleteByIds(List<String> ids);

  void deleteAll();
}
