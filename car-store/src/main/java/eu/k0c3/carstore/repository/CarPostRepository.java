package eu.k0c3.carstore.repository;

import eu.k0c3.carstore.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
}
