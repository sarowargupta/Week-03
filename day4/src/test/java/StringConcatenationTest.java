import org.junit.jupiter.api.Test;

import static com.day6.StringConcatenation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConcatenationTest {

    @Test
    public void testConcatenateWithString() {
        int count = 1000;
        String result = concatenateWithString(count);
        assertEquals(count*5, result.length());
    }

    @Test
    public void testConcatenateWithStringBuilder() {
        int count = 1000;
        String result = concatenateWithStringBuilder(count);
        assertEquals(count*5, result.length());
    }

    @Test
    public void testConcatenateWithStringBuffer() {
        int count = 1000;
        String result = concatenateWithStringBuffer(count);
        assertEquals(count*5, result.length());
    }
}
