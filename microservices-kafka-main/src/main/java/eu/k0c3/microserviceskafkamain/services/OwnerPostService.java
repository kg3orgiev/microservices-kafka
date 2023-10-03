package eu.k0c3.microserviceskafkamain.services;

import eu.k0c3.microserviceskafkamain.client.CarPostStoreClient;
import eu.k0c3.microserviceskafkamain.dtos.OwnerPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerPostService {
    private final CarPostStoreClient client;
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        client.ownerPostClient(ownerPostDTO);
    }
}
