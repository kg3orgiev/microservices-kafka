package com.k0c3.caranalytics.message;

import com.k0c3.caranalytics.dto.CarPostDTO;
import com.k0c3.caranalytics.service.PostAnalyticsServer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumerMessage {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerMessage.class.getName());
    private final PostAnalyticsServer postAnalyticsServer;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(CarPostDTO carPostDTO){
        log.info("Received Car Post information for analytics {}",carPostDTO);
        postAnalyticsServer.saveDataAnalytics(carPostDTO);
    }
}
