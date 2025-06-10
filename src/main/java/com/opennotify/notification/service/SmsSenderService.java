package com.opennotify.notification.service;

import com.opennotify.notification.models.Notification;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class SmsSenderService {
    public SmsSenderService(
        @Value("${twilio.account_sid}") String accountSid,
        @Value("${twilio.auth_token}") String authToken
    ) {
        Twilio.init(accountSid, authToken);
    }

    @Value("${twilio.from_number}")
    private String fromNumber;

    public void sendSms(Notification notification) {
        Message.creator(
            new PhoneNumber(notification.getRecipient()),
            new PhoneNumber(fromNumber),
            notification.getBody()
        ).create();
    }
}
