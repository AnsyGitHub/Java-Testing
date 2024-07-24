package helper;

 import org.junit.jupiter.api.*;

public class QuickBeforeAfterTest {

    @BeforeAll
    static void initAll(){
        System.out.println("Before Class - Runs only once");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Before Each Test - Runs before every test");
    }

    @Test
    public void test1(){
        System.out.println("task1 executed");
    }

    @Test
    public void test2(){
        System.out.println("task2 executed");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each Test - Runs after every test");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("After Class- Runs only once");
    }

}
