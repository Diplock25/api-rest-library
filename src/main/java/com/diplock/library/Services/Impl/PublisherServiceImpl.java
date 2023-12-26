package com.diplock.library.Services.Impl;

import com.diplock.library.Daos.PublisherDao;
import com.diplock.library.Entities.Publisher;
import com.diplock.library.Services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherDao publisherDao;

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    @Override
    public Optional<Publisher> findById(Long publisherid) {
        return publisherDao.findById(publisherid);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherDao.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    @Override
    public void delete(Long publisherid) {
        publisherDao.delete(publisherid);
    }
}
