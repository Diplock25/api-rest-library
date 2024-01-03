package com.diplock.library.controllers;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDTO;

import com.diplock.library.services.CategoryService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("category")
public class CategoryController {

    @NonNull
    private final CategoryService categoryService;


    // Se establece explícitamente, si la lógica del método se completa correctamente,
    // enviando una respuesta con un código de estado HTTP 200
    @GetMapping(value = "/{categoryid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoryDTO> findById(@PathVariable("categoryid") final Long categoryid) {
        return ResponseEntity.ok(categoryService.findById(categoryid));
    }


    // Se establece explícitamente, si la lógica del método se completa correctamente,
    // enviando una respuesta con un código de estado HTTP 200
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoryDTO>> findAll() {
          return ResponseEntity.ok(categoryService.findAll());
    }


    // Se establece explícitamente que, si la lógica del método se completa correctamente
    // y se crea un nuevo recurso, se enviará una respuesta con un código de estado
    // HTTP 201 (CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody final CategoryDh categoryDh) {
      return ResponseEntity.ok(categoryService.save(categoryDh));
    }


    // Se establece explícitamente, si la lógica del método se completa correctamente,
    // enviando una respuesta con un código de estado HTTP 200
    @PutMapping(value = "/{categoryid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoryDTO> update(@PathVariable("categoryid") final Long categoryid, @RequestBody final CategoryDh categoryDh) {
          return ResponseEntity.ok(categoryService.update(categoryid, categoryDh));
    }


    // Si la lógica de búsqueda determina que el recurso no existe, se activará la excepción.
    // La excepción se capturará y se enviará una respuesta con un código de estado HTTP 404.
    @DeleteMapping(value = "/{categoryid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Boolean> deleteById(@PathVariable("categoryid") final Long categoryid) {
          return ResponseEntity.ok(categoryService.delete(categoryid));
    }

}
