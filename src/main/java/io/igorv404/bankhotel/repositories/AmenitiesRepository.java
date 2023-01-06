package io.igorv404.bankhotel.repositories;

import io.igorv404.bankhotel.models.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, String> {}
