package com.epam.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NotificationCreationDto {

    private OffsetDateTime creationTimestamp;
    private String notificationText;

    private OffsetDateTime activeFrom;
    private OffsetDateTime activeTo;
    private NotificationState state;
}
