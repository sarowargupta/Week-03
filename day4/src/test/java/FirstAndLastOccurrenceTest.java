import com.day5.binarysearch.FirstAndLastOccurrence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstAndLastOccurrenceTest {
    @Test
    public void testFindFirstAndLast_TargetFound() {
        int[] arr = {5, 7, 7, 8, 8, 8, 10};
        int target = 7;

        int[] result = FirstAndLastOccurrence.findFirstAndLast(arr, target);

        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }
}
