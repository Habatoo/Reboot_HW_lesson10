package Laptenkov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс для тестирования методов объекта {@link Homework}.
 */
class HomeworkTest {

    private String[] stringArray;
    private Predicate<String> predicate;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    /**
     * Инициализация объектов для тестированияния {@link Homework}.
     */
    @BeforeEach
    void setUp() {
        stringArray = new String[]{"azz_first_____", "aaz_second", "aaa_thirst", "bbb_last_____"};
        predicate = s -> s.length() > 10;

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Очистка объектов после тестированияния {@link Homework}.
     */
    @AfterEach
    void tearDown() {
        stringArray = null;
        predicate = null;
        outContent = null;
        System.setOut(originalOut);
    }

    /**
     * Метод {@link HomeworkTest#arrayInCollectionOut_Test}
     * проверяет метод {@link Homework#arrayInCollectionOut}.
     * Сценарий проверяет преобразование массива строк в коллекцию ArrayList
     * и отображение строк удовлетворяющие условию переданного предиката
     * - длинна строки больше 10 символов.
     */
    @Test
    void arrayInCollectionOut_Test() {
        assertEquals(
                "[azz_first_____, bbb_last_____]",
                Homework.arrayInCollectionOut(stringArray, predicate).toString());
    }

    /**
     * Метод {@link HomeworkTest#arrayInCollectionOut_Test}
     * проверяет метод {@link Homework#arrayInCollectionOut}.
     * Сценарий проверяет тип возвращаемого объекта - ArrayList.
     */
    @Test
    void arrayInCollectionOutObjectType_Test() {
        assertEquals(
                "ArrayList",
                Homework.arrayInCollectionOut(stringArray, predicate).getClass().getSimpleName());
    }

    /**
     * Метод {@link HomeworkTest#generateStreamAndPrintIt_Test}
     * проверяет метод {@link Homework#generateStreamAndPrintIt}.
     * Сценарий проверяет генерацию бесконечной последовательности
     * от 1 до ... и вывод первых 10 элементов, которые делятся на 27
     * без остатка.
     */
    @Test
    void generateStreamAndPrintIt_Test() {
        Homework.generateStreamAndPrintIt();
        assertEquals("27\n" +
                "54\n" +
                "81\n" +
                "108\n" +
                "135\n" +
                "162\n" +
                "189\n" +
                "216\n" +
                "243\n" +
                "270", outContent.toString().trim());
    }

    /**
     * Метод {@link HomeworkTest#sortStringAndPrintIt_Test}
     * проверяет метод {@link Homework#sortStringAndPrintIt}.
     * Сценарий проверяет сортировку принимаемого массива срок и вывод
     * отсортированной последовательности.
     */
    @Test
    void sortStringAndPrintIt_Test() {
        Homework.sortStringAndPrintIt(stringArray);
        assertEquals("aaa_thirst\n" +
                "aaz_second\n" +
                "azz_first_____\n" +
                "bbb_last_____", outContent.toString().trim());
    }

    /**
     * Метод {@link HomeworkTest#createMapFromArray_Test}
     * проверяет метод {@link Homework#createMapFromArray}.
     * Сценарий проверяет сортировку принимаемого массива срок и вывод
     * отсортированной последовательности.
     * Сценарий проверяет тип возвращаемого объекта - наследника Map.
     */
    @Test
    void createMapFromArray_Test() {
        assertEquals(
                "{10=2, 13=1, 14=1}",
                Homework.createMapFromArray(stringArray).toString());
    }

    /**
     * Метод {@link HomeworkTest#createMapFromArray_Test}
     * проверяет метод {@link Homework#createMapFromArray}.
     * Сценарий проверяет тип возвращаемого объекта - HashMap.
     */
    @Test
    void createMapFromArraySuccess_Test() {
        assertEquals(
                "HashMap",
                Homework.createMapFromArray(stringArray).getClass().getSimpleName());
    }

    /**
     * Метод {@link HomeworkTest#createMapFromArray_Test}
     * проверяет метод {@link Homework#createMapFromArray}.
     * Сценарий проверяет тип возвращаемого объекта - HashMap.
     */
    @Test
    void createMapFromArrayHashMap_Test() {
        assertEquals(
                true,
                Homework.createMapFromArray(stringArray) instanceof Map);
    }
}