package com.example.DocBuddy.notification.repo;

import com.example.DocBuddy.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
