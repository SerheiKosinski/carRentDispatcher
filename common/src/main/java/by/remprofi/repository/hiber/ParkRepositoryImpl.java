package by.remprofi.repository.hiber;

import by.remprofi.domain.hiber.HiberPark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParkRepositoryImpl implements HiberParkRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public HiberPark findOne(Long id) {
        return null;
    }

    @Override
    public List<HiberPark> findAll() {
        final String findAllHQL = "select l from HiberPark l";

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findAllHQL, HiberPark.class).getResultList();
    }

    @Override
    public HiberPark create(HiberPark object) {
        return null;
    }

    @Override
    public HiberPark update(HiberPark object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
