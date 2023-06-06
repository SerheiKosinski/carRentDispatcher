package by.remprofi.repository.hiber;

import by.remprofi.domain.hiber.HiberCar;
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
    public HiberCar findOne(Long id) {
        return null;
    }

    @Override
    public List<HiberCar> findAll() {
        final String findAllHQL = "select c from HiberCar c";

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findAllHQL, HiberCar.class).getResultList();
    }

    @Override
    public HiberCar create(HiberCar object) {
        return null;
    }

    @Override
    public HiberCar update(HiberCar object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
