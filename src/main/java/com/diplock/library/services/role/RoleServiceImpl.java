package com.diplock.library.services.role;

import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.mapper.RoleMapper;
import com.diplock.library.repositories.RoleRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

  @NonNull
  private RoleRepository roleRepository;

  @NonNull
  private RoleMapper roleMapper;

  @Override
  public List<RoleDTO> findAll() {
    List<Role> roles = (List<Role>) this.roleRepository.findAll();

    if (CollectionUtils.isEmpty(roles)) {
      log.warn("There are no roles in the database");
      return Collections.emptyList();
    } else {
      return this.roleMapper.asDtoList(roles);
    }
  }

  @Override
  public RoleDTO findById(final Long id) {
    final Optional<Role> roleOptional = this.roleRepository.findById(id);

    if (roleOptional.isPresent()) {
      return this.roleMapper.asDto(roleOptional.get());
    }

    log.warn("There is no user in the database with the id: {}", id);
    return null;
  }

}
