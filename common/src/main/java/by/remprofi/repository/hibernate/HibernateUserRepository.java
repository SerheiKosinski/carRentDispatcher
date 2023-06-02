package by.remprofi.repository.hibernate;


import by.remprofi.domain.hibernate.HiberUser;
import by.remprofi.repository.CRUDRepository;

import java.util.List;
import java.util.Optional;

public interface HibernateUserRepository extends
        CRUDRepository<Long, HiberUser> {

    List<HiberUser> searchUser(String query, Double rating);

    Optional<HiberUser> findByEmail(String email);
}
