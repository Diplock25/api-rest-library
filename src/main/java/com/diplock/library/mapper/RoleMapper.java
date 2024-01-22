package com.diplock.library.mapper;

import com.diplock.library.dataholders.RoleDh;
import com.diplock.library.dtos.RoleDTO;
import com.diplock.library.entities.Role;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;


@Mapper(componentModel = ComponentModel.SPRING)
public interface RoleMapper {
  RoleDTO asDto(Role role);

  Role asEntity(RoleDh roleDh);

  List<RoleDTO> asDtoList (List<Role> roles);

  List<Role> asEntityList (List<RoleDh> roleDhs);

}
