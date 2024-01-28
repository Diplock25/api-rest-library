package com.diplock.library.parsers;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.exceptions.CategoryNotSaveException;
import java.util.Objects;

public class CategoryParser {
    public void Evaluator(CategoryDh categoryDh) {
    if (Objects.equals(categoryDh.getName(), null)) {
      throw new CategoryNotSaveException("PUT - Parameters are incorrect for field name - name is null");
    } else if (categoryDh.getName().isBlank()) {
      throw new CategoryNotSaveException("PUT - Parameters are incorrect for field name - name is blank");
    }
  }

}
