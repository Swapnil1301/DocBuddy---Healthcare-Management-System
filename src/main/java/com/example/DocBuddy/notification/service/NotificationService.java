package com.example.DocBuddy.notification.service;

import com.example.DocBuddy.notification.dto.NotificationDTO;
import com.example.DocBuddy.users.entity.User;

public interface NotificationService {
    void sendEmail(NotificationDTO notificationDTO, User user);
}
