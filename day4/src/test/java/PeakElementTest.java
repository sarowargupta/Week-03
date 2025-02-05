import com.day5.binarysearch.PeakElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeakElementTest {
    @Test
    public void testSinglePeak() {
        PeakElement obj = new PeakElement();
        int[] arr = {1, 30, 50, 60, 10};
        int expectedIndex = 3;
        assertEquals(expectedIndex,obj.findPeakElement(arr));
    }
}
