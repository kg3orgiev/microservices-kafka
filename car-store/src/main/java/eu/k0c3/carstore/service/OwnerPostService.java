package eu.k0c3.carstore.service;

import eu.k0c3.carstore.repository.OwnerPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerPostService {

    private final OwnerPostRepository ownerPostRepository;

}
