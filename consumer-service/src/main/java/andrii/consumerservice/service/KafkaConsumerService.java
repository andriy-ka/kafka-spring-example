package andrii.consumerservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "best-topic", groupId = "consumer-group")
    public void consume(String message) {
        System.out.println("Message received: " + message);
        processMessage(message);
    }

    private void processMessage(String message) {
        System.out.println("Process message: " + message);
    }
}
