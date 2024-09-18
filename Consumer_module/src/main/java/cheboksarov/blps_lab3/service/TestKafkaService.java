package cheboksarov.blps_lab3.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestKafkaService {
    @KafkaListener(topics = "test_kafka_req", groupId = "req-processing")
    public void listen(String message){
        System.out.println("Message from the first service: " + message);
    }
}
