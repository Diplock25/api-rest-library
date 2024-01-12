package com.diplock.library.dtos;

import lombok.*;

@Data
@NoArgsConstructor
public class PublisherDto {

    private Long publisherId;
    private String name;
    private String location;
    private String country;


}
