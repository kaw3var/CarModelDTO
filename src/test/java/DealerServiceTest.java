import org.dto.DealerCenterDTO;
import org.dto.CarDTO;
import org.service.DealerServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DealerServiceTest {

    @Test
    public void testMultithreads() throws InterruptedException {
        // Генерация списка автомобилей
        CarModelGenerator carModelGenerator = new CarModelGenerator();
        DealerCenterDTO dealerCenter = new DealerCenterDTO(1, "Dealer Center 1", "Location 1", carModelGenerator.generateCars(10000));
        DealerServiceImpl dealerService = new DealerServiceImpl();

        // Разделение списка на несколько частей
        List<CarDTO> carList1 = dealerCenter.getCars().subList(0, 2500);
        List<CarDTO> carList2 = dealerCenter.getCars().subList(2500, 5000);
        List<CarDTO> carList3 = dealerCenter.getCars().subList(5000, 7500);
        List<CarDTO> carList4 = dealerCenter.getCars().subList(7500, 10000);

        // Создание потоков
        Thread thread1 = new Thread(() -> dealerService.processCar(dealerCenter, carList1));
        Thread thread2 = new Thread(() -> dealerService.processCar(dealerCenter, carList2));
        Thread thread3 = new Thread(() -> dealerService.processCar(dealerCenter, carList3));
        Thread thread4 = new Thread(() -> dealerService.processCar(dealerCenter, carList4));

        // Замер времени до начала
        long startTime = System.currentTimeMillis();

        // Запуск потоков
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Ожидание завершения всех потоков
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        // Замер времени после завершения
        long endTime = System.currentTimeMillis();

        // Перевод времени из миллисекунд в секунды
        long elapsedTimeInSeconds = (endTime - startTime) / 1000;

        // Вывод времени обработки и количества автомобилей в шоуруме
        System.out.println("Обработка завершена за " + elapsedTimeInSeconds + " секунд или " + (endTime - startTime) + " миллисекунд.");
        System.out.println("Количество автомобилей в шоуруме: " + dealerCenter.getCountShowroomCars());
    }
}
