package eu.k0c3.microserviceskafkamain.controllers;

import eu.k0c3.microserviceskafkamain.dtos.CarPostDTO;
import eu.k0c3.microserviceskafkamain.messages.KafkaProducerMessage;
import eu.k0c3.microserviceskafkamain.services.CarPostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarPostController {

    private final KafkaProducerMessage kafkaProducerMessage;
    private final CarPostServices carPostServices;

    @PostMapping("/post")
    public void postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
    }
    @GetMapping("/posts")
    public List<CarPostDTO> getCarSales() {
        return carPostServices.getCarForSales();
    }

    @PutMapping("/{id}")
    public void changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable String id) {
        carPostServices.changeCarForSale(id,carPostDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCarSales(@PathVariable String id) {
        carPostServices.deleteCarForSales(id);
    }
}
