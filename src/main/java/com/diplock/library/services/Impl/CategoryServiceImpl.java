package com.diplock.library.services.Impl;

import com.diplock.library.entities.Category;
import com.diplock.library.repositories.CategoryRepository;
import com.diplock.library.services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> findAll() {

    return (List<Category>) categoryRepository.findAll();
  }

  @Override
  public Optional<Category> findById(Long categoryid) {
    return categoryRepository.findById(categoryid);
  }

  @Override
  public Category save(Category category) {

    return categoryRepository.save(category);
  }

  @Override
  public void update(Category category) {

    categoryRepository.save(category);
  }

  @Override
  public void delete(Long categoryid) {

    categoryRepository.deleteById(categoryid);
  }
}
