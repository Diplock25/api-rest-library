package com.diplock.library.services.book;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import java.util.List;

public interface BookService {

  BookDto save(BookDh bookDh);

  BookDto findById(String id);

  List<BookDto> findAll();

  BookDto updateById(String id, BookDh bookDh);

  Boolean deleteById(String id);
}
