package com.diplock.library.mapper;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import com.diplock.library.entities.Author;
import java.util.List;
import org.mapstruct.Mapper;

//@Mapper(uses = {BookMapper.class})
@Mapper
public interface AuthorMapper {

  Author asEntity(AuthorDh authorDh);

  AuthorDto asDto(Author author);

  List<Author> asEntityList(List<AuthorDh> authorDhList);

  List<AuthorDto> asDtoList(List<Author> author);
}
