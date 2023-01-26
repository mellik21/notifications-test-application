package com.epam.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store extends BaseEntity{
    private String name;
}
