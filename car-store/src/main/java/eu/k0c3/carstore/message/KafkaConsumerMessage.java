package eu.k0c3.carstore.message;

import eu.k0c3.carstore.dto.CarPostDTO;
import eu.k0c3.carstore.service.CarPostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumerMessage {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerMessage.class.getName());
    private final CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPostDTO){
        log.info("Received Car Post information {}",carPostDTO);

        carPostService.createPostDetails(carPostDTO);
    }
}
