package com.diplock.library.services.author;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import java.util.List;

public interface AuthorService {

  AuthorDto save(AuthorDh authorDh);

  AuthorDto findById(Long id);

  List<AuthorDto> findAll();

  AuthorDto updateById(Long id, AuthorDh authorDh);

  Boolean deleteById(Long id);
}
