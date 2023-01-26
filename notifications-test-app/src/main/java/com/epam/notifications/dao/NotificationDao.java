package com.epam.notifications.dao;

import com.epam.notifications.dto.NotificationState;
import com.epam.notifications.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {

    List<Notification> findAllByState(NotificationState notificationState);

    @Query(value = "select * from notification " +
            "where id in (select notification_id from notification_stores " +
            "where store_id =:storeId)", nativeQuery = true)
    List<Notification> findAllByStoreId(@Param("storeId") Long storeId);

    @Modifying
    @Query(value = "insert into notification_stores values(:notificationId, :storeId)", nativeQuery = true)
    void assignStoreNotification(@Param("notificationId") Long notificationId,
                                         @Param("storeId") Long storeId);

    @Modifying
    @Query(value = "delete from notification_stores where notification_id =:notificationId " +
            "and store_id =:storeId", nativeQuery = true)
    void cancelStoreNotification(@Param("notificationId") Long notificationId,
                                 @Param("storeId") Long storeId);
}
