package org.repository;

import org.entity.DealerEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DealerRepository {

    private EntityManager entityManager;

    public DealerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create
    public void create(DealerEntity dealerEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(dealerEntity);
        transaction.commit();
    }

    // Read
    public DealerEntity getById(Integer id) {
        return entityManager.find(DealerEntity.class, id);
    }

    // Update
    public void update(DealerEntity dealerEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(dealerEntity);
        transaction.commit();
    }

    // Delete
    public void delete(Integer id) {
        DealerEntity dealerEntity = getById(id);
        if (dealerEntity != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(dealerEntity);
            transaction.commit();
        }
    }

    // Get all
    public List<DealerEntity> getAll() {
        return entityManager.createQuery("SELECT d FROM DealerEntity d", DealerEntity.class).getResultList();
    }

    // Get by condition
    public List<DealerEntity> getByLocation(String location) {
        return entityManager.createQuery("SELECT d FROM DealerEntity d WHERE d.location = :location", DealerEntity.class)
                            .setParameter("location", location)
                            .getResultList();
    }
}
