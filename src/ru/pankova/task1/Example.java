package ru.pankova.task1;

public class Example implements Сравнимое<Example> {
    private int value;

    public int setValue(int value){
        this.value = value;
        return this.value;
    }

    public int getValue() {
        return this.value;
    }

    Example(int value){
        this.value = value;
    }

    @Override
    public int сравнить(Example other) {
        if (this.value == other.value) return 1;
        else return 0;
    }

    public String toString() {
        return "Значение: " + value;
    }
}
