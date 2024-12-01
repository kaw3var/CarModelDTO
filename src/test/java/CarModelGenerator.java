import org.dto.CarDTO;
import org.dto.CarModelDTO;

import java.util.ArrayList;
import java.util.List;

public class CarModelGenerator {

    public List<CarDTO> generateCars(int numberOfCars) {
        List<CarDTO> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            // Генерация фиктивных данных для автомобиля
            CarDTO car = new CarDTO();
            car.setId(i);
            car.setCarModel(new CarModelDTO("Brand" + i, "Model" + i, "Country" + i, "Code" + i));
            car.setColor(i % 2 == 0 ? "Black" : "White"); // Чередуем цвета
            car.setCarStatus("Available");
            car.setConfiguration("Basic");
            car.setPrice(10000 + i * 100); // Просто пример цены

            carList.add(car);
        }
        return carList;
    }
}
