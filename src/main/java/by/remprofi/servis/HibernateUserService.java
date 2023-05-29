package by.remprofi.servis;

import by.remprofi.domain.Role;
import by.remprofi.domain.hibernate.HibernateUser;

import java.util.List;
import java.util.Optional;

public interface HibernateUserService {

    HibernateUser findOne(Long id);

    List<HibernateUser> findAll();

    HibernateUser create(HibernateUser object);

    HibernateUser update(HibernateUser object);

    void delete(Long id);

    List<HibernateUser> search(String query, Double rating);

    List<Role> getHibernateUserAuthorities(Long userId);

    Optional<HibernateUser> findByEmail(String email);
}
