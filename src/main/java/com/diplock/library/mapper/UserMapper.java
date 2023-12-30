package com.diplock.library.mapper;

import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.RoleEntity;
import com.diplock.library.entities.UserEntity;
import com.diplock.library.entities.enums.ERole;
import com.diplock.library.repositories.RoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

  @Mapping(source = "roles", target = "roles", qualifiedByName="toStrings")
  UserDTO userToDTO(UserEntity user);

  @InheritInverseConfiguration
  @Mapping(target = "roles", source = "roles", qualifiedByName="toEntities")
  UserEntity userToEntity(UserDTO userDTO);

  List<UserDTO> toDTOList (List<UserEntity> entityList);

  List<UserEntity> toEntityList (List<UserDTO> dtoList);

  @Named("toStrings")
  static Set<String> mapToStrings(Set<RoleEntity> roles) {
    Set<String> roleNames = new HashSet<>();
    if (roles != null) {
      for (RoleEntity role : roles) {
        roleNames.add(role.getName().toString());
      }
    }
    return roleNames;
  }

  @Named("toEntities")
  static Set<RoleEntity> mapToEntities(Set<String> roleNames) {

    Set<RoleEntity> roles = new HashSet<>();
    if (roleNames != null) {
      for (String name : roleNames) {
        RoleEntity role = new RoleEntity();
        role.setName(ERole.valueOf(name));
        roles.add(role);
      }
    }
/*
    Set<RoleEntity> roles = roleNames.stream()
      .map(name -> this.roleRepository.findByName(ERole.valueOf(name))
        .orElseGet(() -> {
          final RoleEntity newRole = new RoleEntity();
          newRole.setName(ERole.valueOf(name));
          return newRole;
        }))
      .collect(Collectors.toSet());
*/
    return roles;
  }


}
