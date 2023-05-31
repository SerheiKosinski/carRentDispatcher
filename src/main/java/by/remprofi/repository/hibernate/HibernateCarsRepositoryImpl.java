package by.remprofi.repository.hibernate;

import by.remprofi.domain.hibernate.HiberCars;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HibernateCarsRepositoryImpl implements HibernateCarsRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public HiberCars findOne(Long id) {
        return null;
    }

    @Override
    public List<HiberCars> findAll() {
        final String findAllHQL = "select c from HiberCars c";

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findAllHQL, HiberCars.class).getResultList();
    }

    @Override
    public HiberCars create(HiberCars object) {
        return null;
    }

    @Override
    public HiberCars update(HiberCars object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
