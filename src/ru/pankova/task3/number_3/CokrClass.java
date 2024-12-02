package ru.pankova.task3.number_3;

import java.util.List;

public class CokrClass {
    public static <T> T cokr(List<T> list, Cokr<T> cokr, T ident) {
        if (list == null || list.isEmpty()) {
            return ident;
        }
        T result = ident;
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            result = cokr.cokr(result, item);
        }
        return result;
    }
}
