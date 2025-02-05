import com.day5.binarysearch.LinearAndBinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearAndBinarySearchTest {
    @Test
    public void testFindFirstMissingPositive() {
        int[] arrForLinearSearch = {3, 4, -2, 1};
        int[] arrForBinarySearch = {-6, 1, 3, 9, 10, 12};
        int target = 3;

        assertEquals(2, LinearAndBinarySearch.findFirstMissingPositive(arrForLinearSearch));

        assertEquals(2, LinearAndBinarySearch.binarySearch(arrForBinarySearch,target));

    }
}