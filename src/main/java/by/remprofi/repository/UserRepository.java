package by.remprofi.repository;


import by.remprofi.domain.Role;
import by.remprofi.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CRUDRepository<Long, User> {


    List<User> searchUser(String query, Double rating);

    boolean support(String param);

    List<Role> getUserAuthorities(Long userId);

    Optional<User> findByEmail(String email);
}

