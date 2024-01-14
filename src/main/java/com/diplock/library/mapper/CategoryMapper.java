package com.diplock.library.mapper;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDTO;
import com.diplock.library.entities.Category;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

  Category asEntity(CategoryDh categoryDh);

  CategoryDTO asDTO(Category category);

  List<Category> asEntityList(List<CategoryDh> categoryDhList);

  List<CategoryDTO> asDtoList(List<Category> categoryList);

}
