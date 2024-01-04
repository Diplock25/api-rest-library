package com.diplock.library.dtos;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {
  private Long idUser;
  private String username;
  private String email;
  private String password;
  private Set<String> roles;
}
