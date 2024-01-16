package com.diplock.library.services.category;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDto;
import java.util.List;

public interface CategoryService {

  List<CategoryDto> findAll();

  CategoryDto findById(Long id);

  CategoryDto save(CategoryDh categoryDh);

  CategoryDto update(Long id, CategoryDh categoryDh);

  Boolean delete(Long id);
}
