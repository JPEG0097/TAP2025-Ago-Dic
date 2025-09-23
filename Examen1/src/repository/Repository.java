package repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T, K> {
    T save(T entity);
    Optional<T> findById(K id);
    List<T> findAll();
    boolean deleteById(K id);
    List<T> findBy(Predicate<T> filter);
}