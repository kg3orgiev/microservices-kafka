package eu.k0c3.carstore.service;

import eu.k0c3.carstore.dto.OwnerPostDTO;
import eu.k0c3.carstore.entity.OwnerPostEntity;
import eu.k0c3.carstore.repository.OwnerPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerPostService {

    private final OwnerPostRepository ownerPostRepository;
    private final ModelMapper modelMapper;

    public void createOwnerPost(OwnerPostDTO ownerPostDTO){
        OwnerPostEntity ownerPost = modelMapper.map(ownerPostDTO, OwnerPostEntity.class);
        ownerPostRepository.save(ownerPost);
    }
}
