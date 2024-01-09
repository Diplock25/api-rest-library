package com.diplock.library.services.user;

import com.diplock.library.dataholders.UserDh;
import com.diplock.library.dtos.UserDTO;
import com.diplock.library.entities.Role;
import java.util.List;
import java.util.Set;

public interface UserService {

  UserDTO save(UserDh userDh);

  UserDTO findById(Long id);

  List<UserDTO> findALl();

  UserDTO update(Long id, UserDh userDh);
  UserDTO updateById(Long id, UserDh userDh);

  Boolean deleteById(Long id);
}
