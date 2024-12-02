package ru.pankova.task3.number_4;

import java.util.List;

public class Conver{
    public static <T, P> P conver(List<T> list, CollectionCreator<P> collectionCreator, AdderToCollection<T, P> valueAdder) {
        P result = collectionCreator.create();
        for (T value : list) {
            valueAdder.add(result, value);
        }
        return result;
    }
}
