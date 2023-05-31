package by.remprofi.servis;

import by.remprofi.domain.Role;
import by.remprofi.domain.hibernate.HiberUser;

import java.util.List;
import java.util.Optional;

public interface HibernateUserService {

    HiberUser findOne(Long id);

    List<HiberUser> findAll();

    HiberUser create(HiberUser object);

    HiberUser update(HiberUser object);

    void delete(Long id);

    List<HiberUser> search(String query, Double rating);

    List<Role> getHibernateUserAuthorities(Long userId);

    Optional<HiberUser> findByEmail(String email);
}
