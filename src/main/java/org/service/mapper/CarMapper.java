package org.service.mapper;

import org.entity.CarEntity;
import org.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carEntityToCarDTO(CarEntity carEntity);
    CarEntity carDTOToCarEntity(CarDTO carDTO);
}
