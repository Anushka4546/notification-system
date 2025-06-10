package com.opennotify.notification.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.opennotify.notification.models.Notification;
import com.opennotify.notification.repository.NotificationRepository;

@Service
public class NotificationService {
    private final NotificationRepository repository;
    
    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification create(Notification notification) {
        return repository.save(notification);
    }

    public List<Notification> getAll() {
        return repository.findAll();
    }

    public Notification getById(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
