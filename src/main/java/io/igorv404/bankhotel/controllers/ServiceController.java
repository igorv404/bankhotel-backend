package io.igorv404.bankhotel.controllers;

import io.igorv404.bankhotel.models.Service;
import io.igorv404.bankhotel.services.ServiceService;
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
@RequestMapping(value = "/services")
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<List<Service>> getAll() {
        return new ResponseEntity<>(this.serviceService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private ResponseEntity<Service> getById(@PathVariable String id) {
        return new ResponseEntity<>(this.serviceService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    private ResponseEntity<Service> create(@RequestBody Service entity) {
        return new ResponseEntity<>(this.serviceService.create(entity), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private ResponseEntity<Service> update(@PathVariable String id, @RequestBody Service entity) {
        return new ResponseEntity<>(this.serviceService.update(id, entity), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private ResponseEntity<String> delete(@PathVariable String id) {
        Service responseEntity = this.serviceService.getById(id);
        return new ResponseEntity<>(responseEntity != null ? this.serviceService.delete(id) : String.format("%s%s", id, " not found"),
                responseEntity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
