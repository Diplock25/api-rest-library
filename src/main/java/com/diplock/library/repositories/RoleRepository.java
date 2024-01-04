package com.diplock.library.repositories;

import com.diplock.library.entities.Role;
import com.diplock.library.entities.enums.ERole;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
