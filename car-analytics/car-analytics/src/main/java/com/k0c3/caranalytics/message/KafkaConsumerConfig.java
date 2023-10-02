package com.k0c3.caranalytics.message;

import com.k0c3.caranalytics.dto.CarPostDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Properties;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public DefaultKafkaConsumerFactory<String, CarPostDTO> consumerFactory() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty("security.protocol", "SASL_SSL");
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username='2uwZI24oqOjvXRcEuv3f8r' password='eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiIydXdaSTI0b3FPanZYUmNFdXYzZjhyIiwib3JnYW5pemF0aW9uSWQiOjc2NDExLCJ1c2VySWQiOjg4OTAxLCJmb3JFeHBpcmF0aW9uQ2hlY2siOiIyOTEwN2Q0My1kM2VhLTRhZWItYjJiMS0wNzQ4YTgwOGY2NzgifX0.9TxtdquwD5UBfZNLYLRt9mXghFHzmeW_nx3CzLWto2I';");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "analytics-posts-group");

        //none - mean we can have groupId before start consumer .. otherwise fail
        //earliest - mean reading from the begging of my topic
        //latest - i want it to read it just from now.
        properties.setProperty("auto.offset.reset", "earliest");

        return new DefaultKafkaConsumerFactory(properties,
                new StringDeserializer(),
                new JsonDeserializer<>(CarPostDTO.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarPostDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CarPostDTO> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
