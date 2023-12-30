package com.diplock.library.services.user;

import com.diplock.library.entities.RoleEntity;
import com.diplock.library.entities.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IUserService {
  List<UserEntity> findALl();

  Optional<UserEntity> findById(Long id);

  Set<RoleEntity> getRolesFromNames(Set<String> roleNames);
  void save(UserEntity user);

  void deleteById(Long id);

}
