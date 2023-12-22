package com.diplock.library.Services.Impl;

import com.diplock.library.Daos.CategoryDao;
import com.diplock.library.Entities.Category;
import com.diplock.library.Services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDao categoryDao;

  @Override
  public List<Category> findAll() {
    return categoryDao.findAll();
  }

  @Override
  public Optional<Category> findById(Long categoryid) {
    return categoryDao.findById(categoryid);
  }

  @Override
  public Category save(Category category) {
    return categoryDao.save(category);
  }

  @Override
  public void update(Category category) {
    categoryDao.update(category);
  }

  @Override
  public void delete(Long categoryid) {
    categoryDao.delete(categoryid);
  }
}
