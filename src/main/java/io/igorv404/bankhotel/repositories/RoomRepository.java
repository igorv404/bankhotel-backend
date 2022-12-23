package io.igorv404.bankhotel.repositories;

import io.igorv404.bankhotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByUrl(String url);
}
