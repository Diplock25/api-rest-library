package com.diplock.library.controllers;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.services.user.UserService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

  @NonNull
  private UserService userService;


  @GetMapping("/")
  public ResponseEntity<?> findAll() {
    final List<UserDTO> userList = userService.findALl();
    return ResponseEntity.ok(userList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable final Long id) {
    UserDTO user = userService.findById(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("No user found with id: " + id);
    }
    return ResponseEntity.ok(user);
  }

  @PostMapping("/")
  public ResponseEntity<?> createUser(@Valid @RequestBody final UserDh userDh){
    final UserDTO user = userService.save(userDh);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(user.getIdUser())
      .toUri();

    return ResponseEntity.created(location).body(user);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDh userDh) {
    UserDTO updatedUser = userService.updateById(id, userDh);
    if (updatedUser == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("No user found with id: " + id);
    }
    return ResponseEntity.ok(updatedUser);
  }

  @PutMapping("/")
  public ResponseEntity<?> updateUser(@Valid @RequestBody UserDh userDh) {
    UserDTO user = userService.update(userDh);

    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("No user found with id: " + userDh.getIdUser());
    }

    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable final Long id) {
    if (userService.deleteById(id)) {
      return ResponseEntity.ok()
        .body("User deleted successfully");
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body("No user found with id: " + id);

  }
}
