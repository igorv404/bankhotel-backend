package io.igorv404.bankhotel.services.implementation;

import io.igorv404.bankhotel.repositories.ServiceRepository;
import io.igorv404.bankhotel.services.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<io.igorv404.bankhotel.models.Service> getAll() {
        return this.serviceRepository.findAll();
    }

    @Override
    public io.igorv404.bankhotel.models.Service getById(String id) {
        return this.serviceRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public io.igorv404.bankhotel.models.Service create(io.igorv404.bankhotel.models.Service entity) {
        return this.serviceRepository.save(entity);
    }

    @Override
    public io.igorv404.bankhotel.models.Service update(String id, io.igorv404.bankhotel.models.Service entity) {
        io.igorv404.bankhotel.models.Service updatedService = this.serviceRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        updatedService.setId(entity.getId());
        updatedService.setName(entity.getName());
        return this.serviceRepository.save(updatedService);
    }

    @Override
    public String delete(String id) {
        this.serviceRepository.deleteById(id);
        return String.format("%s%s", id, " was deleted");
    }
}
