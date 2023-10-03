package eu.k0c3.microserviceskafkamain.controllers;

import eu.k0c3.microserviceskafkamain.dtos.OwnerPostDTO;
import eu.k0c3.microserviceskafkamain.services.OwnerPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner")
public class OwnerPostController {

    private final OwnerPostService ownerPostService;

    @PostMapping
    public void createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostService.createOwnerCar(ownerPostDTO);
    }
}
