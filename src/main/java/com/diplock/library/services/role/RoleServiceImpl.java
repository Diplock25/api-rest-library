package com.diplock.library.services.role;

import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import com.diplock.library.exceptions.BdNotFoundException;
import com.diplock.library.mapper.RoleMapper;
import com.diplock.library.parsers.BdParser;
import com.diplock.library.repositories.RoleRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

  @NonNull
  private RoleRepository roleRepository;

  @NonNull
  private RoleMapper roleMapper;

  private BdParser bdParser = new BdParser();

  @Override
  public List<RoleDTO> findAll() {
    List<Role> roles = (List<Role>) this.roleRepository.findAll();

    if (CollectionUtils.isEmpty(roles)) {
      log.warn("There are no roles in the database");
      return Collections.emptyList();
    }

    return this.roleMapper.asDtoList(roles);
  }

  @Override
  public RoleDTO findById(final Long id) {
    final Optional<Role> role = this.roleRepository.findById(id);
    final boolean isPresent = role.isPresent();

    if (isPresent) {
      return this.roleMapper.asDto(role.get());
    } else {
      throw new BdNotFoundException("GET - There is no role in the database with the id: " + id);
    }
  }

}
