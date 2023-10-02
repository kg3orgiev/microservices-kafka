package eu.k0c3.carstore.controller;

import eu.k0c3.carstore.dto.OwnerPostDTO;
import eu.k0c3.carstore.service.OwnerPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class OwnerPostController {
    private final OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity changeCarSales(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createOwnerPost(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
