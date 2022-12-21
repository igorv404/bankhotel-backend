package io.igorv404.bankhotel.controllers;

import io.igorv404.bankhotel.models.Room;
import io.igorv404.bankhotel.services.RoomService;
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
@RequestMapping(value = "/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<List<Room>> getAll() {
        return new ResponseEntity<>(this.roomService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{url}")
    private ResponseEntity<Room> getByUrl(@PathVariable String url) {
        Room responseEntity = this.roomService.getByUrl(url);
        return new ResponseEntity<>(responseEntity, responseEntity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping
    private ResponseEntity<Room> create(@RequestBody Room entity) {
        return new ResponseEntity<>(this.roomService.create(entity), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    private ResponseEntity<Room> update(@PathVariable Integer id, @RequestBody Room entity) {
        return new ResponseEntity<>(this.roomService.update(id, entity), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    private ResponseEntity<String> delete(@PathVariable Integer id) {
        Room responseEntity = this.roomService.getById(id);
        return new ResponseEntity<>(responseEntity != null ? this.roomService.delete(id) : String.format("%s%d%s", "ID ", id, " not found"),
                responseEntity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
