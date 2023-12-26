package com.diplock.library.Services;

import com.diplock.library.Entities.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> findAll();
    Optional<Publisher> findById(Long publisherid);
    Publisher save(Publisher publisher);
    void update(Publisher publisher);
    void delete(Long publisherid);
}
