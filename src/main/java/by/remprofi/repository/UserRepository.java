package by.remprofi.repository;


import by.remprofi.domain.User;

import java.util.List;

public interface UserRepository extends CRUDRepository <Long, User> {

    void searchUser();

    List<User> findAll();
}
