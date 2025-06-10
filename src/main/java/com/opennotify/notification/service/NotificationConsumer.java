package com.opennotify.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.opennotify.notification.enums.NotificationType;
import com.opennotify.notification.models.Notification;

@Service
public class NotificationConsumer {

    private final EmailSenderService emailSenderService;
    private final SmsSenderService smsSenderService;
    private final PushSenderService pushSenderService;

    public NotificationConsumer(EmailSenderService emailSenderService, SmsSenderService smsSenderService, PushSenderService pushSenderService) {
        this.emailSenderService = emailSenderService;
        this.smsSenderService = smsSenderService;
        this.pushSenderService = pushSenderService;
    }
    
    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(Notification notification) {
        System.out.println("Received notification from Kafka:" + notification);
        if(notification.getType() == NotificationType.EMAIL) {
            emailSenderService.sendEmail(notification);
        } else if(notification.getType() == NotificationType.SMS) {
            smsSenderService.sendSms(notification);
        } else if(notification.getType() == NotificationType.PUSH) {
            pushSenderService.sendPush(notification);
        }
    }
}
