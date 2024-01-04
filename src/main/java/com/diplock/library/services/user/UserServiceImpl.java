package com.diplock.library.services.user;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.entities.User;
import com.diplock.library.entities.enums.ERole;
import com.diplock.library.mapper.UserMapper;
import com.diplock.library.repositories.RoleRepository;
import com.diplock.library.repositories.UserRepository;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @NonNull
  private UserRepository userRepository;

  @NonNull
  private RoleRepository roleRepository;

  @NonNull
  private UserMapper userMapper;

  @Override
  public List<UserDTO> findALl() {
    final List<User> users = (List<User>) this.userRepository.findAll();
    if (CollectionUtils.isEmpty(users)) {
      log.warn("There are no users in the database");
      return Collections.emptyList();
    } else {
      return this.userMapper.asDtoList(users);
    }
  }

  @Override
  public UserDTO findById(final Long id) {
    final Optional<User> userOptional = this.userRepository.findById(id);

    if (userOptional.isPresent()) {
      return userMapper.asDto(userOptional.get());
    }

    log.warn("There is no user in the database with the id: {}", id);
    return null;
  }

  @Override
  public UserDTO save(final UserDh userDh) {
    final User user = this.userMapper.asEntity(userDh);
    user.setRoles(getRolesFromNames(userDh.getRoles()));
    final User userSaved = this.userRepository.save(user);
    return this.userMapper.asDto(userSaved);
  }


  @Override
  public UserDTO update(UserDh userDh) {
    User user = userMapper.asEntity(userDh); // Remember that it ignores mapping for "roles".
    user.setRoles(getRolesFromNames(userDh.getRoles())); // Receive a Set<String>

    if (userRepository.existsById(user.getIdUser())) {
      return userMapper.asDto(userRepository.save(user));
    }

    log.warn("Update failed. There is no author in the database with the id: {}", userDh.getIdUser());
    return null;
  }

  @Override
  public UserDTO updateById(Long id, UserDh userDh) {

    Optional<User> optionalUser = userRepository.findById(id);

    if(optionalUser.isPresent()) {
      User user = optionalUser.get();

      if(userDh.getRoles() != null) {
        user.setRoles(getRolesFromNames(userDh.getRoles()));
      }

      userMapper.update(userDh, user);
      User updatedUser = userRepository.save(user);
      return userMapper.asDto(updatedUser);
    }

    return null;
  }

  @Override
  public Boolean deleteById(final Long id) {
    if (this.userRepository.existsById(id)) {
      this.userRepository.deleteById(id);
      return true;
    }
    log.warn("Delete failed. There is no user in the database with the id: {}", id);
    return false;
  }

  @Override
  public Set<Role> getRolesFromNames(final Set<String> roleNames) {
    return roleNames.stream()
      .map(name -> this.roleRepository.findByName(ERole.valueOf(name))
        .orElseGet(() -> {
          final Role newRole = new Role();
          newRole.setName(ERole.valueOf(name));
          return newRole;
        }))
      .collect(Collectors.toSet());
  }

}
