import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    Main sut;

    @BeforeEach
    public void init() {
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started.");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed.");
    }

    @AfterAll
    static void finishedAll() {
        System.out.println("Tests completed.");
    }

    @Test
    public void testPositiveNumberFilter() {
        //arrange
        List<Integer> arg = List.of(2, 3, -1, 5, -6, 0, 22);
        List<Integer> expected = List.of(2, 3, 5, 22);
        //act
        List<Integer> result = sut.positiveNumberFilter(arg);
        //assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testCheckNum(String data, int expected) {
        //act
        int result = sut.checkNum(data);
        //assert
        assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {

        return Stream.of(Arguments.of("2", 2), Arguments.of("-8", -8), Arguments.of("0", 0));
    }

    @ParameterizedTest
    @MethodSource("getData")
    public void testNegativeNumberFilter(List<Integer> data, List<Integer> expected) {
        //act
        List<Integer> result = sut.negativeNumberFilter(data);
        //assert
        assertEquals(expected, result);
    }

    public static Stream<Arguments> getData() {

        return Stream.of(Arguments.of(List.of(2, -5, 0, 8), List.of(-5)), Arguments.of(List.of(2, 4, 6, -3, -9, 0, -1),
                List.of(-3, -9, -1)), Arguments.of(List.of(-1, -4, 12, 3, 0, - 55), List.of(-1, -4, -55)));
    }

    @Test
    public void testEvenNumberFilter(){
        //arrange
        List<Integer> arg = List.of(2, 3, -1, 5, -6, 0, 22);
        //act
        List<Integer> result = sut.evenNumberFilter(arg);
        //assert
        assertThat(result, contains(2, -6, 0, 22));
    }
}
