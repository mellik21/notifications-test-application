package com.epam.notifications.api;

import com.epam.notifications.dto.NotificationCreationDto;
import com.epam.notifications.dto.NotificationDto;
import com.epam.notifications.dto.NotificationState;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/notifications")
public interface NotificationApi {

    @GetMapping("/")
    @ApiOperation(value = "Getting all notifications")
    List<NotificationDto> getAllNotifications();

    @GetMapping("")
    @ApiOperation(value = "Getting all notifications by state")
    List<NotificationDto> getAllNotificationsByState(@RequestParam("state") NotificationState state);

    @GetMapping("/{id}")
    @ApiOperation(value = "Getting notification by ID")
    NotificationDto getNotificationById(@PathVariable Long id);

    @ApiOperation(value = "Creating new notification")
    @PostMapping("/")
    NotificationDto createNotification(@RequestBody NotificationCreationDto notification);

    @PutMapping("/")
    @ApiOperation(value = "Updating notification")
    NotificationDto updateNotificationById(@RequestBody NotificationDto notificationDto);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleting notification by ID")
    void deleteNotificationById(@PathVariable Long id);

    @GetMapping("/stores/{storeId}")
    @ApiOperation(value = "Getting all notifications by storeId")
    List<NotificationDto> getAllNotificationsByStoreId(@PathVariable("storeId") Long storeId);

    @PostMapping("/{id}/stores/{storeId}")
    @ApiOperation(value = "Assign store notification")
    void assignStoreNotification(@PathVariable("id") Long notificationId,
                                            @PathVariable Long storeId);

    @DeleteMapping("/{id}/stores/{storeId}")
    @ApiOperation(value = "Cancel store notification by storeId")
    void cancelStoreNotification(@PathVariable("id") Long notificationId,
                                 @PathVariable Long storeId);
}
