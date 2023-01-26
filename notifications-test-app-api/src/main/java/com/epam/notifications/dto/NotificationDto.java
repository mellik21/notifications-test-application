package com.epam.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NotificationDto {

    private Long id;
    private OffsetDateTime creationTimestamp;
    private String notificationText;

    private OffsetDateTime activeFrom;
    private OffsetDateTime activeTo;
    private NotificationState state;

    @Nullable
    private List<StoreDto> assignedStores;

}
