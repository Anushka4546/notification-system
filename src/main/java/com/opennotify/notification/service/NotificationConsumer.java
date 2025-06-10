package com.opennotify.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.opennotify.notification.models.Notification;

@Service
public class NotificationConsumer {

    public NotificationConsumer() {
       System.out.println("NotificationConsumer bean initialized!");
    }
    
    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(Notification notification) {
        System.out.println("Received notification from Kafka:");
        System.out.println(notification);
    }
}
