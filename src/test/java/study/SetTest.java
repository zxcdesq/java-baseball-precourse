package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    // 요구사항1
    @Test
    void test1(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    // 요구사항2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test2(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    // 요구사항3
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void test3(String input, String expected){
        String actualValue = numbers.contains(Integer.parseInt(input)) ? "true" : "false";
        assertEquals(expected, actualValue);
    }
}
