package io.igorv404.bankhotel.repositories;

import io.igorv404.bankhotel.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findByUrl(String url);
}
