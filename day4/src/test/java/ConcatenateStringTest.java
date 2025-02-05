import com.day4.stringbuffer.ConcatenateString;
import org.junit.jupiter.api.Test;
import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcatenateStringTest {
    @Test
    void concatenate(){
        ConcatenateString obj = new ConcatenateString();
        String[] str = {"Hello"," ","World"};
        assertEquals("Hello World",obj.concatenateString(str));
        out.println("Concatenate String is: " + obj.concatenateString(str));

    }
}
