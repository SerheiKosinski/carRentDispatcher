package by.remprofi.repository;

import java.util.List;

public interface CRUDRepository <K, T> {

    T findOne(K id);

    List<T> findAll();

    T create(T object);

    T update(T object);

    void delete(K id);
}

