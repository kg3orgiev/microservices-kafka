package eu.k0c3.microserviceskafkamain.messages;

import eu.k0c3.microserviceskafkamain.dtos.CarPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducerMessage {

    private final KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    public void sendMessage(CarPostDTO carPostDTO){
        String KAFKA_TOPIC = "car-post-topic";
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
