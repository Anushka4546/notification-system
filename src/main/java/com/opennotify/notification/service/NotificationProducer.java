package com.opennotify.notification.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.opennotify.notification.models.Notification;

@Service
public class NotificationProducer {
    private final KafkaTemplate<String, Notification> kafkaTemplate;
    private final String topic = "notifications";

    public NotificationProducer(KafkaTemplate<String, Notification> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Notification notification) {
        kafkaTemplate.send(topic, notification);
    }
}
