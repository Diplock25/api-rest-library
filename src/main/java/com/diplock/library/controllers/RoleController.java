package com.diplock.library.controllers;

import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.services.role.RoleService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/roles")
@RequiredArgsConstructor
public class RoleController {

  @NonNull
  private RoleService roleService;

  @GetMapping
  public ResponseEntity<List<RoleDTO>> findAll() {
    return ResponseEntity.ok(roleService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@Valid @PathVariable Long id) {
    return ResponseEntity.ok(roleService.findById(id));
  }

}
