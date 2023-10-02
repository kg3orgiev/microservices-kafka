package com.k0c3.caranalytics.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand_analytics")
@Data
@NoArgsConstructor
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private Long posts;
}
