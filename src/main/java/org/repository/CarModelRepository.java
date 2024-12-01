package org.repository;

import org.entity.CarModelEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarModelRepository {

    private EntityManager entityManager;

    public CarModelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create
    public void create(CarModelEntity carModel) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(carModel);
        transaction.commit();
    }

    // Read
    public CarModelEntity getById(Integer id) {
        return entityManager.find(CarModelEntity.class, id);
    }

    // Update
    public void update(CarModelEntity carModel) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(carModel);
        transaction.commit();
    }

    // Delete
    public void delete(Integer id) {
        CarModelEntity carModel = getById(id);
        if (carModel != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(carModel);
            transaction.commit();
        }
    }

    // Get all
    public List<CarModelEntity> getAll() {
        return entityManager.createQuery("SELECT cm FROM CarModelEntity cm", CarModelEntity.class).getResultList();
    }

    // Get by condition
    public List<CarModelEntity> getByBrand(String brand) {
        return entityManager.createQuery("SELECT cm FROM CarModelEntity cm WHERE cm.brand = :brand", CarModelEntity.class)
                .setParameter("brand", brand)
                .getResultList();
    }
}
