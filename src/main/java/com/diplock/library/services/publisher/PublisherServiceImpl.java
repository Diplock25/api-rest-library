package com.diplock.library.services.publisher;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.entities.Publisher;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.PublisherMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.repositories.PublisherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    @NonNull
    private final PublisherRepository publisherRepository;

    @NonNull
    private final PublisherMapper publisherMapper;

    private BdParser bdParser = new BdParser();

    @Override
    public PublisherDto save(final PublisherDh publisherDh) {
        bdParser.Evaluator(publisherDh, "POST");
        final Publisher publisher = this.publisherMapper.asEntity(publisherDh);
        final Publisher publisherSaved = this.publisherRepository.save(publisher);
        final PublisherDto publisherDto = this.publisherMapper.asDto(publisherSaved);
        return publisherDto;
    }

    @Override
    public PublisherDto findById(final Long id) {
        final Optional<Publisher> publisher = this.publisherRepository.findById(id);
        if (publisher.isPresent()) {
            final PublisherDto publisherDto = this.publisherMapper.asDto(publisher.get());
            return publisherDto;
        } else {
            throw new BdNotFoundException("GET - There is no publisher in the database with the id: " + id);
        }
    }

    @Override
    public List<PublisherDto> findAll() {
        final List<Publisher> publishers = (List<Publisher>) this.publisherRepository.findAll();
        if (CollectionUtils.isEmpty(publishers)) {
            log.warn("There are no publishers in the database");
            return Collections.emptyList();
        } else {
            final List<PublisherDto> publisherDtoList = this.publisherMapper.asDtoList(publishers);
            return publisherDtoList;
        }
    }

    @Override
    public PublisherDto updateById(final Long id, final PublisherDh publisherDh) {
        bdParser.Evaluator(publisherDh, "PUT");

        if (publisherDh.getPublisherId() != id) {
            throw new BdNotSaveException("PUT - Parameters are incorrect for field publisherId: " + publisherDh.getPublisherId() + " is different at id: " + id);
        }

        final Publisher publisher = this.publisherMapper.asEntity(publisherDh);
        final boolean existsPublisher = this.publisherRepository.existsById(id);
        if (existsPublisher) {
            final Publisher publisherSaved = this.publisherRepository.save(publisher);
            final PublisherDto publisherDto = this.publisherMapper.asDto(publisherSaved);
            return publisherDto;
        }
        throw new BdNotFoundException("PUT - There is no publisher in the database with the id: " + id);
    }


    @Override
    public Boolean deleteById(final Long id) {
        final boolean existsAuthor = this.publisherRepository.existsById(id);
        if (existsAuthor) {
            this.publisherRepository.deleteById(id);
            return true;
        }
        throw new BdNotFoundException("DELETE - There is no publisher in the database with the id: " + id);
    }

}
