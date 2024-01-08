package com.diplock.library.services.publisher;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;

import java.util.List;

public interface PublisherService {
    PublisherDto save(PublisherDh authorDh);
    PublisherDto findById(Long id);
    List<PublisherDto> findAll();
    PublisherDto updateById(Long id,PublisherDh authorDh);
    Boolean deleteById(Long id);

}
