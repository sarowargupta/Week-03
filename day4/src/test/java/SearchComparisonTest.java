import com.day6.SearchComparison;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchComparisonTest {
    @Test
    void testLinearSearch() {
        int[] data = {10, 20, 30, 40, 50};
        assertEquals(2, SearchComparison.linearSearch(data, 30));
        assertEquals(4, SearchComparison.linearSearch(data, 50));
    }

    @Test
     void testBinarySearch() {
        int[] data = {10, 20, 30, 40, 50};
        assertEquals(2, SearchComparison.binarySearch(data, 30));
        assertEquals(4, SearchComparison.binarySearch(data, 50));
    }
}