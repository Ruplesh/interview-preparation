package com.example.interviewpreparation.service.kafka;

import com.example.interviewpreparation.entity.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerJsonService {

    @KafkaListener(topics = "sampleTopicForJson", groupId = "jsonCommonGroup")
    public void consume(Employee employee) {
        System.out.println(employee);
    }
}
