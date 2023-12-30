package com.diplock.library.controllers;

import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.RoleEntity;
import com.diplock.library.entities.UserEntity;
import com.diplock.library.entities.enums.ERole;
import com.diplock.library.mapper.UserMapper;
import com.diplock.library.services.user.IUserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

  @Autowired
  private IUserService userService;

  @Autowired
  private UserMapper userMapper;

  @GetMapping("/hello")
  public String hello() {
    return "Hello world not Secured";
  }

  @GetMapping("/helloSecured")
  public String helloSecured() {
    return "Hello world Secured";
  }

  @GetMapping("/")
  public ResponseEntity<?> findAll() {

    final List<UserDTO> userList = userMapper.toDTOList(userService.findALl());

    return ResponseEntity.ok(userList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable final Long id) {
    final Optional<UserEntity> userOptional = this.userService.findById(id);

    if (userOptional.isPresent()) {
      final UserEntity userEntity = userOptional.get();

      final UserDTO userDTO = userMapper.userToDTO(userEntity);

      return ResponseEntity.ok(userDTO);
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createUser(@Valid @RequestBody final UserDTO userDTO){

    //final Set<RoleEntity> roles = this.userService.getRolesFromNames(userDTO.getRoles());
/*
    final UserEntity user = UserEntity.builder()
      .username(userDTO.getUsername())
      .password(userDTO.getPassword())
      .email(userDTO.getEmail())
      .roles(roles)
      .build();
*/
    final UserEntity user = userMapper.userToEntity(userDTO); // agregado

    this.userService.save(user);

    return ResponseEntity.ok(user);
  }



  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable final Long id) {
    final Optional<UserEntity> userOptional = this.userService.findById(id);

    if (!userOptional.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    this.userService.deleteById(id);

    return ResponseEntity.ok("Se ha borrado el usuario con id: " + id);
  }
}
