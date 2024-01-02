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

import java.util.ArrayList;
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
        final Publisher publisher = this.publisherMapper.asEntity(publisherDh);
        final Publisher publisherSaved = this.publisherRepository.save(publisher);
        return this.publisherMapper.asDto(publisherSaved);
    }

    @Override
    public List<PublisherDto> saveAll(final List<PublisherDh> publisherDhList) {
        final List<Publisher> publishers = this.publisherMapper.asEntityList(publisherDhList);
        final List<Publisher> publishersSaved = (List<Publisher>) this.publisherRepository.saveAll(publishers);
        return this.publisherMapper.asDtoList(publishersSaved);
    }

    @Override
    public PublisherDto findById(final Long id) {
        final Optional<Publisher> publisher = this.publisherRepository.findById(id);
        if (publisher.isPresent()) {
            return this.publisherMapper.asDto(publisher.get());
        } else {
            log.warn("There is no publisher in the database with the id: {}", id);
            return null;
        }
    }

    @Override
    public List<PublisherDto> findByIds(final List<Long> ids) {
        final List<Publisher> publishers = (List<Publisher>) this.publisherRepository.findAllById(ids);
        if (CollectionUtils.isEmpty(publishers)) {
            log.warn("There are no publishers in the database with the ids: {}", ids);
            return Collections.emptyList();
        } else {
            return this.publisherMapper.asDtoList(publishers);
        }
    }


    @Override
    public List<PublisherDto> findAll() {
        final List<Publisher> publishers = (List<Publisher>) this.publisherRepository.findAll();
        if (CollectionUtils.isEmpty(publishers)) {
            log.warn("There are no publishers in the database");
            return Collections.emptyList();
        } else {
            return this.publisherMapper.asDtoList(publishers);
        }
    }

    @Override
    public PublisherDto update(final PublisherDh publisherDh) {
        final Publisher publisher = this.publisherMapper.asEntity(publisherDh);
        if (this.publisherRepository.existsById(publisherDh.getPublisherId())) {
            return this.publisherMapper.asDto(this.publisherRepository.save(publisher));
        }
        log.warn("Update failed. There is no publisher in the database with the id: {}",
                publisherDh.getPublisherId());
        return null;
    }

    @Override
    public List<PublisherDto> updateAll(final List<PublisherDh> publisherDhList) {
        final List<Publisher> publishers = this.publisherMapper.asEntityList(publisherDhList);
        final List<PublisherDto> publisherDtoList = new ArrayList<>(publishers.size());
        publishers.forEach(publisher -> {
            if (this.publisherRepository.existsById(publisher.getPublisherId())) {
                publisherDtoList.add(this.publisherMapper.asDto(this.publisherRepository.save(publisher)));
            }
            log.warn("Update failed. There is no publisher in the database with the id: {}",
                    publisher.getPublisherId());
        });
        return publisherDtoList;
    }

    @Override
    public Boolean deleteById(final Long id) {
        if (this.publisherRepository.existsById(id)) {
            this.publisherRepository.deleteById(id);
            return true;
        }
        log.warn("Delete failed. There is no publisher in the database with the id: {}", id);
        return false;
    }

    @Override
    public void deleteByIds(final List<Long> ids) {
        ids.forEach(id -> {
            if (this.publisherRepository.existsById(id)) {
                this.publisherRepository.deleteById(id);

            }
            log.warn("Delete failed. There is no publisher in the database with the id: {}", id);
        });
    }

    @Override
    public void deleteAll() {
        this.publisherRepository.deleteAll();
    }
}
