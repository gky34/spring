import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll is executed");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterAll is executed");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println(" BeforeEach is executed");
    }

    @AfterEach
    void tearDownEach(){
        System.out.println(" AfterEach is executed");
    }

    @Test
    void testCase1(){
//        fail("Not implemented yet");
        System.out.println("Test case 1");
    }

    @Test
    void testCase2(){
        System.out.println("Test case 2");
        assertEquals("add", Calculator.operator);
        assertTrue( Calculator.operator.equals("add"));
    }

    @Test
    void testCase3(){
        System.out.println("Test case 3");
        assertArrayEquals(new int[]{1,2,3,4}, new int[]{1,2,3,4});
    }

    @Test
    void testCase4(){
        System.out.println("Test case 4");
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void testCase5(){

        System.out.println("Test case 5");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1,c2);
        assertNotSame(c1,c3);
    }

    @Test
    void  add(){

        int actual = Calculator.add(2,3);
        assertEquals(5,actual,"It's not matching with expected value.");
    }

    @Test
    void  add2(){

       assertThrows(IllegalArgumentException.class, () -> Calculator.add2(5,2));
    }

}