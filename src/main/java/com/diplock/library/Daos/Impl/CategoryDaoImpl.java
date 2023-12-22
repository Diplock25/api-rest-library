package com.diplock.library.Daos.Impl;

import com.diplock.library.Daos.CategoryDao;
import com.diplock.library.Entities.Category;
import com.diplock.library.Repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryDaoImpl implements CategoryDao {

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
