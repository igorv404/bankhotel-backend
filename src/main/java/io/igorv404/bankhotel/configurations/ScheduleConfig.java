package io.igorv404.bankhotel.configurations;

import io.igorv404.bankhotel.models.Event;
import io.igorv404.bankhotel.repositories.EventRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;

@Configuration
@EnableScheduling
public class ScheduleConfig {
    private final EventRepository eventRepository;

    public ScheduleConfig(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    private void deleteAllExpiredEntities() {
        LocalDate localDate = LocalDate.now();
        List<Event> entities = this.eventRepository.findAll();
        entities.stream()
                .filter(entity -> entity.getEndDate().isBefore(localDate))
                .forEach(entity -> this.eventRepository.deleteById(entity.getId()));
    }
}
