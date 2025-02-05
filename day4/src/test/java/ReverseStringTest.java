import com.day4.stringbuilder.ReverseString;
import org.junit.jupiter.api.Test;
import static com.day4.stringbuilder.ReverseString.reverseString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {
    @Test
    void reverse(){
        ReverseString obj = new ReverseString();
        String str = "hello";
        assertEquals("olleh",reverseString(str));
    }
}
