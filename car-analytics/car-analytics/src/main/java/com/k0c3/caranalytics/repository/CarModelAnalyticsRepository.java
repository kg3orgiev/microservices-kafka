package com.k0c3.caranalytics.repository;

import com.k0c3.caranalytics.entity.CarModelAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelAnalyticsRepository  extends JpaRepository<CarModelAnalyticsEntity, Long> {
    Optional<CarModelAnalyticsEntity> findByBrand(String brand);
}
