package com.diplock.library.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class PublisherDto {
    private Long publisherid;
    private String name;
    private String location;
    private String country;


}
