package com.k0c3.caranalytics.service;

import com.k0c3.caranalytics.dto.CarPostDTO;
import com.k0c3.caranalytics.entity.BrandAnalyticsEntity;
import com.k0c3.caranalytics.entity.CarModelAnalyticsEntity;
import com.k0c3.caranalytics.entity.CarModelPriceEntity;
import com.k0c3.caranalytics.repository.BrandAnalyticsRepository;
import com.k0c3.caranalytics.repository.CarModelAnalyticsRepository;
import com.k0c3.caranalytics.repository.CarModelPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostAnalyticsServer {

    private final BrandAnalyticsRepository brandAnalyticsRepository;
    private final CarModelAnalyticsRepository carModelAnalyticsRepository;
    private final CarModelPriceRepository carModelPriceRepository;

    public void saveDataAnalytics(CarPostDTO carPostDTO) {

        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());

    }

    private void saveModelPriceAnalytics(String model, Double price) {
        var carModelPrice = new CarModelPriceEntity();

        carModelPrice.setPrice(price);
        carModelPrice.setBrand(model);

        carModelPriceRepository.save(carModelPrice);
    }

    private void saveCarModelAnalytics(String model) {
        var carAnalyticsPrice = new CarModelAnalyticsEntity();
        carModelAnalyticsRepository.findByBrand(model)
                .ifPresentOrElse(item -> {
                    item.setPosts(item.getPosts() + 1);
                }, () -> {
                    carAnalyticsPrice.setBrand(model);
                    carAnalyticsPrice.setPosts(1L);
                });

        carModelAnalyticsRepository.save(carAnalyticsPrice);
    }

    private void saveBrandAnalytics(String brand) {
        var brandAnalytics = new BrandAnalyticsEntity();
        brandAnalyticsRepository.findByBrand(brand)
                .ifPresentOrElse(item -> {
                    item.setPosts(item.getPosts() + 1);
                }, () -> {
                    brandAnalytics.setBrand(brand);
                    brandAnalytics.setPosts(1L);
                });

        brandAnalyticsRepository.save(brandAnalytics);
    }
}
