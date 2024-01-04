package com.diplock.library.controllers;

import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.services.role.RoleService;
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

  @GetMapping("/")
  public ResponseEntity<?> findAll() {
    final List<RoleDTO> userList = roleService.findAll();
    return ResponseEntity.ok(userList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findbyId(@PathVariable Long id) {
    RoleDTO role = roleService.findById(id);

    if (role == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("No user found with id: " + id);
    }

    return ResponseEntity.ok(role);
  }

}
