package com.diplock.library.mapper;

import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.entities.Book;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(uses = AuthorMapper.class)
public interface BookMapper {

  Book asEntity(BookDh bookDh);

  BookDto asDto(Book book);

  List<Book> asEntityList(List<BookDh> bookDhList);

  List<BookDto> asDtoList(List<Book> books);
}
