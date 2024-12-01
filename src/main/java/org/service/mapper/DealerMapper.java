package org.service.mapper;

import org.entity.DealerEntity;
import org.dto.DealerCenterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DealerMapper {
    DealerMapper INSTANCE = Mappers.getMapper(DealerMapper.class);

    DealerCenterDTO dealerEntityToDealerCenterDTO(DealerEntity dealerEntity);
    DealerEntity dealerCenterDTOToDealerEntity(DealerCenterDTO dealerCenterDTO);
}
