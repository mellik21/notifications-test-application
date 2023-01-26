package com.epam.notifications.validator;

import com.epam.notifications.dto.NotificationCreationDto;
import com.epam.notifications.dto.NotificationDto;
import com.epam.notifications.excepton.NotificationCreationException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@NoArgsConstructor
public class NotificationValidator {

    public void validate(NotificationCreationDto notification) {
        compareActiveFromToActiveTo(notification.getActiveFrom(), notification.getActiveTo());
    }

    public void validate(NotificationDto notification) {
        compareActiveFromToActiveTo(notification.getActiveFrom(), notification.getActiveTo());
    }

    public void compareActiveFromToActiveTo(OffsetDateTime activeFrom, OffsetDateTime activeTo) {
        if (!activeFrom.isBefore(activeTo)) {
            throw new NotificationCreationException("Notification date activeTo shouldn't be before activeFrom date");
        }
    }

}
