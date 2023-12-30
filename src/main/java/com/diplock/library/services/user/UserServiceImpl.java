package com.diplock.library.services.user;

import com.diplock.library.entities.RoleEntity;
import com.diplock.library.entities.UserEntity;
import com.diplock.library.entities.enums.ERole;
import com.diplock.library.repositories.RoleRepository;
import com.diplock.library.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public List<UserEntity> findALl() {
    return (List<UserEntity>) this.userRepository.findAll();
  }

  @Override
  public Optional<UserEntity> findById(final Long id) {
    return this.userRepository.findById(id);
  }

  @Override
  public Set<RoleEntity> getRolesFromNames(final Set<String> roleNames) {
    return roleNames.stream()
      .map(name -> this.roleRepository.findByName(ERole.valueOf(name))
        .orElseGet(() -> {
          final RoleEntity newRole = new RoleEntity();
          newRole.setName(ERole.valueOf(name));
          return newRole;
        }))
      .collect(Collectors.toSet());
  }

  @Override
  public void save(final UserEntity user) {
    this.userRepository.save(user);
  }

  @Override
  public void deleteById(final Long id) {
    this.userRepository.deleteById(id);
  }
}
