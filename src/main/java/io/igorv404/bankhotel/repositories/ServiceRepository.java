package io.igorv404.bankhotel.repositories;

import io.igorv404.bankhotel.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {}
