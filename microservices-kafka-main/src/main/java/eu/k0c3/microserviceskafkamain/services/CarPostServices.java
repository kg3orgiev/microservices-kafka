package eu.k0c3.microserviceskafkamain.services;

import eu.k0c3.microserviceskafkamain.client.CarPostStoreClient;
import eu.k0c3.microserviceskafkamain.dtos.CarPostDTO;
import eu.k0c3.microserviceskafkamain.dtos.OwnerPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarPostServices {
    private final CarPostStoreClient client;

    public List<CarPostDTO> getCarForSales() {

        return client.carForSalesClient();
    }

    public void ownerPost(OwnerPostDTO newOwnerPostDTO) {

        client.ownerPostClient(newOwnerPostDTO);
    }

    public void changeCarForSale(String id, CarPostDTO carPostDTO) {

        client.changeCarForSalesClient(id,carPostDTO);
    }

    public void deleteCarForSales(String id) {

        client.deleteCarForSalesClient(id);
    }
}
