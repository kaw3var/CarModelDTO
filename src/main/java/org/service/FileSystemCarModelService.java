package org.service;

import org.dto.CarModelDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FileSystemCarModelService {
    void load(String fileName);
    List<CarModelDTO> getAllCarDTOs(String brand);
    Optional<CarModelDTO> findCarById(int id);
    List<CarModelDTO> getAllCarDTOs();
    Map<String, Integer> getCarModelGroupByModel(String brand);
}
