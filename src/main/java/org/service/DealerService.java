package org.service;

import org.dto.DealerCenterDTO;
import org.entity.DealerEntity;
import org.repository.DealerRepository;
import org.service.mapper.DealerMapper;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class DealerService {

    private DealerRepository dealerRepository;

    public DealerService(EntityManager entityManager) {
        this.dealerRepository = new DealerRepository(entityManager);
    }

    public DealerCenterDTO getDealerCenterDTO(Integer id) {
        DealerEntity dealerEntity = dealerRepository.getById(id);
        return DealerMapper.INSTANCE.dealerEntityToDealerCenterDTO(dealerEntity);
    }

    public List<DealerCenterDTO> getAllDealerCenterDTOs() {
        return dealerRepository.getAll().stream()
                .map(DealerMapper.INSTANCE::dealerEntityToDealerCenterDTO)
                .collect(Collectors.toList());
    }

    public void createDealerCenter(DealerCenterDTO dealerCenterDTO) {
        DealerEntity dealerEntity = DealerMapper.INSTANCE.dealerCenterDTOToDealerEntity(dealerCenterDTO);
        dealerRepository.create(dealerEntity);
    }

    public void updateDealerCenter(DealerCenterDTO dealerCenterDTO) {
        DealerEntity dealerEntity = DealerMapper.INSTANCE.dealerCenterDTOToDealerEntity(dealerCenterDTO);
        dealerRepository.update(dealerEntity);
    }

    public void deleteDealerCenter(Integer id) {
        dealerRepository.delete(id);
    }
}
