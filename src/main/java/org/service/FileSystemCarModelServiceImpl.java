package org.service;

import org.dto.CarModelDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileSystemCarModelServiceImpl implements FileSystemCarModelService{

    private List<CarModelDTO> carList = new ArrayList<>();

    @Override
    public void load(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            int idCounter = 1;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(";");

                if (values.length < 4) {
                    System.out.println("Неверный формат строки: " + line);
                    continue;
                }

                CarModelDTO car = new CarModelDTO(
                        idCounter++,
                        values[0],
                        values[1],
                        values[2],
                        values[3]
                );
                carList.add(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CarModelDTO> getAllCarDTOs(String brand) {
        if (brand == null) {
            return new ArrayList<>(carList);
        } else {
            List<CarModelDTO> filteredList = new ArrayList<>();
            for (CarModelDTO car : carList) {
                if (car.getBrand().equalsIgnoreCase(brand)) {
                    filteredList.add(car);
                }
            }
            return filteredList;
        }
    }

    @Override
    public Optional<CarModelDTO> findCarById(int id) {
        // Проверка на валидность ID
        if (id <= 0) {
            System.out.println("Ошибка: ID должен быть больше 0.");
            return Optional.empty();
        }

        // Проверка на пустой список
        if (carList.isEmpty()) {
            System.out.println("Список автомобилей пуст.");
            return Optional.empty();
        }

        // Поиск автомобиля по ID
        return carList.stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }

    @Override
    public List<CarModelDTO> getAllCarDTOs() {
        return new ArrayList<>(carList);
    }

    @Override
    public Map<String, Integer> getCarModelGroupByModel(String brand) {
        if (brand == null) {
            return carList.stream()
                    .collect(Collectors.groupingBy(CarModelDTO::getModel, Collectors.summingInt(c -> 1)));
        } else {
            return carList.stream()
                    .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                    .collect(Collectors.groupingBy(CarModelDTO::getModel, Collectors.summingInt(c -> 1)));
        }
    }
}
