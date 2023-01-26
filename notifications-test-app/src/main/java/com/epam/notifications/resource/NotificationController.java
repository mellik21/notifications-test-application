package com.epam.notifications.resource;

import com.epam.notifications.api.NotificationApi;
import com.epam.notifications.config.NotificationMapper;
import com.epam.notifications.dto.NotificationCreationDto;
import com.epam.notifications.dto.NotificationDto;
import com.epam.notifications.dto.NotificationState;
import com.epam.notifications.service.NotificationService;
import com.epam.notifications.validator.NotificationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NotificationController implements NotificationApi {

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;
    private final NotificationValidator notificationValidator;

    @Autowired
    public NotificationController(NotificationService notificationService,
                                  NotificationMapper notificationMapper,
                                  NotificationValidator notificationValidator) {
        this.notificationService = notificationService;
        this.notificationMapper = notificationMapper;
        this.notificationValidator = notificationValidator;
    }

    @Override
    public List<NotificationDto> getAllNotifications() {
        return notificationService.getAllNotifications().stream()
                .map(notificationMapper::toNotificationDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationDto> getAllNotificationsByState(NotificationState state) {
        return notificationService.getAllNotificationsByState(state).stream()
                .map(notificationMapper::toNotificationDto)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        return notificationMapper.toNotificationDto(
                notificationService.getNotificationById(id)
        );
    }

    @Override
    public NotificationDto createNotification(@Valid NotificationCreationDto notificationDto) {
        notificationValidator.validate(notificationDto);

        return notificationMapper.toNotificationDto(
                notificationService.createNotification(
                        notificationMapper.toNotification(notificationDto)
                )
        );
    }

    @Override
    public NotificationDto updateNotificationById(NotificationDto notificationDto) {
        notificationValidator.validate(notificationDto);

        return notificationMapper.toNotificationDto(
                notificationService.updateNotification(
                        notificationMapper.toNotification(notificationDto)
                )
        );
    }

    @Override
    public void deleteNotificationById(Long id) {
        notificationService.deleteNotificationById(id);
    }

    @Override
    public List<NotificationDto> getAllNotificationsByStoreId(Long storeId) {
        return notificationService.getAllNotificationsByStoreId(storeId).stream()
                .map(notificationMapper::toNotificationDto)
                .collect(Collectors.toList());
    }

    @Override
    public void assignStoreNotification(Long notificationId, Long storeId) {
        notificationService.assignStoreNotification(notificationId, storeId);
    }

    @Override
    public void cancelStoreNotification(Long notificationId, Long storeId) {
        notificationService.cancelStoreNotification(notificationId, storeId);
    }
}
