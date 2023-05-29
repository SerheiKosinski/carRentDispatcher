package by.remprofi.repository.hibernate;


import by.remprofi.domain.hibernate.HibernateUser;
import by.remprofi.repository.CRUDRepository;

import java.util.List;
import java.util.Optional;

public interface HibernateUserRepository extends
        CRUDRepository<Long, HibernateUser> {

    List<HibernateUser> searchUser(String query, Double weight);

    Optional<HibernateUser> findByEmail(String email);
}
