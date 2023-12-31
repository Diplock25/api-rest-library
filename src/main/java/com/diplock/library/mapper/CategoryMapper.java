package com.diplock.library.mapper;

import com.diplock.library.dtos.CategoryDTO;
import com.diplock.library.entities.Category;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryDTO toDTO(Category category);
  List<CategoryDTO> toDTOList(List<Category> categoryList);
  Category toEntity(CategoryDTO categoryDTO);

}
