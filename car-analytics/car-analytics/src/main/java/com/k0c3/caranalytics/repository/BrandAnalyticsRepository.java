package com.k0c3.caranalytics.repository;

import com.k0c3.caranalytics.entity.BrandAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalyticsRepository  extends JpaRepository<BrandAnalyticsEntity, Long> {
    Optional<BrandAnalyticsEntity> findByBrand(String brand);
}
