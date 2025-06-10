package com.opennotify.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.opennotify.notification.enums.NotificationType;
import com.opennotify.notification.models.Notification;

@Service
public class NotificationConsumer {

    private final EmailSenderService emailSenderService;

    public NotificationConsumer(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
    
    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(Notification notification) {
        System.out.println("Received notification from Kafka:" + notification);
        if(notification.getType() == NotificationType.EMAIL) {
            emailSenderService.sendEmail(notification);
        }
    }
}
