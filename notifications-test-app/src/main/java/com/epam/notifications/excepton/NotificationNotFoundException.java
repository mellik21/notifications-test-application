package com.epam.notifications.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotificationNotFoundException extends RuntimeException {

    public NotificationNotFoundException(Long id) {
        super("Notification with id =" + id + " doesn't exist");
    }

    public NotificationNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}