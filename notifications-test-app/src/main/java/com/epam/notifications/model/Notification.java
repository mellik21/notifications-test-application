package com.epam.notifications.model;

import com.epam.notifications.dto.NotificationState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@Entity
public class Notification extends BaseEntity {

    private String notificationText;

    private OffsetDateTime activeFrom;

    private OffsetDateTime activeTo;

    @Enumerated(EnumType.STRING)
    private NotificationState state;

    @ElementCollection(targetClass = Integer.class)
    @Formula("(select store_id from notification_stores as ns where ns.notification = id)")
    private List<Integer> assignedStores = new ArrayList<>();

}
