package org.example;

import org.dto.CarModelDTO;
import org.service.CarService;
import org.service.FileSystemCarModelService;
import org.service.FileSystemCarModelServiceImpl;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        FileSystemCarModelService fileSystemCarService = new FileSystemCarModelServiceImpl();
        String fileName = "C:\\Users\\Admin\\IdeaProjects\\CarModelProject\\src\\main\\resources\\CAR_MODEL.csv";
        fileSystemCarService.load(fileName);

        List<CarModelDTO> allCars = fileSystemCarService.getAllCarDTOs(null);

        // Вывод всех машин
//        if (allCars != null && !allCars.isEmpty()) {
//            System.out.println("| ID     | Brand          | Model                               | Country of Origin               | Country Code  |");
//            System.out.println("-------------------------------------------------------------------------------------------------------------");
//
//            for (CarModelDTO car : allCars) {
//                System.out.println(car);
//            }
//        } else {
//            System.out.println("Автомобили не найдены.");
//        }

//        // Все модели определенной марки
//        List<CarModelDTO> toyotaCars = fileSystemCarService.getAllCarDTOs("Toyota");
//        toyotaCars.forEach(System.out::println);
//
//        // Группировка моделей по марке
//        fileSystemCarService.getCarModelGroupByModel("Toyota").forEach((model, count) ->
//                System.out.println("Модель: " + model + ", Количество: " + count));
//
//        // Поиск автомобиля по объекту
//        Optional<CarModelDTO> foundCar = fileSystemCarService.findCarById(71);
//        foundCar.ifPresent(System.out::println);

        // Создаем список автомобилей
//        List<CarModelDTO> carList = Arrays.asList(
//                new CarModelDTO(1, "Mercedes", "GLE 400", "Германия", "DE"),
//                new CarModelDTO(2, "BMW", "1 Series", "Германия", "DE"),
//                new CarModelDTO(3, "BMW", "X5", "Германия", "DE"),
//                new CarModelDTO(4, "FSO", "Polonez", "Польша", "PL"),
//                new CarModelDTO(5, "Audi", "A4", "Германия", "DE")
//        );
//
//        CarService carService = new CarService(carList);
//
//        // Получение уникальных марок автомобилей
//        Set<String> uniqueBrands = carService.getUniqueBrands();
//        System.out.println("Уникальные марки автомобилей:");
//        uniqueBrands.forEach(System.out::println);
//
//        // Поиск моделей по марке автомобиля
//        String brandToSearch = "BMW";
//        List<CarModelDTO> bmwModels = carService.getModelsByBrand(brandToSearch);
//        System.out.println("\nМодели автомобилей марки " + brandToSearch + ":");
//        bmwModels.forEach(car -> System.out.println(car.getModel()));
//
//        // Группировка по марке автомобиля
//        Map<String, Integer> brandCountMap = carService.groupByBrand();
//        System.out.println("\nГруппировка автомобилей по маркам:");
//        brandCountMap.forEach((brand, count) -> System.out.println(brand + ": " + count));
    }
}