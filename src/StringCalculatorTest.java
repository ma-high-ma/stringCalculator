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
    public void numberWithTrailingComma() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(4,s.Add("4,"));

    }

    @Test
    public void moreThanTwoNumbers() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(15,s.Add("1,2,3,4,5"));

    }

    @Test
    public void newLinesBetweenNumbers() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(10,s.Add("1 \n2, 3 \n4"));

    }

    @Test
    public void differentDelimiter() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(3,s.Add("//;\n1;2"));

    }

    @Test
    public void negativeInteger() throws Exception {

        StringCalculator s = new StringCalculator();
        try
        {
            s.Add("1,-2,3, -4");
            assert false;
        }
        catch (Exception e)
        {
            assertEquals("Negatives not allowed: -2 -4 ",e.getMessage());
        }

    }

    @Test
    public void numbersGreaterThan1000() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(2,s.Add("1001,2, 100000"));

    }

    @Test
    public void delimeterWithFlexibleLength() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(6,s.Add("//[**]\n1**2**3"));

    }

    @Test
    public void twoDelimeterWithFlexibleLength() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(6,s.Add("//[***][@@@]\n1@@@2***3"));

    }

    @Test
    public void multipleDelimeterWithFlexibleLength() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(10,s.Add("//[***][@@@][+++]\n1@@@2***3+++4"));

    }

    @Test
    public void delimitersWithoutParenthesis() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(11,s.Add("//**\n1**2**8"));

    }

    @Test
    public void multipleDelimitersWithNumberGreaterThan1000() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(11,s.Add("//[**][>>]\n1**2>>8**2000"));

    }

    @Test
    public void inputWithDelimiterNoNumbers() throws Exception {

        StringCalculator s = new StringCalculator();
        assertEquals(0,s.Add("//[*+**]\n"));

    }

    @Test
    public void inputWithIncorrectDelimiters() throws Exception {

        StringCalculator s = new StringCalculator();
        try {
            s.Add("//;\n1*2,3");
            assert false;
        } catch (Exception e) {

            assertEquals("Invalid Input",e.getMessage());


        }
    }

    @Test
    public void delimiterNotSpecifiedAfterDoubleSlash() throws Exception {

        StringCalculator s = new StringCalculator();
        try {
            s.Add("//\n1,2,3");
            assert false;
        }
        catch(Exception e) {
            assertEquals("Delimiter not specified after double slash", e.getMessage());
        }

    }

    @Test
    public void inputSTartingWithSingleSlash() throws Exception {

        StringCalculator s = new StringCalculator();
        try {
            s.Add("/1,2,3");
            assert false;
        }
        catch (Exception e){
            assertEquals("Invalid Input",e.getMessage());

        }

    }

}