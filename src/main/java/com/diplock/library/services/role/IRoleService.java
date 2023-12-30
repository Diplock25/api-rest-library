package com.diplock.library.services.role;

import com.diplock.library.entities.RoleEntity;
import java.util.List;
import java.util.Optional;

public interface IRoleService {
  List<RoleEntity> findAll();

  Optional<RoleEntity> findById(Long id);

  void deleteById(Long id);


}
