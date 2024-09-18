package cheboksarov.blps_lab3.controller;


import cheboksarov.blps_lab3.service.TestKafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/test_kafka")
public class TestKafkaController {

    TestKafkaProducer testKafkaProducer;

    @GetMapping
    public ResponseEntity<?> testKafka(){
        testKafkaProducer.sendMessage("Hello from service one!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
