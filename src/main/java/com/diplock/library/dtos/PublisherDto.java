package com.diplock.library.dtos;

import com.diplock.library.entities.Book;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
public class PublisherDto {

    private Long publisherId;
    private String name;
    private String location;
    private String country;
    private List<Book> bookList;

}
