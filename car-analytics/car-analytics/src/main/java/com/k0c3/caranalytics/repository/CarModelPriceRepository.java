package com.k0c3.caranalytics.repository;

import com.k0c3.caranalytics.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPriceEntity, Long> {
    Optional<CarModelPriceEntity> findByBrand(String brand);
}
