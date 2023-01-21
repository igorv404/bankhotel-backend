package io.igorv404.bankhotel.services.implementations;

import io.igorv404.bankhotel.models.Amenities;
import io.igorv404.bankhotel.repositories.AmenitiesRepository;
import io.igorv404.bankhotel.services.AmenitiesService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AmenitiesServiceImpl implements AmenitiesService {
    private final AmenitiesRepository amenitiesRepository;

    public AmenitiesServiceImpl(AmenitiesRepository amenitiesRepository) {
        this.amenitiesRepository = amenitiesRepository;
    }

    @Override
    public List<Amenities> getAll() {
        return this.amenitiesRepository.findAll();
    }

    @Override
    public Amenities getById(String id) {
        return this.amenitiesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Amenities create(Amenities entity) {
        return this.amenitiesRepository.save(entity);
    }

    @Override
    public Amenities update(String id, Amenities entity) {
        Amenities updatedEntity = this.amenitiesRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        updatedEntity.setId(entity.getId());
        updatedEntity.setName(entity.getName());
        updatedEntity.setIcon(entity.getIcon());
        return this.amenitiesRepository.save(updatedEntity);
    }

    @Override
    public String delete(String id) {
        this.amenitiesRepository.deleteById(id);
        return String.format("%s%s", id, " was deleted");
    }
}
