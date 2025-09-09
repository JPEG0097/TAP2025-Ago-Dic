package inventory.repository;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class InMemoryRepository<T, K> implements Repository<T, K> {
    private final Map<K, T> store = new LinkedHashMap<>();
    private final Function<T, K> keyExtractor;

    public InMemoryRepository(Function<T, K> keyExtractor) {
        this.keyExtractor = keyExtractor;
    }

    @Override
    public T save(T entity) {
        store.put(keyExtractor.apply(entity), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(K id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public boolean deleteById(K id) {
        return store.remove(id) != null;
    }

    @Override
    public List<T> findBy(Predicate<T> filter) {
        List<T> out = new ArrayList<>();
        for (T t : store.values()) {
            if (filter.test(t)) out.add(t);
        }
        return out;
    }
}