package io.igorv404.bankhotel.services.implementation;

import io.igorv404.bankhotel.models.Room;
import io.igorv404.bankhotel.repositories.RoomRepository;
import io.igorv404.bankhotel.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room getByUrl(String url) {
        return this.roomRepository.findByUrl(url);
    }

    @Override
    public List<Room> getAll() {
        return this.roomRepository.findAll();
    }

    @Override
    public Room getById(Integer id) {
        return this.roomRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Room create(Room entity) {
        return this.roomRepository.save(entity);
    }

    @Override
    public Room update(Integer id, Room entity) {
        Room updatedRoom = this.roomRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updatedRoom.setName(entity.getName());
        updatedRoom.setImages(entity.getImages());
        updatedRoom.setDescription(entity.getDescription());
        updatedRoom.setServices(entity.getServices());
        return this.roomRepository.save(updatedRoom);
    }

    @Override
    public String delete(Integer id) {
        this.roomRepository.deleteById(id);
        return String.format("%s%d%s", "Room with ID ", id, " was deleted");
    }
}
