package com.diplock.library.exceptions;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiError {

  private String message;

  private String description;

  private LocalDate date;

}
