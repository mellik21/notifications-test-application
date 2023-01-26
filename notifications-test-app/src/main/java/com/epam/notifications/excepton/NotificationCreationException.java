package com.epam.notifications.excepton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotificationCreationException extends RuntimeException{

    public NotificationCreationException(String errorMessage) {
        super(errorMessage);
    }

}
