import com.day5.binarysearch.RotationPointInRotatedSortedArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotationPointInRotatedSortedArrayTest {
    @Test
    public void rotationPoint() {
        RotationPointInRotatedSortedArray obj = new RotationPointInRotatedSortedArray();
        int[] arr = {10,10,10,1,8,9};
        int expectedIndex = 3;
        assertEquals(expectedIndex, obj.findRotationPoint(arr));
    }

}
