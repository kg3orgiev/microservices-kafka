package eu.k0c3.carstore.service;

import eu.k0c3.carstore.dto.CarPostDTO;
import eu.k0c3.carstore.entity.CarPostEntity;
import eu.k0c3.carstore.repository.CarPostRepository;
import eu.k0c3.carstore.repository.OwnerPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarPostService {

    private final CarPostRepository carPostRepository;
    private final OwnerPostRepository ownerPostRepository;
    private final ModelMapper modelMapper;

    public void createPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity entity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(entity);
    }

    public List<CarPostDTO> getCarSales() {
        return carPostRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarPostDTO.class))
                .collect(Collectors.toList());
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {
        var carPostEntity =CarPostEntity.builder();
        ownerPostRepository.findById(carPostDTO.getOwnerId())
                .ifPresentOrElse(owner -> {
                            carPostEntity.ownerPost(owner);
                            carPostEntity.contact(owner.getContactNumber());
                        },
                        () -> {
                            throw new NoSuchElementException();
                        });
        carPostEntity.model(carPostDTO.getModel());
        carPostEntity.brand(carPostDTO.getBrand());
        carPostEntity.price(carPostDTO.getPrice());
        carPostEntity.city(carPostDTO.getCity());
        carPostEntity.description(carPostDTO.getDescription());
        carPostEntity.engineVersion(carPostDTO.getEngineVersion());
        carPostEntity.createdDate(String.valueOf(new Date()));

        return carPostEntity.build();
    }

    public void changeCarSales(CarPostDTO carPostDTO, Long id) {

        var carEntityToChange = carPostRepository.findById(id).orElseThrow(NoSuchElementException::new);

        carEntityToChange.setDescription(carPostDTO.getDescription());
        carEntityToChange.setContact(carPostDTO.getContact());
        carEntityToChange.setPrice(carPostDTO.getPrice());

        carPostRepository.save(carEntityToChange);
    }

    public void removeCarSales(Long id) {
        carPostRepository.deleteById(id);
    }
}
