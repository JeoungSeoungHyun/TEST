import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SachicTest {

    Sachic sachic = new Sachic();

    @Test
    public void add_test() {
        // given
        int num1 = 4;
        int num2 = 2;

        // when
        int result = sachic.add(num1, num2);

        // then
        assertEquals(result, num1 + num2);
    }

    @Test
    public void sub_test() {
        // given
        int num1 = 4;
        int num2 = 2;

        // when
        int result = sachic.sub(num1, num2);

        // then
        assertEquals(result, num1 - num2);
    }

    @Test
    public void mul_test() {
        // given
        int num1 = 4;
        int num2 = 2;

        // when
        int result = sachic.mul(num1, num2);

        // then
        assertEquals(result, num1 * num2);
    }

    @Test
    public void div_test() {
        // given
        int num1 = 4;
        int num2 = 2;

        // when
        int result = sachic.div(num1, num2);

        // then
        assertEquals(result, num1 / num2);
    }

}
