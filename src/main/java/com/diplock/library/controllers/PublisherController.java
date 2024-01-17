package com.diplock.library.controllers;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.services.publisher.PublisherService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @NonNull
    private PublisherService publisherService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDto> createPublisher(@Valid @RequestBody final PublisherDh publisherDh) {
        return ResponseEntity.ok(this.publisherService.save(publisherDh));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDto> findPublisher(@Valid @PathVariable final Long id) {
        return ResponseEntity.ok(this.publisherService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PublisherDto>> findAllPublishers() {
        return ResponseEntity.ok(this.publisherService.findAll());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDto> updatePublisher(@Valid @PathVariable final Long id, @Valid @RequestBody final PublisherDh publisherDh) {
        return ResponseEntity.ok(this.publisherService.updateById(id , publisherDh));
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deletePublisher(@Valid @PathVariable final Long id) {
        return ResponseEntity.ok(this.publisherService.deleteById(id));
    }

}
