package com.diplock.library.services.category;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDto;
import com.diplock.library.entities.Category;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.exceptions.BdNotSaveException;
import com.diplock.library.mapper.CategoryMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.repositories.CategoryRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  @NonNull
  private final CategoryRepository categoryRepository;

  @NonNull
  private CategoryMapper categoryMapper;

  private BdParser bdParser = new BdParser();

  @Override
  public List<CategoryDto> findAll() {
    final List<Category> categoryList = (List<Category>) categoryRepository.findAll();
    if (CollectionUtils.isEmpty(categoryList)) {
      log.warn("There are no category in the database");
      return Collections.emptyList();
    } else {
      return categoryMapper.asDtoList(categoryList);
    }
  }

  @Override
  public CategoryDto findById(final Long id) {
    final Optional<Category> category = categoryRepository.findById(id);
    if (category.isPresent()) {
      return categoryMapper.asDTO(category.get());
    } else {

      throw new BdNotFoundException("GET - There is no category in the database with the id: " + id);
    }
  }

  @Override
  public CategoryDto save(final CategoryDh categoryDh) {
    bdParser.Evaluator(categoryDh, "POST");
    final Category category = categoryMapper.asEntity(categoryDh);
    final Category categorySaved = categoryRepository.save(category);
    return categoryMapper.asDTO(categorySaved);
  }

  @Override
  public CategoryDto update(final Long id, final CategoryDh categoryDh) {
    bdParser.Evaluator(categoryDh, "PUT");

    if (categoryDh.getCategoryId() != id) {
        throw new BdNotSaveException("PUT - Parameters are incorrect for field categorId: " + categoryDh.getCategoryId() + " is different at id: " + id);
    }

    final Category category = categoryMapper.asEntity(categoryDh);
    if (categoryRepository.existsById(id)) {
        return categoryMapper.asDTO(categoryRepository.save(category));
    }

    throw new BdNotFoundException("PUT - There is no category in the database with the id: " + id);
  }

  @Override
  public Boolean delete(Long id) {
    if (categoryRepository.existsById(id)) {
      categoryRepository.deleteById(id);
      return true;
    }
    throw new BdNotFoundException("DELETE - There is no category in the database with the id: " + id);
  }
}
