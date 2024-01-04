package com.diplock.library.dataholders;

import java.util.Set;
import lombok.Data;

@Data
public class UserDh {
  private Long idUser;
  private String username;
  private String email;
  private String password;
  private Set<String> roles;
}

