package com.opennotify.notification.service;

import org.springframework.stereotype.Service;
import com.opennotify.notification.models.Notification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

@Service
public class PushSenderService {
    public void sendPush(Notification notification) {
        Message msg = Message.builder()
                        .setToken(notification.getRecipient())
                        .putData("title", notification.getSubject())
                        .putData("body", notification.getBody())
                        .build();
        
        try {
            FirebaseMessaging.getInstance().send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
