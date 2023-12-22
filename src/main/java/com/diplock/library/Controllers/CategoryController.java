package com.diplock.library.Controllers;

import com.diplock.library.Controllers.Dto.CategoryDTO;
import com.diplock.library.Entities.Category;
import com.diplock.library.Services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/find/{categoryid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable Long categoryid) {
      Optional<Category> categoryOptional = categoryService.findById(categoryid);

      if (categoryOptional.isPresent()) {
        Category category = categoryOptional.get();

        CategoryDTO categoryDTO = CategoryDTO.builder()
            .categoryid(category.getCategoryid())
            .name(category.getName())
            .subtopic(category.getSubtopic())
            .build();

        return ResponseEntity.ok(categoryDTO);
      }

      return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAll() {
      List<CategoryDTO> categoryList = categoryService.findAll()
          .stream()
          .map(category -> CategoryDTO.builder()
              .categoryid(category.getCategoryid())
              .name(category.getName())
              .subtopic(category.getSubtopic())
              .build())
          .toList();
      return ResponseEntity.ok(categoryList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO) {

      if (categoryDTO.getName().isBlank()) {
          return ResponseEntity.badRequest().build();
      }

      Category category = categoryService.save(Category.builder()
              .name(categoryDTO.getName())
              .subtopic(categoryDTO.getSubtopic())
              .build());

      CategoryDTO categoryReturnDTO = CategoryDTO.builder()
          .categoryid(category.getCategoryid())
          .name(category.getName())
          .subtopic(category.getSubtopic())
          .build();

      return ResponseEntity.ok(categoryReturnDTO);
    }

    @PutMapping("/update/{categoryid}")
    public ResponseEntity<?> update(@PathVariable Long categoryid, @RequestBody CategoryDTO categoryDTO) {
      Optional<Category> categoryOptional = categoryService.findById(categoryid);

      if (categoryOptional.isPresent()){
          Category category = categoryOptional.get();
          category.setName(categoryDTO.getName());
          category.setSubtopic(categoryDTO.getSubtopic());
          categoryService.update(category);
          return ResponseEntity.ok("Update registre");
      }

      return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{categoryid}")
    public ResponseEntity<?> deleteById(@PathVariable Long categoryid) {
      if (categoryid != null) {
        Optional<Category> categoryOptional = categoryService.findById(categoryid);

        if (categoryOptional.isPresent()){
          categoryService.delete(categoryid);
          return ResponseEntity.ok("Delete registre");
        }
      }

      return ResponseEntity.badRequest().build();
    }
}
