package com.diplock.library.services.author;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import com.diplock.library.entities.Author;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.AuthorMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.exceptions.BdNotFoundException;
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

  private BdParser bdParser = new BdParser();

  @Override
  public AuthorDto save(final AuthorDh authorDh) {
    bdParser.Evaluator(authorDh, "POST");
    final Author author = this.authorMapper.asEntity(authorDh);
    final Author authorSaved = this.authorRepository.save(author);
    final AuthorDto authorDto = this.authorMapper.asDto(authorSaved);
    return authorDto;
  }

  @Override
  public AuthorDto findById(final Long id) {
    final Optional<Author> author = this.authorRepository.findById(id);
    if (author.isPresent()) {
      final AuthorDto authorDto = this.authorMapper.asDto(author.get());
      return authorDto;
    } else {
      throw new BdNotFoundException("GET - There is no author in the database with the id: " + id);
    }
  }

  @Override
  public List<AuthorDto> findAll() {
    final List<Author> authors = (List<Author>) this.authorRepository.findAll();
    if (CollectionUtils.isEmpty(authors)) {
      log.warn("There are no authors in the database");
      return Collections.emptyList();
    } else {
      final List<AuthorDto> authorDtoList = this.authorMapper.asDtoList(authors);
      return authorDtoList;
    }
  }

  @Override
  public AuthorDto updateById(final Long id, final AuthorDh authorDh) {
    bdParser.Evaluator(authorDh, "PUT");

    if (authorDh.getAuthorId() != id) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field authorId: " + authorDh.getAuthorId() + " is different at id: " + id);
    }

    final Author author = this.authorMapper.asEntity(authorDh);
    final boolean existsAuthor = this.authorRepository.existsById(id);

    if (existsAuthor) {
      final Author authorSaved = this.authorRepository.save(author);
      final AuthorDto authorDto = this.authorMapper.asDto(authorSaved);
      return authorDto;
    }
    throw new BdNotFoundException("PUT - There is no author in the database with the id: " + id);
  }

  @Override
  public Boolean deleteById(final Long id) {
    final boolean existsAuthor = this.authorRepository.existsById(id);
    if (existsAuthor) {
      this.authorRepository.deleteById(id);
      return true;
    }
    throw new BdNotFoundException("DELETE - There is no author in the database with the id: " + id);
  }
}
