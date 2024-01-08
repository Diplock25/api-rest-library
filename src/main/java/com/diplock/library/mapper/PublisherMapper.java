package com.diplock.library.mapper;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.entities.publisher.Publisher;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface PublisherMapper {
  Publisher asEntity(PublisherDh publisherDh);

  PublisherDto asDto(Publisher publisher);

  List<Publisher> asEntityList(List<PublisherDh> publisherDhList);

  List<PublisherDto> asDtoList(List<Publisher> publishers);
}
