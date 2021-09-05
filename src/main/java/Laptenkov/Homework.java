package Laptenkov;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lesson 10 homework
 *
 * Создать метод, который принимает массив строк и предикат.
 * И возвращает коллекцию, которая состоит из элементов отфильтрованных предикатом.
 *
 * Сгенерировать стрим - возрастающую бесконечную последовательность(1,2,3,4...)
 * и распечатать из нее первые 10 чисел, которые делятся нацело на 27.
 *
 * Объявить произвольный массив строк, отсортировать его по длине слова( от меньшего к большему)
 * и вывести на экран.
 *
 * Используя массив из упражнения 3 создать Map в которой поместить в качестве ключа длину,
 * а в качестве значения количество слов с этой длинной
 *
 */
public class Homework {

    /**
     * Метод {@link Homework#sortStringAndPrintIt} принимает массив строк и предикат,
     * и возвращает коллекцию, которая состоит из элементов отфильтрованных предикатом.
     * @param stringArray массив строк
     * @param predicate предикат с условием
     * @return возвращает объект коллекции
     */
    public static Collection<String> arrayInCollectionOut(String[] stringArray, Predicate<String> predicate) {
        return Arrays
                .stream(stringArray)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Метод {@link Homework#generateStreamAndPrintIt} генерирует стрим
     * - возрастающую бесконечную последовательность (1,2,3,4...)
     * и печатает из нее первые 10 чисел, которые делятся нацело на 27.
     */
    static void generateStreamAndPrintIt() {
        Stream
                .iterate(1, n -> n + 1)
                .filter((n) -> n % 27 == 0)
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * Метод {@link Homework#sortStringAndPrintIt} принимает произвольный массив строк,
     * сортирует его по длине слова(от меньшего к большему)
     * и выводит на экран на экран.
     * @param stringArray массив строк.
     */
    static void sortStringAndPrintIt(String[] stringArray) {
        Arrays
                .stream(stringArray)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Метод принимает массив и создает Map в которой помещает в качестве ключа длину,
     * а в качестве значения количество слов с этой длинной.
     * @param stringArray массив строк.
     */
    static Map createMapFromArray(String[] stringArray) {
        return Arrays
                .stream(stringArray)
                //.collect(Collectors.toMap(String::length, Collectors.counting()));
                .collect(
                        Collectors.groupingBy( String::length, Collectors.counting()));
    }

}


