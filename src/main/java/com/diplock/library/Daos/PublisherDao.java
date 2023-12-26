package com.diplock.library.Daos;

import com.diplock.library.Entities.Publisher;
import java.util.List;
import java.util.Optional;
public interface PublisherDao {
    List<Publisher> findAll();
    Optional<Publisher> findById(Long publisherid);
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    void delete(Long publisherid);
}
