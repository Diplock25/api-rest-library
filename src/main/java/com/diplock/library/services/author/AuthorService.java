package com.diplock.library.services.author;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import java.util.List;

public interface AuthorService {

  AuthorDto save(AuthorDh authorDh);

  List<AuthorDto> saveAll(List<AuthorDh> authorDhList);

  AuthorDto findById(Long id);

  List<AuthorDto> findByIds(List<Long> ids);

  List<AuthorDto> findAll();

  AuthorDto update(AuthorDh authorDh);

  List<AuthorDto> updateAll(List<AuthorDh> authorDhList);

  Boolean deleteById(Long id);

  void deleteByIds(List<Long> ids);

  void deleteAll();
}
