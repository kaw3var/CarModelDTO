package org.service.mapper;

import org.entity.CarModelEntity;
import org.dto.CarModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarModelMapper {
    CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    @Mapping(target = "id", source = "carModelEntity.id")
    @Mapping(target = "brand", source = "carModelEntity.brand")
    @Mapping(target = "model", source = "carModelEntity.model")
    @Mapping(target = "countryOrigin", source = "carModelEntity.countryOrigin")
    @Mapping(target = "countryCode", source = "carModelEntity.countryCode")
    CarModelDTO carModelEntityToCarModelDTO(CarModelEntity carModelEntity);

    CarModelEntity carModelDTOToCarModelEntity(CarModelDTO carModelDTO);
}
