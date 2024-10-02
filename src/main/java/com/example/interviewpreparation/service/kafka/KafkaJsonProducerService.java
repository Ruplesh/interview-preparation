package com.example.interviewpreparation.service.kafka;

import com.example.interviewpreparation.entity.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducerService {

    private KafkaTemplate<String, Employee> kafkaTemplate;

    public KafkaJsonProducerService(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendEmployeeToKafka(Employee employee) {
        Message<Employee> employeeMessage = MessageBuilder.withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, "sampleTopicForJson")
                .build();

        kafkaTemplate.send(employeeMessage);
    }
}
