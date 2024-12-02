package ru.pankova.task3.number_1;

public interface Applier<T, P> {
    P apply(T value);
}
