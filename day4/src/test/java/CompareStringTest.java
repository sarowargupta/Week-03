import com.day4.stringbuffer.CompareString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CompareStringTest {
    @Test

    public void testCompareString() {
        CompareString obj = new CompareString();
        String input = "hello";

        // Expected result
        long[] expected = {136, 120};

        // Actual result from the compareString method
        long[] actual = obj.compareStringBufferByStringBuilder(input);
        assertArrayEquals(expected, actual);


    }
}
