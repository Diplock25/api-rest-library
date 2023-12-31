package com.diplock.library.controllers;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.services.publisher.PublisherService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/publisher")
public class PublisherController {

    @NonNull
    private PublisherService publisherService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PublisherDto> createPublisher(@Valid @RequestBody final PublisherDh publisherDh) {
        return ResponseEntity.ok(this.publisherService.save(publisherDh));
    }

    @PostMapping(value = "/create/all", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<PublisherDto>> createPublishers(
            @Valid @RequestBody final List<PublisherDh> publisherDhList) {
        return ResponseEntity.ok(this.publisherService.saveAll(publisherDhList));
    }

    @GetMapping(value = "/find/{id}", produces = "application/json")
    public ResponseEntity<PublisherDto> findPublisher(@Valid @PathVariable final Long id) {
        return ResponseEntity.ok(this.publisherService.findById(id));
    }

    @PostMapping(value = "/find", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<PublisherDto>> findPublishers(@Valid @RequestBody final List<Long> ids) {
        return ResponseEntity.ok(this.publisherService.findByIds(ids));
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<PublisherDto>> findAllPublishers() {
        return ResponseEntity.ok(this.publisherService.findAll());
    }


    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PublisherDto> updatePublisher(@Valid @RequestBody final PublisherDh publisherDh) {
        return ResponseEntity.ok(this.publisherService.update(publisherDh));
    }

    @PutMapping(value = "/update/all", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<PublisherDto>> updatePublishers(
            @Valid @RequestBody final List<PublisherDh> publisherDhList) {
        return ResponseEntity.ok(this.publisherService.updateAll(publisherDhList));
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deletePublisher(@Valid @PathVariable final Long id) {
        return ResponseEntity.ok(this.publisherService.deleteById(id));
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> deletePublishers(@Valid @RequestBody final List<Long> ids) {
        this.publisherService.deleteByIds(ids);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping(value = "/delete/all", produces = "application/json")
    public ResponseEntity<Boolean> deleteAllPublishers() {
        this.publisherService.deleteAll();
        return ResponseEntity.ok(true);
    }
}
