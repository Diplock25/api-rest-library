package com.diplock.library.mapper;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.entities.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {

    Publisher asEntity(PublisherDh publisherDh);

    PublisherDto asDto(Publisher publisher);

    List<Publisher> asEntityList(List<PublisherDh> publisherDhList);

    List<PublisherDto> asDtoList(List<Publisher> publishers);
}
