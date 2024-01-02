package com.diplock.library.services.author;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import com.diplock.library.entities.Author;
import com.diplock.library.mapper.AuthorMapper;
import com.diplock.library.repositories.AuthorRepository;
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
public class AuthorServiceImpl implements AuthorService {

  @NonNull
  private final AuthorRepository authorRepository;

  @NonNull
  private final AuthorMapper authorMapper;

  @Override
  public AuthorDto save(final AuthorDh authorDh) {
    final Author author = this.authorMapper.asEntity(authorDh);
    final Author authorSaved = this.authorRepository.save(author);
    return this.authorMapper.asDto(authorSaved);
  }

  @Override
  public AuthorDto findById(final Long id) {
    final Optional<Author> author = this.authorRepository.findById(id);
    if (author.isPresent()) {
      return this.authorMapper.asDto(author.get());
    } else {
      log.warn("There is no author in the database with the id: {}", id);
      return null;
    }
  }

  @Override
  public List<AuthorDto> findAll() {
    final List<Author> authors = (List<Author>) this.authorRepository.findAll();
    if (CollectionUtils.isEmpty(authors)) {
      log.warn("There are no authors in the database");
      return Collections.emptyList();
    } else {
      return this.authorMapper.asDtoList(authors);
    }
  }

  @Override
  public AuthorDto updateById(final Long id, final AuthorDh authorDh) {
    final Author author = this.authorMapper.asEntity(authorDh);
    if (this.authorRepository.existsById(id)) {
      return this.authorMapper.asDto(this.authorRepository.save(author));
    }
    log.warn("Update failed. There is no author in the database with the id: {}", id);
    return null;
  }

  @Override
  public Boolean deleteById(final Long id) {
    if (this.authorRepository.existsById(id)) {
      this.authorRepository.deleteById(id);
      return true;
    }
    log.warn("Delete failed. There is no author in the database with the id: {}", id);
    return false;
  }
}
