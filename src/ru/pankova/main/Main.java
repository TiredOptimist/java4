// Панькова Светлана Вариант 2

package ru.pankova.main;
import ru.pankova.task1.Box;
import ru.pankova.task2.FindMax;
import ru.pankova.task3.number_1.Applier;
import ru.pankova.task3.number_3.CokrClass;
import ru.pankova.task3.number_2.Condition;
import ru.pankova.task3.number_4.Conver;

import java.util.*;

import static java.lang.System.out;
import static ru.pankova.task3.number_1.Apply.apply;
import static ru.pankova.task3.number_2.Filter.filter;


public class Main {
    public static void main(String[] args) {
        // Задание 1.1. Сущность Коробка
        out.println("Задание 1.1.");
        Box<Integer> box = new Box<>();
        box.setSubject(3);
        out.println(box);
        out.println("Извлекаем предмет: " + box.getSubject());
        out.println(box);

        // Задание 2.2. Создайте метод, принимающий набор Коробок из задачи 3.1.1
        // и возвращающий максимальное из их значений в формате double
        out.println("Задание 2.2. Найдем максимум из коробок, содержащих 10, 20.5f, 30.75.");
        Box<Integer> intBox = new Box<>();
        Box<Float> floatBox = new Box<>();
        Box<Double> doubleBox = new Box<>();

        intBox.setSubject(10);
        floatBox.setSubject(20.5f);
        doubleBox.setSubject(30.75);

        Box[] boxes = {intBox, floatBox, doubleBox};
        out.println("Максимум: " + FindMax.findMax(boxes));

        // Для заданий 3.1. - 3.4.
        List<String> list_of_str = List.of("qwerty", "asdfg", "zx");
        List<Integer> list_of_numbers = List.of(1, -3, 7);
        List<int[]> arrays = List.of(new int[]{-1, -6, -3, -5}, new int[]{3, -5}, new int[]{7, 8, 9, 7, 12});

        // Задание 3.1. Разработайте такой метод, который будет принимать список значений типа T,
        // и объект имеющий единственный метод apply. Данный метод надо применить к каждому элементу
        // списка, и вернуть новый список значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.
        out.println("Задание 3.1. ");

        // 1.
        Applier<String, Integer> str_len = String::length;
        List<Integer> res1 = apply(list_of_str, str_len);
        out.println("Длины строк: " + res1);
        // 2.
        Applier<Integer, Integer> num_abs = Math::abs;
        List<Integer> res2 = apply(list_of_numbers, num_abs);
        out.println("Модуль чисел: " + res2);
        // 3.
        Applier<int[], Integer> max_value = array -> Arrays.stream(array).max().getAsInt();
        List<Integer> res3 = apply(arrays, max_value);
        out.println("Максимальные значения из каждого массива: " + res3);

        // Задание 3.2. Разработайте такой метод, который будет принимать список значений типа T и объект имеющий
        //единственный метод test (принимает T и возвращает boolean). Верните новый список типа T, из
        //которого удалены все значения не прошедшие проверку условием.
        out.println("Задание 3.2.");
        // 1.
        Condition<String> condition_of_len = s -> s.length() >= 3;
        List<String> rez4 = filter(list_of_str, condition_of_len);
        out.println("Строки имеющие 3 и более символа: " + rez4);
        // 2.
        Condition<Integer> condition_of_negative1 = n -> n <= 0;
        List<Integer> rez5 = filter(list_of_numbers, condition_of_negative1);
        out.println("Только отрицательные числа: " + rez5);
        // 3.

        Condition<int[]> condition_of_negative2 = array -> Arrays.stream(array).allMatch(num -> num <= 0);
        List<int[]> rez6 = filter(arrays, condition_of_negative2);
        for (int[] array : rez6) {
            out.println("Массив из отрицательных чисел: " + Arrays.toString(array));
        }

        // Задание 3.3. Разработайте такой метод, который будет принимать список значений типа T, и способ, с помощью
        // которого список значений можно свести к одному значению типа T, которое и возвращается из
        // метода
        out.println("Задание 3.3.");
        // 1.
        String rez7 = CokrClass.cokr(list_of_str, (s1, s2) -> s1 + s2, "");
        out.println("Склеенная строка: " + rez7);
        // 2.
        Integer rez8 = CokrClass.cokr(list_of_numbers, (i1, i2) -> i1 + i2, 0);
        out.println("Сумма значений: " + rez8);

        // 3.
        List<List<Integer>> list_of_lists = Arrays.asList(Arrays.asList(-1, -6, -3, -5), Arrays.asList(3, -5), Arrays.asList(7, 8, 9, 7, 12), Arrays.asList());
        List<Integer> sizes = list_of_lists.stream().map(List::size).toList();
        Integer rez9 = CokrClass.cokr(sizes, (i1, i2) -> i1 + i2, 0);
        out.println("Общее количество элементов: " + rez9);

        // Задание 3.4. Разработайте такой метод, который будет
        // возвращать коллекцию типа P со значениями типа T.
        out.println("Задание 3.4.");
        // 1.
        Map<Boolean, List<Integer>> rez10 = Conver.conver(list_of_numbers, HashMap::new, (map, value) -> map.computeIfAbsent(value > 0, k -> new ArrayList<>()).add(value));
        out.print("Положительные числа : " + rez10.get(true));
        out.println(" Отрицательные числа: " + rez10.get(false));

        // 2.
        Map<Integer, List<String>> rez11 = Conver.conver(list_of_str, HashMap::new, (map, value) -> map.computeIfAbsent(value.length(), k -> new ArrayList<>()).add(value));
        out.println("Сгруппированные по длине строки: " + rez11);

        // 3.
        Set<String> rez12 = Conver.conver(list_of_str, HashSet::new, Set::add);
        out.println("Уникальные строки: " + rez12);
    }
}