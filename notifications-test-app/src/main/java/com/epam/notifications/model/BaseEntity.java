package com.epam.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    @CreatedDate
    private OffsetDateTime creationTimestamp;
}
