import org.dto.CarModelDTO;
import org.junit.Before;
import org.junit.Test;
import org.service.CarService;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CarServiceTest {
    private CarService carService;

    @Before
    public void setUp() {
        List<CarModelDTO> cars = Arrays.asList(
                new CarModelDTO(1, "Mercedes", "GLE 400", "Германия", "DE"),
                new CarModelDTO(2, "BMW", "1 Series", "Германия", "DE"),
                new CarModelDTO(3, "BMW", "X5", "Германия", "DE"),
                new CarModelDTO(4, "FSO", "Polonez", "Польша", "PL")
        );
        carService = new CarService(cars);
    }

    @Test
    public void testGetUniqueBrands() {
        Set<String> expectedBrands = new HashSet<>(Arrays.asList("Mercedes", "BMW", "FSO"));
        assertEquals(expectedBrands, carService.getUniqueBrands());
    }

    @Test
    public void testGetModelsByBrand() {
        List<CarModelDTO> bmwModels = carService.getModelsByBrand("BMW");
        assertEquals(2, bmwModels.size());
        assertEquals("X5", bmwModels.get(1).getModel());
    }

    @Test
    public void testGroupByBrand() {
        Map<String, Integer> brandCount = carService.groupByBrand();
        assertEquals(Integer.valueOf(2), brandCount.get("BMW")); // Проверка для BMW
        assertEquals(Integer.valueOf(1), brandCount.get("Mercedes")); // Проверка для Mercedes
        assertEquals(Integer.valueOf(1), brandCount.get("FSO")); // Проверка для FSO
    }
}