package eu.k0c3.microserviceskafkamain.messages;

import eu.k0c3.microserviceskafkamain.dtos.CarPostDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {
    private final KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    public KafkaProducerMessage(KafkaTemplate<String, CarPostDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CarPostDTO carPostDTO){
        String KAFKA_TOPIC = "car-post-topic";
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
