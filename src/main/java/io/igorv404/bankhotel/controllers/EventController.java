package io.igorv404.bankhotel.controllers;

import io.igorv404.bankhotel.models.Event;
import io.igorv404.bankhotel.services.EventService;
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
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<List<Event>> getAll() {
        return new ResponseEntity<>(this.eventService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/url/{url}")
    private ResponseEntity<Event> getByUrl(@PathVariable String url) {
        Event responseEntity = this.eventService.getByUrl(url);
        return new ResponseEntity<>(responseEntity, responseEntity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    private ResponseEntity<Event> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.eventService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    private ResponseEntity<Event> create(@RequestBody Event entity) {
        return new ResponseEntity<>(this.eventService.create(entity), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private ResponseEntity<Event> update(@PathVariable Integer id, @RequestBody Event entity) {
        return new ResponseEntity<>(this.eventService.update(id, entity), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private ResponseEntity<String> delete(@PathVariable Integer id) {
        Event responseEntity = this.eventService.getById(id);
        return new ResponseEntity<>(responseEntity != null ? this.eventService.delete(id) :
                String.format("%s%d%s", "ID ", id, " not found"),
                responseEntity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
