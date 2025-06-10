package com.opennotify.notification.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opennotify.notification.models.Notification;
import com.opennotify.notification.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService service;
    

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification create(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable UUID id) {
        return service.getById(id);
    }
}
