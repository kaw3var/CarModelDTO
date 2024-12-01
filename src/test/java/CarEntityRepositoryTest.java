import org.entity.CarEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.repository.CarEntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarEntityRepositoryTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction entityTransaction;

    @InjectMocks
    private CarEntityRepository carEntityRepository;

    private CarEntity carEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        carEntity = new CarEntity();
        carEntity.setId(1);
        carEntity.setCarStatus("Available");
        carEntity.setColor("Red");
        carEntity.setPrice(30000.00);
    }

    @Test
    public void testCreateCarEntity() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        carEntityRepository.create(carEntity);

        verify(entityManager).persist(carEntity);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    public void testGetCarEntityById() {
        when(entityManager.find(CarEntity.class, 1)).thenReturn(carEntity);

        CarEntity foundCar = carEntityRepository.getById(1);

        assertNotNull(foundCar);
        assertEquals(1, foundCar.getId());  // Исправлено: убрано Optional
        assertEquals("Available", foundCar.getCarStatus());
    }


    @Test
    public void testUpdateCarEntity() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(entityManager.merge(carEntity)).thenReturn(carEntity);

        carEntityRepository.update(carEntity);

        verify(entityManager).merge(carEntity);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    public void testDeleteCarEntity() {
        when(entityManager.find(CarEntity.class, 1)).thenReturn(carEntity);
        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        carEntityRepository.delete(1);

        verify(entityManager).remove(carEntity);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    public void testGetAllCarEntities() {
        // Мокируем TypedQuery для запроса
        TypedQuery<CarEntity> typedQuery = mock(TypedQuery.class);

        // Мокируем поведение createQuery
        when(entityManager.createQuery("SELECT c FROM CarEntity c", CarEntity.class)).thenReturn(typedQuery);

        // Мокируем возвращаемый список
        when(typedQuery.getResultList()).thenReturn(List.of(carEntity));

        // Вызов метода и проверка результата
        List<CarEntity> carEntities = carEntityRepository.getAll();

        // Проверяем, что возвращается правильный список
        assertNotNull(carEntities);
        assertEquals(1, carEntities.size());
        assertEquals("Available", carEntities.get(0).getCarStatus());
        assertEquals("Red", carEntities.get(0).getColor());
    }

}
