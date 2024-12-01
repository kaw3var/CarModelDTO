package org.service;

import org.dto.CarModelDTO;
import org.entity.CarModelEntity;
import org.repository.CarModelRepository;
import org.service.mapper.CarModelMapper;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarModelService {

    private CarModelRepository carModelRepository;

    public CarModelService(EntityManager entityManager) {
        this.carModelRepository = new CarModelRepository(entityManager);
    }

    public CarModelDTO getCarModelDTO(Integer id) {
        CarModelEntity carModelEntity = carModelRepository.getById(id);
        return CarModelMapper.INSTANCE.carModelEntityToCarModelDTO(carModelEntity);
    }

    public List<CarModelDTO> getAllCarModelDTOs() {
        return carModelRepository.getAll().stream()
                .map(CarModelMapper.INSTANCE::carModelEntityToCarModelDTO)
                .collect(Collectors.toList());
    }

    public void createCarModel(CarModelDTO carModelDTO) {
        CarModelEntity carModelEntity = CarModelMapper.INSTANCE.carModelDTOToCarModelEntity(carModelDTO);
        carModelRepository.create(carModelEntity);
    }

    public void updateCarModel(CarModelDTO carModelDTO) {
        CarModelEntity carModelEntity = CarModelMapper.INSTANCE.carModelDTOToCarModelEntity(carModelDTO);
        carModelRepository.update(carModelEntity);
    }

    public void deleteCarModel(Integer id) {
        carModelRepository.delete(id);
    }
}
