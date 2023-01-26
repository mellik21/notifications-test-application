package com.epam.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StoreDto {

    private Long id;
    private OffsetDateTime creationTimestamp;
    private String name;

}
