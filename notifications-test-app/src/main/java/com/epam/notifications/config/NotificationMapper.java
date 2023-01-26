package com.epam.notifications.config;

import com.epam.notifications.dto.NotificationCreationDto;
import com.epam.notifications.dto.NotificationDto;
import com.epam.notifications.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = StoreMapper.class)
@Component
public interface NotificationMapper {

    @Mapping(source = "assignedStores", target = "assignedStores", ignore = true)
    NotificationDto toNotificationDto(Notification notification);

    @Mapping(source = "assignedStores", target = "assignedStores", ignore = true)
    Notification toNotification(NotificationDto notificationDto);

    Notification toNotification(NotificationCreationDto notificationDto);;
}
