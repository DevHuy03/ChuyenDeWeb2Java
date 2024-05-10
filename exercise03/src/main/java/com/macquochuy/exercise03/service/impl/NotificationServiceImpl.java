package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Notification;
import com.macquochuy.exercise03.Repository.NotificationRepository;
import com.macquochuy.exercise03.service.NotificationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(UuidGenerator notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        return optionalNotification.orElse(null);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification updateNotification(Notification notification) {
        Optional<Notification> optionalExistingNotification = notificationRepository.findById(notification.getId());
        if (optionalExistingNotification.isPresent()) {
            Notification existingNotification = optionalExistingNotification.get();
            existingNotification.setAccount_id(notification.getAccount_id());
            existingNotification.setTitle(notification.getTitle());
            existingNotification.setContent(notification.getContent());
            existingNotification.setSeen(notification.isSeen());
            existingNotification.setReceive_time(new Date());
            existingNotification.setNotification_expiry_date(new Date());
            Notification updatedNotification = notificationRepository.save(existingNotification);
            return updatedNotification;
        }
    
        return null;
    }

    @Override
    public void deleteNotification(UuidGenerator notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}
