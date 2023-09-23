package eu.k0c3.microserviceskafkamain.controllers;

import eu.k0c3.microserviceskafkamain.dtos.CarPostDTO;
import eu.k0c3.microserviceskafkamain.messages.KafkaProducerMessage;
import eu.k0c3.microserviceskafkamain.services.CarPostServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarPostController {
    private final KafkaProducerMessage kafkaProducerMessage;
    private final CarPostServices carPostServices;

    public CarPostController(KafkaProducerMessage kafkaProducerMessage,
                             CarPostServices carPostServices) {
        this.kafkaProducerMessage = kafkaProducerMessage;
        this.carPostServices = carPostServices;
    }

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return new ResponseEntity<>(carPostServices.getCarForSales(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarPostDTO> changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable String id) {
        carPostServices.changeCarForSale(id,carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarPostDTO> deleteCarSales(@PathVariable String id) {
        carPostServices.deleteCarForSales(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
