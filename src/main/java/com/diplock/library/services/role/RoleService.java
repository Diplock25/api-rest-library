package com.diplock.library.services.role;

import com.diplock.library.dtos.RoleDTO;
import java.util.List;

public interface RoleService {
  List<RoleDTO> findAll();

  RoleDTO findById(Long id);

}
