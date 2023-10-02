package com.k0c3.caranalytics.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_model_analytics")
@Data
@NoArgsConstructor
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private Long posts;
}
