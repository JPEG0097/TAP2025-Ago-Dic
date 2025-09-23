package utils;

import java.util.*;
import java.util.function.Predicate;

public final class GenericSearch {
    private GenericSearch(){}


    public static <T> List<T> filter(Collection<T> data, Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) result.add(item);
        }
        return result;
    }

    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        list.sort(comparator);
    }
}