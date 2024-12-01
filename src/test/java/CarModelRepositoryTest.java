import org.entity.CarModelEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.repository.CarModelRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarModelRepositoryTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction entityTransaction;

    @Mock
    private TypedQuery<CarModelEntity> typedQuery;

    @InjectMocks
    private CarModelRepository carModelRepository;

    private CarModelEntity carModelEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        carModelEntity = new CarModelEntity();
        carModelEntity.setId(1);
        carModelEntity.setBrand("Toyota");
        carModelEntity.setModel("Corolla");
    }

    @Test
    public void testCreateCarModel() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        carModelRepository.create(carModelEntity);

        verify(entityManager).persist(carModelEntity);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    public void testGetCarModelById() {
        when(entityManager.find(CarModelEntity.class, 1)).thenReturn(carModelEntity);

        CarModelEntity foundCarModel = carModelRepository.getById(1);

        assertNotNull(foundCarModel);
        assertEquals(1, foundCarModel.getId());
        assertEquals("Toyota", foundCarModel.getBrand());
    }

    @Test
    public void testUpdateCarModel() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(entityManager.merge(carModelEntity)).thenReturn(carModelEntity);

        carModelRepository.update(carModelEntity);

        verify(entityManager).merge(carModelEntity);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    public void testDeleteCarModel() {
        when(entityManager.find(CarModelEntity.class, 1)).thenReturn(carModelEntity);
        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        carModelRepository.delete(1);

        verify(entityManager).remove(carModelEntity);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    public void testGetAllCarModels() {
        // Мокируем TypedQuery для запроса
        when(entityManager.createQuery("SELECT cm FROM CarModelEntity cm", CarModelEntity.class))
                .thenReturn(typedQuery);

        // Мокируем getResultList для возвращения списка
        when(typedQuery.getResultList()).thenReturn(List.of(carModelEntity));

        // Вызов метода и проверка результата
        List<CarModelEntity> carModelList = carModelRepository.getAll();

        assertEquals(1, carModelList.size());
        assertEquals("Toyota", carModelList.get(0).getBrand());
    }
}
