package com.diplock.library.services;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;

import java.util.List;
public interface PublisherService {
  PublisherDto save(PublisherDh authorDh);

  List<PublisherDto> saveAll(List<PublisherDh> authorDhList);

  PublisherDto findById(Long id);

  List<PublisherDto> findByIds(List<Long> ids);

  List<PublisherDto> findAll();

  PublisherDto update(PublisherDh authorDh);

  List<PublisherDto> updateAll(List<PublisherDh> authorDhList);

  Boolean deleteById(Long id);

  void deleteByIds(List<Long> ids);

  void deleteAll();
}
