package io.igorv404.bankhotel.services.implementation;

import io.igorv404.bankhotel.models.Event;
import io.igorv404.bankhotel.repositories.EventRepository;
import io.igorv404.bankhotel.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event getByUrl(String url) {
        return this.eventRepository.findByUrl(url);
    }

    @Override
    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event getById(Integer id) {
        return this.eventRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Event create(Event entity) {
        return this.eventRepository.save(entity);
    }

    @Override
    public Event update(Integer id, Event entity) {
        Event updatedEntity = this.eventRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updatedEntity.setUrl(entity.getUrl());
        updatedEntity.setTitleImage(entity.getTitleImage());
        updatedEntity.setName(entity.getName());
        updatedEntity.setDescription(entity.getDescription());
        updatedEntity.setStartDate(entity.getStartDate());
        updatedEntity.setEndDate(entity.getEndDate());
        return this.eventRepository.save(updatedEntity);
    }

    @Override
    public String delete(Integer id) {
        this.eventRepository.deleteById(id);
        return String.format("%s%d%s", "Event with ID ", id, " was deleted");
    }
}
