package eu.k0c3.carstore.controller;

import eu.k0c3.carstore.dto.CarPostDTO;
import eu.k0c3.carstore.service.CarPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class CarPostController {

    private final CarPostService carPostService;

    @GetMapping("/cars")
    public List<CarPostDTO> getCarSales(){
        return carPostService.getCarSales();
    }

    @PutMapping("/car/{id}")
    public void changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable Long id){
        carPostService.changeCarSales(carPostDTO, id);
    }

    @DeleteMapping("/car/{id}")
    public void deleteSales(@PathVariable Long id){
        carPostService.removeCarSales(id);
    }
}
