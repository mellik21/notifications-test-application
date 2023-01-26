package com.epam.notifications.config;

import com.epam.notifications.dto.StoreDto;
import com.epam.notifications.model.Store;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Component
public interface StoreMapper {

    StoreDto toStoreDto(Store store);

    Store toStore(StoreDto storeDto);

}
