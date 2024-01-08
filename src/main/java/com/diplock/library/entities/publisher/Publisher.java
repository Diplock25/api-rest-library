package com.diplock.library.entities.publisher;

import com.diplock.library.entities.Book;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "publishers")
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "publisher_id")
  private Long publisherId;

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "location", length =  100)
  private String location;

  @Column(name = "country", length = 30)
  private String country;

  @OneToMany(mappedBy = "publishers" )
  private List<Book> books;
}
