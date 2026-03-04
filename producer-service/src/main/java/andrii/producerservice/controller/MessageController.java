package andrii.producerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import andrii.producerservice.service.KafkaProducerService;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
    }

    @GetMapping("/health")
    public String health() {
        return "Producer service is running";
    }
}
