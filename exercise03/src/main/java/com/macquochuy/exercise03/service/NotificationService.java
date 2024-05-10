package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Notification;

public interface NotificationService {

    Notification createNotification(Notification notification);

    Notification getNotificationById(UuidGenerator notificationId);

    List<Notification> getAllNotifications();

    Notification updateNotification(Notification notification);
    
    void deleteNotification(UuidGenerator notificationId);
}