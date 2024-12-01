package org.service;

import org.dto.CarDTO;
import org.entity.CarEntity;
import org.repository.CarEntityRepository;
import org.service.mapper.CarMapper;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private CarEntityRepository carEntityRepository;

    public CarService(EntityManager entityManager) {
        this.carEntityRepository = new CarEntityRepository(entityManager);
    }

    public CarDTO getCarDTO(Integer id) {
        CarEntity carEntity = carEntityRepository.getById(id);
        return CarMapper.INSTANCE.carEntityToCarDTO(carEntity);
    }

    public List<CarDTO> getAllCarDTOs() {
        return carEntityRepository.getAll().stream()
                .map(CarMapper.INSTANCE::carEntityToCarDTO)
                .collect(Collectors.toList());
    }

    public void createCar(CarDTO carDTO) {
        CarEntity carEntity = CarMapper.INSTANCE.carDTOToCarEntity(carDTO);
        carEntityRepository.create(carEntity);
    }

    public void updateCar(CarDTO carDTO) {
        CarEntity carEntity = CarMapper.INSTANCE.carDTOToCarEntity(carDTO);
        carEntityRepository.update(carEntity);
    }

    public void deleteCar(Integer id) {
        carEntityRepository.delete(id);
    }
}