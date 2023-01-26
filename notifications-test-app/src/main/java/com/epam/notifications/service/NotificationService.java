package com.epam.notifications.service;

import com.epam.notifications.dao.NotificationDao;
import com.epam.notifications.dto.NotificationState;
import com.epam.notifications.excepton.NotificationNotFoundException;
import com.epam.notifications.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationDao notificationDao;

    @Autowired
    public NotificationService(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    public Notification createNotification(Notification notification) {
        return notificationDao.save(notification);
    }

    public List<Notification> getAllNotificationsByState(NotificationState state) {
        return notificationDao.findAllByState(state);
    }

    public Notification getNotificationById(Long id) {
        return notificationDao.findById(id).orElseThrow(() -> new NotificationNotFoundException(id));
    }

    @Transactional
    public Notification updateNotification(Notification notification) {
        return notificationDao.save(notification);
    }

    @Transactional
    public void deleteNotificationById(Long id) {
        notificationDao.deleteById(id);
    }

    public List<Notification> getAllNotifications() {
        return notificationDao.findAll();
    }

    public List<Notification> getAllNotificationsByStoreId(Long storeId) {
        return notificationDao.findAllByStoreId(storeId);
    }

    @Transactional
    public void assignStoreNotification(Long notificationId, Long storeId) {
         notificationDao.assignStoreNotification(notificationId, storeId);
    }
    @Transactional
    public void cancelStoreNotification(Long notificationId, Long storeId) {
        notificationDao.cancelStoreNotification(notificationId,storeId);
    }

}
