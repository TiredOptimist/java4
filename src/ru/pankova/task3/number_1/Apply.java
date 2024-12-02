package ru.pankova.task3.number_1;

import java.util.ArrayList;
import java.util.List;

public class Apply {
    public static <T, P> List<P> apply(List<T> values, Applier<T, P> applier) {
        List<P> result = new ArrayList<>();
        for (T value : values) {
            result.add(applier.apply(value));
        }
        return result;
    }
}