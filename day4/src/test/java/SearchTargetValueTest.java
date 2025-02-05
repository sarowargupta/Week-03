import com.day5.binarysearch.SearchTargetValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTargetValueTest {
    @Test
    public void testSearchMatrix_TargetFound() {
        int[][] matrix = {
                {1, 2, 5, 6},
                {10, 11, 12, 20},
                {20, 30, 34, 60}
        };

        int target = 5;

        assertTrue(SearchTargetValue.searchMatrix(matrix, target));
    }
}
