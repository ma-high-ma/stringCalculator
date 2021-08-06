import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by juhi on 07/08/21.
 */
public class StringCalculatorTest {
//    @org.junit.Before
//    public void setUp() throws Exception {
//
//    }

    @Test
    public void emptyString() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(0,s.Add(""));

    }

    @Test
    public void singleNumber() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(1,s.Add("1"));

    }

    @Test
    public void twoNumbers() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(3,s.Add("1,2"));

    }

    @Test
    public void numberWithComma() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(4,s.Add("4,"));

    }

}