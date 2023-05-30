package by.remprofi.repository.hibernate;

import by.remprofi.domain.hibernate.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HibernateUserRepositoryImpl implements HibernateUserRepository {

    private final SessionFactory sessionFactory;

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public HibernateUser findOne(Long id) {
        final String findByIdHQL = "select u from HibernateUser u where u.id = " + id;

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findByIdHQL, HibernateUser.class).getSingleResult();
    }

    @Override
    public List<HibernateUser> findAll() {

        final String findAllHQL = "select u from HibernateUser u";
//        //final String findAllNative = "select * from users";
//
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery(findAllHQL, HibernateUser.class).getResultList();
//        }


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findAllHQL, HibernateUser.class).getResultList();
    }

    @Override
    public HibernateUser create(HibernateUser object) {
        return update(object);
    }

    @Override
    public HibernateUser update(HibernateUser object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.saveOrUpdate(object);
            session.flush();

            transaction.commit();

            return object;
        }
    }

    @Override
    public void delete(Long id) {

    }

 /*   @Override
    public List<HibernateUser> searchUser(String searchQuery, Double rating) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //1. Get Builder for Criteria object
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HibernateUser> query = cb.createQuery(HibernateUser.class); //here select, where, orderBy, having
        Root<HibernateUser> root = query.from(HibernateUser.class); //here params  select * from users -> mapping

        root.join(HibernateUser_.cars);

        /*type of future params in prepared statement*/
      /*  ParameterExpression<String> fullNameExp = cb.parameter(HibernateUser_.fullName.getJavaType());
        ParameterExpression<Double> userRatingtExp = cb.parameter(HibernateUser_.rating.getJavaType());

        /*Provide access to fields in class that mapped to columns*/
       /* Expression<Long> id = root.get(HibernateUser_.id);
        Expression<String> surname = root.get(HibernateUser_.surname);
        Expression<String> fullName = root.get(HibernateUser_.fullName);
        Expression<Double> ratingExp = root.get(HibernateUser_.rating);

        /*SQL Query customizing*/
      /*  query
                .select(root)
                .distinct(true)
                .where(
                        cb.or(
                                cb.like(fullName, fullNameExp),  //userName like '%param%'
                                cb.like(surname, fullNameExp)  //userSurname like '%param%'
                        ),
                        cb.and(
                                cb.gt(ratingExp, userRatingtExp), //>0
                                cb.not(id.in(1L, 40L, 50L)) //in (40,50)
                        )
//                        ,
//                        cb.between(
//                                root.get(TestUser_.birthDate),
//                                new Timestamp(new Date().getTime()),
//                                new Timestamp(new Date().getTime())
//                        )
                )
                .orderBy(cb.desc(fullName), cb.desc(id));

        TypedQuery<HibernateUser> resultQuery = entityManager.createQuery(query); //prepared statement on hql
     /*   resultQuery.setParameter(fullNameExp, StringUtils.join("%", searchQuery, "%"));
        resultQuery.setParameter(userRatingtExp,rating);
        return resultQuery.getResultList();
    }*/

    @Override
    public List<HibernateUser> searchUser(String query, Double rating) {
        return null;
    }

    @Override
    public Optional<HibernateUser> findByEmail(String email) {
        return Optional.empty();
    }
}
