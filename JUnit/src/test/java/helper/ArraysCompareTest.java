package helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.sql.Time;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    @Test
    public void testArraySort(){
        int[] numbers = {12,5,3,9};
        int[] expected = {3,5,9,12};

        Arrays.sort(numbers);
//        assertEquals(Arrays.toString(expected), Arrays.toString(numbers));
        assertArrayEquals(expected, numbers);
    }

    @Test()
    public void testArraySort_NullArray(){
        assertThrows(NullPointerException.class, () -> {
            int[] numbers = null;
            Arrays.sort(numbers);
        });
    }

    @Test
    public void testArraySort_Performance(){
        int[] arr = {12,5,7,4,9,5,7,0,3,5,7};
        assertTimeout(Duration.ofMillis(12),()->{
            for (int i = 0; i < 100000; i++){
                arr[4] = i;
                arr[1] = i + 2;
                Arrays.sort(arr);
            }
        });
    }

}
