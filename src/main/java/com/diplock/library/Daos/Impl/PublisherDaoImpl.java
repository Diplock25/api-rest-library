package com.diplock.library.Daos.Impl;

import com.diplock.library.Daos.PublisherDao;
import com.diplock.library.Entities.Publisher;
import com.diplock.library.Repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PublisherDaoImpl implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return (List<Publisher>) publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findById(Long publisherid) {
        return publisherRepository.findById(publisherid);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Long publisherid) {
        publisherRepository.deleteById(publisherid);
    }
}
