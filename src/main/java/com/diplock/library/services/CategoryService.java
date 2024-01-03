package com.diplock.library.services;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDTO;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> findAll();
  CategoryDTO findById(Long categoryid);
  CategoryDTO save(CategoryDh categoryDh);
  CategoryDTO update(Long categoryid, CategoryDh categoryDh);
  Boolean delete(Long categoryid);
}
