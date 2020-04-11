package pl.kkowalewski.knightstour.service;

import java.util.List;

public interface BaseService<T> {

    T findById(Long id);

    List<T> findAll();

    T save(T object);

    void deleteById(Long id);

    void delete(T object);

    void deleteAll();
}
