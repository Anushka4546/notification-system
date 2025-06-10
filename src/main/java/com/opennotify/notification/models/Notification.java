package com.opennotify.notification.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.opennotify.notification.enums.NotificationStatus;
import com.opennotify.notification.enums.NotificationType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue
    private UUID id;

    private String recipient;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private String subject;
    private String body;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    private LocalDateTime scheduledTime;
}
