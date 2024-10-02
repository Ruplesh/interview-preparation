package com.example.interviewpreparation.controller.kafka;

import com.example.interviewpreparation.service.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }


    @GetMapping("/publish")
    public String publishMessage(@RequestParam(name = "message") String message) {
        kafkaProducerService.sendMessage("sampleTopic2", message);
        return "success";
    }

}
