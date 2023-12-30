package com.diplock.library.repositories;

import com.diplock.library.entities.RoleEntity;
import com.diplock.library.entities.enums.ERole;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
  Optional<RoleEntity> findByName(ERole name);
}
