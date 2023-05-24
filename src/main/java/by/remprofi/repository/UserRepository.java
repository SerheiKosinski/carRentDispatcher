package by.remprofi.repository;


import by.remprofi.domain.User;

import java.util.List;


public interface UserRepository extends CRUDRepository<Long, User> {


    List<User> searchUser(String query, Double rating);

    boolean support(String param);
}
