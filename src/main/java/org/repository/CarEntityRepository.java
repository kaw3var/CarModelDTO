package org.repository;

import org.entity.CarEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarEntityRepository {

    private EntityManager entityManager;

    public CarEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create
    public void create(CarEntity carEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(carEntity);
        transaction.commit();
    }

    // Read
    public CarEntity getById(Integer id) {
        return entityManager.find(CarEntity.class, id);
    }

    // Update
    public void update(CarEntity carEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(carEntity);
        transaction.commit();
    }

    // Delete
    public void delete(Integer id) {
        CarEntity carEntity = getById(id);
        if (carEntity != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(carEntity);
            transaction.commit();
        }
    }

    // Get all
    public List<CarEntity> getAll() {
        return entityManager.createQuery("SELECT c FROM CarEntity c", CarEntity.class).getResultList();
    }

    // Get by condition
    public List<CarEntity> getByCarStatus(String status) {
        return entityManager.createQuery("SELECT c FROM CarEntity c WHERE c.carStatus = :status", CarEntity.class)
                            .setParameter("status", status)
                            .getResultList();
    }
}
