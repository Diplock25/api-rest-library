package com.diplock.library.services.role;

import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.entities.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
  List<RoleDTO> findAll();

  RoleDTO findById(Long id);

}
