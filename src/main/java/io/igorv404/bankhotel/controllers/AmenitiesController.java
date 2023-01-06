package io.igorv404.bankhotel.controllers;

import io.igorv404.bankhotel.models.Amenities;
import io.igorv404.bankhotel.services.AmenitiesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/amenities")
public class AmenitiesController {
    private final AmenitiesService amenitiesService;

    public AmenitiesController(AmenitiesService amenitiesService) {
        this.amenitiesService = amenitiesService;
    }

    @GetMapping
    private ResponseEntity<List<Amenities>> getAll() {
        return new ResponseEntity<>(this.amenitiesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Amenities> getById(@PathVariable String id) {
        return new ResponseEntity<>(this.amenitiesService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Amenities> create(@Valid @RequestBody Amenities entity) {
        return new ResponseEntity<>(this.amenitiesService.create(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Amenities> update(@PathVariable String id, @Valid @RequestBody Amenities entity) {
        return new ResponseEntity<>(this.amenitiesService.update(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> delete(@PathVariable String id) {
        Amenities responseEntity = this.amenitiesService.getById(id);
        return new ResponseEntity<>(responseEntity != null ? this.amenitiesService.delete(id) : String.format("%s%s", id, " not found"),
                responseEntity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
