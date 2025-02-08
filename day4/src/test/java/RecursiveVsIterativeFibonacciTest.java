import com.day6.RecursiveVsIterativeFibonacci;
import org.junit.jupiter.api.Test;
import static com.day6.RecursiveVsIterativeFibonacci.fibonacciRecursive;

public class RecursiveVsIterativeFibonacciTest {
    @Test
    public void testRecursiveFibonacci() {
        int[] testValues = {10, 30};
        for (int n : testValues) {
            long startTime =System.nanoTime();
            fibonacciRecursive(n);
            long endTime = System.nanoTime();
            System.out.println("Recursive Fibonacci Time: " + (endTime - startTime)/1000000.0 + " ms");
        }
    }

    @Test
    public void testIterativeFibonacci() {
        int[] testValues = {10, 30, 50};
        for (int n : testValues) {
            long startTime = System.nanoTime();
            RecursiveVsIterativeFibonacci.fibonacciIterative(n);
            long endTime = System.nanoTime();
            System.out.println("Iterative Fibonacci Time: " + (endTime - startTime)/1000000.0 + " ms");
        }
    }
}
