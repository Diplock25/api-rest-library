package com.diplock.library.services.category;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDTO;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> findAll();

  CategoryDTO findById(Long id);

  CategoryDTO save(CategoryDh categoryDh);

  CategoryDTO update(Long id, CategoryDh categoryDh);

  Boolean delete(Long id);
}
