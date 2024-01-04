package com.diplock.library.services.user;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import java.util.List;
import java.util.Set;

public interface UserService {

  UserDTO save(UserDh userDh);

  //void saveAll(UserEntity user);

  UserDTO findById(Long id);

  List<UserDTO> findALl();

  UserDTO update(UserDh userDh);
  UserDTO updateById(Long id, UserDh userDh);

  Boolean deleteById(Long id);

  Set<Role> getRolesFromNames(Set<String> roleNames);
}
