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
import org.springframework.util.StopWatch;

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
    final StopWatch stopWatch = new StopWatch("Create author process.");
    stopWatch.start("Transform author data holder to entity.");
    final Author author = this.authorMapper.asEntity(authorDh);
    stopWatch.stop();
    stopWatch.start("Save author in database.");
    final Author authorSaved = this.authorRepository.save(author);
    stopWatch.stop();
    stopWatch.start("Transform author entity to dto.");
    final AuthorDto authorDto = this.authorMapper.asDto(authorSaved);
    stopWatch.stop();
    log.info(stopWatch.prettyPrint());
    return authorDto;
  }

  @Override
  public AuthorDto findById(final Long id) {
    final StopWatch stopWatch = new StopWatch("Search an author by id process.");
    stopWatch.start("Search an author by id in database.");
    final Optional<Author> author = this.authorRepository.findById(id);
    stopWatch.stop();
    if (author.isPresent()) {
      stopWatch.start("Transform author entity to dto.");
      final AuthorDto authorDto = this.authorMapper.asDto(author.get());
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return authorDto;
    } else {
      log.warn("There is no author in the database with the id: {}", id);
      log.info(stopWatch.prettyPrint());
      return null;
    }
  }

  @Override
  public List<AuthorDto> findAll() {
    final StopWatch stopWatch = new StopWatch("Search all authors process.");
    stopWatch.start("Search all authors in database.");
    final List<Author> authors = (List<Author>) this.authorRepository.findAll();
    stopWatch.stop();
    if (CollectionUtils.isEmpty(authors)) {
      log.warn("There are no authors in the database");
      log.info(stopWatch.prettyPrint());
      return Collections.emptyList();
    } else {
      stopWatch.start("Transform authors entity list to dto list.");
      final List<AuthorDto> authorDtoList = this.authorMapper.asDtoList(authors);
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return authorDtoList;
    }
  }

  @Override
  public AuthorDto updateById(final Long id, final AuthorDh authorDh) {
    final StopWatch stopWatch = new StopWatch("Update an author by id process.");
    stopWatch.start("Transform author data holder to entity.");
    final Author author = this.authorMapper.asEntity(authorDh);
    stopWatch.stop();
    stopWatch.start("Check if exists an author by id in database.");
    final boolean existsAuthor = this.authorRepository.existsById(id);
    stopWatch.stop();
    if (existsAuthor) {
      stopWatch.start("Save author in database.");
      final Author authorSaved = this.authorRepository.save(author);
      stopWatch.stop();
      stopWatch.start("Transform author entity to dto.");
      final AuthorDto authorDto = this.authorMapper.asDto(authorSaved);
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return authorDto;
    }
    log.warn("Update failed. There is no author in the database with the id: {}", id);
    log.info(stopWatch.prettyPrint());
    return null;
  }

  @Override
  public Boolean deleteById(final Long id) {
    final StopWatch stopWatch = new StopWatch("Delete an author by id process.");
    stopWatch.start("Check if exists an author by id in database.");
    final boolean existsAuthor = this.authorRepository.existsById(id);
    stopWatch.stop();
    if (existsAuthor) {
      stopWatch.start("Delete an author by id in database.");
      this.authorRepository.deleteById(id);
      stopWatch.stop();
      log.info(stopWatch.prettyPrint());
      return true;
    }
    log.warn("Delete failed. There is no author in the database with the id: {}", id);
    log.info(stopWatch.prettyPrint());
    return false;
  }
}
