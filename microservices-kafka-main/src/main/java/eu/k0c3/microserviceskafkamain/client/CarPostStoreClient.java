package eu.k0c3.microserviceskafkamain.client;

import eu.k0c3.microserviceskafkamain.dtos.CarPostDTO;
import eu.k0c3.microserviceskafkamain.dtos.OwnerPostDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {
    private final String POST_STORE_SERVICE_URL = "http://localhost:8080/sales";
    private final RestTemplate restTemplate;

    public CarPostStoreClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<CarPostDTO> carForSalesClient() {
        ResponseEntity<CarPostDTO[]> responseEntity =
                restTemplate.getForEntity(POST_STORE_SERVICE_URL + "/cars", CarPostDTO[].class);

        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostClient(OwnerPostDTO newOwnerPostDTO) {
        String USER_STORE_SERVICE_URL = "http://localhost:8080/user";
        restTemplate.postForEntity(USER_STORE_SERVICE_URL, newOwnerPostDTO, OwnerPostDTO.class);
    }

    public void changeCarForSalesClient(String id, CarPostDTO carPostDTO) {
        restTemplate.put(POST_STORE_SERVICE_URL + "/car/" + id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSalesClient(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URL + "/car/" + id);
    }
}
