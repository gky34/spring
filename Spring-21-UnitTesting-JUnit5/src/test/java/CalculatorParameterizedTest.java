import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest
{
    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    void testCase1(String args)
    {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    @Tag("test 2")
    void testCase2(int num)
    {
        Assertions.assertEquals(0, num % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String args)
    {
        Assertions.assertTrue(!args.isEmpty());
    }


    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String args)
    {
       Assertions.assertNotNull(args);
    }

    /**
     * I created method in order to use @MethodSource annotation
     */
    static String[] stringProvider(){
        return  new String[]{"Java","JS","TS"};
    }

    /**
     *  first element assign num1, second element assign num2, last element after comma assign result
     *  Order is important
     */
    @ParameterizedTest
    @CsvSource({"10,20,30","20,20,40","30,20,100"})
    void testCase5(int num1, int num2, int result)
    {
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }

    /**
        First, we need to provide the location of the file and all parameters has to be match
        numLinesToSkip = 1
        This is skip the first line on the csv file in resource which is this num1,num2,result
     */

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result)
    {
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }

}
