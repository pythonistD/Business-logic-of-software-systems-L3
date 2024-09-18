package cheboksarov.blps_lab3.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopics(){
        return new NewTopic(
                "test_kafka_req",
                1,
                (short) 1
        );
    }
}
