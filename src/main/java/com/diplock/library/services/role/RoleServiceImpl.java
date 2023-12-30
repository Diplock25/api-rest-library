package com.diplock.library.services.role;

import com.diplock.library.entities.RoleEntity;
import com.diplock.library.repositories.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public List<RoleEntity> findAll() {
    return (List<RoleEntity>) this.roleRepository.findAll();
  }

  @Override
  public Optional<RoleEntity> findById(final Long id) {
    return this.roleRepository.findById(id);
  }

  @Override
  public void deleteById(final Long id) {
    this.roleRepository.deleteById(id);
  }
}
