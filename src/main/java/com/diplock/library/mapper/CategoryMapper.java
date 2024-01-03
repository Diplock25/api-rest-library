package com.diplock.library.mapper;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDTO;
import com.diplock.library.entities.category.Category;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  Category asEntity(CategoryDh categoryDh);
  CategoryDTO asDTO(Category category);
  List<Category> asEntityList(List<CategoryDh> categoryDhList);
  List<CategoryDTO> asDtoList(List<Category> categoryList);

}
