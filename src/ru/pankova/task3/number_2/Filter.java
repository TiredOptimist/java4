package ru.pankova.task3.number_2;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static <T> List<T> filter(List<T> values, Condition<T> condition) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            if (condition.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}