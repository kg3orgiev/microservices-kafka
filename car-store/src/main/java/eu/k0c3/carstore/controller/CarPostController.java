package eu.k0c3.carstore.controller;

import eu.k0c3.carstore.dto.CarPostDTO;
import eu.k0c3.carstore.service.CarPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class CarPostController {

    private final CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.getCarSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity changeCarSales(CarPostDTO carPostDTO, @PathVariable Long id){
        carPostService.changeCarSales(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteSales(@PathVariable Long id){
        carPostService.removeCarSales(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
