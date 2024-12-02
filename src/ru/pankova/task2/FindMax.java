package ru.pankova.task2;
import ru.pankova.task1.Box;
import static java.lang.System.err;

public class FindMax {
    public static <T extends Number> double findMax(Box<T>[] boxes) {
        double max = Double.NEGATIVE_INFINITY;
        for (Box<T> box : boxes) {
            if (!box.isEmpty()) {
                double znachenie = box.getSubject().doubleValue();
                max = Math.max(max, znachenie);
            } else {
                err.println("Предупреждение: Встречена пустая коробка.");
            }
        }

        if (max == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Все коробки пусты!");
        }
        return max;
    }
}

