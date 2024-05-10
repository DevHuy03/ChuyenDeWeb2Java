package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Notification;

public interface NotificationService {

    Notification createNotification(Notification notification);

    Notification getNotificationById(UUID notificationId);

    List<Notification> getAllNotifications();

    Notification updateNotification(Notification notification);
    
    void deleteNotification(UUID notificationId);
}