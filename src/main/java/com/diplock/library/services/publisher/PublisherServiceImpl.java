package com.diplock.library.services.publisher;


import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.entities.Publisher;
import com.diplock.library.mapper.PublisherMapper;
import com.diplock.library.repositories.PublisherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

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

    @Override
    public PublisherDto save(final PublisherDh publisherDh) {
        final StopWatch stopWatch = new StopWatch("Create publisher process.");
        stopWatch.start("Transform publisher data holder to entity.");
        final Publisher publisher = this.publisherMapper.asEntity(publisherDh);
        stopWatch.stop();
        stopWatch.start("Save publisher in database.");
        final Publisher publisherSaved = this.publisherRepository.save(publisher);
        stopWatch.stop();
        stopWatch.start("Transform publisher entity to dto.");
        final PublisherDto publisherDto = this.publisherMapper.asDto(publisherSaved);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return publisherDto;
    }

    @Override
    public PublisherDto findById(final Long id) {
        final StopWatch stopWatch = new StopWatch("Search an publisher by id process.");
        stopWatch.start("Search an publisher by id in database.");
        final Optional<Publisher> publisher = this.publisherRepository.findById(id);
        stopWatch.stop();
        if (publisher.isPresent()) {
            stopWatch.start("Transform publisher entity to dto.");
            final PublisherDto publisherDto = this.publisherMapper.asDto(publisher.get());
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            return publisherDto;
        } else {
            log.warn("There is no publisher in the database with the id: {}", id);
            log.info(stopWatch.prettyPrint());
            return null;
        }
    }

    @Override
    public List<PublisherDto> findAll() {
        final StopWatch stopWatch = new StopWatch("Search all publishers process.");
        stopWatch.start("Search all publishers in database.");
        final List<Publisher> publishers = (List<Publisher>) this.publisherRepository.findAll();
        stopWatch.stop();
        if (CollectionUtils.isEmpty(publishers)) {
            log.warn("There are no publishers in the database");
            log.info(stopWatch.prettyPrint());
            return Collections.emptyList();
        } else {
            stopWatch.start("Transform publishers entity list to dto list.");
            final List<PublisherDto> publisherDtoList = this.publisherMapper.asDtoList(publishers);
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            return publisherDtoList;
        }
    }

    @Override
    public PublisherDto updateById(final Long id, final PublisherDh publisherDh) {
        final StopWatch stopWatch = new StopWatch("Update an publisher by id process.");
        stopWatch.start("Transform publisher data holder to entity.");
        final Publisher publisher = this.publisherMapper.asEntity(publisherDh);
        stopWatch.stop();
        stopWatch.start("Check if exists an publisher by id in database.");
        final boolean existsPublisher = this.publisherRepository.existsById(id);
        stopWatch.stop();
        if (existsPublisher) {
            stopWatch.start("Save publisher in database.");
            final Publisher publisherSaved = this.publisherRepository.save(publisher);
            stopWatch.stop();
            stopWatch.start("Transform publisher entity to dto.");
            final PublisherDto publisherDto = this.publisherMapper.asDto(publisherSaved);
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            return publisherDto;
        }
        log.warn("Update failed. There is no publisher in the database with the id: {}", id);
        log.info(stopWatch.prettyPrint());
        return null;
    }


    @Override
    public Boolean deleteById(final Long id) {
        final StopWatch stopWatch = new StopWatch("Delete an publisher by id process.");
        stopWatch.start("Check if exists an publisher by id in database.");
        final boolean existsAuthor = this.publisherRepository.existsById(id);
        stopWatch.stop();
        if (existsAuthor) {
            stopWatch.start("Delete an publisher by id in database.");
            this.publisherRepository.deleteById(id);
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            return true;
        }
        log.warn("Delete failed. There is no publisher in the database with the id: {}", id);
        log.info(stopWatch.prettyPrint());
        return false;
    }

}
