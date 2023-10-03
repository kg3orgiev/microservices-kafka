package eu.k0c3.carstore.controller;

import eu.k0c3.carstore.dto.OwnerPostDTO;
import eu.k0c3.carstore.service.OwnerPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class OwnerPostController {
    private final OwnerPostService ownerPostService;

    @PostMapping
    public void changeCarSales(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createOwnerPost(ownerPostDTO);
    }
}
