import com.day6.SortingComparison;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.day6.SearchComparison.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingComparisonTest {
    @Test
    void testBubbleSort() {
        int[] data = generateRandomArray(10000);
        int[] expected = Arrays.copyOf(data, data.length);
        Arrays.sort(expected);

        SortingComparison.bubbleSort(data);
        assertArrayEquals(expected, data);
    }
    @Test
    public void testMergeSort() {
        int[] data = generateRandomArray(10000);
        int[] expected = Arrays.copyOf(data, data.length);
        Arrays.sort(expected);

        SortingComparison.mergeSort(data, 0, data.length - 1);
        assertArrayEquals(expected, data);
    }
    @Test
    public void testQuickSort() {
        int[] data = generateRandomArray(10000);
        int[] expected = Arrays.copyOf(data, data.length);
        Arrays.sort(expected);

        SortingComparison.quickSort(data, 0, data.length - 1);
        assertArrayEquals(expected, data);
    }

}
