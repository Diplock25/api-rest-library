package com.diplock.library.Services;

import com.diplock.library.Entities.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

  List<Category> findAll();
  Optional<Category> findById(Long categoryid);
  Category save(Category category);
  void update(Category category);
  void delete(Long categoryid);
}
