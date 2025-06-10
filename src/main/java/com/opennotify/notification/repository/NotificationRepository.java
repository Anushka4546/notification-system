package com.opennotify.notification.repository;

import com.opennotify.notification.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    
}
