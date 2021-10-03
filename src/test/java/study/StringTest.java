package study;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    void test1() {
        String [] splitList  = "1,2".split(",");
        assertThat(splitList).contains("1","2");
        String [] splitList2  = "1".split(",");
        assertThat(splitList2).containsExactly("1");
    }

    @Test
    void test2() {
        String temp = "(1,2)";
        int startIndex = temp.indexOf("(");
        int endIndex = temp.indexOf(")");
        String substringString = temp.substring(startIndex+1, endIndex);
        assertThat(substringString). isEqualTo("1,2");
    }

    @Test
    @DisplayName("")
    void test3() {

        String temp = "abc";
        char StringOne = temp.charAt(0);
        assertThat('a').isEqualTo(StringOne);

        assertThatThrownBy(() -> {
//            if ()
            throw new Exception("boom!");
// ...
        }).isInstanceOf(IndexOutOfBoundsException.class) .hasMessageContaining(
                "Index: 2, Size: 2"
        );

        assertThatExceptionOfType(IndexOutOfBoundsException.class) .isThrownBy(() -> {
// ...
        }).withMessageMatching(
                "Index: \\d+, Size: \\d+"
        );


    }

}


