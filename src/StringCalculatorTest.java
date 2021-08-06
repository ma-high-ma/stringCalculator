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

}