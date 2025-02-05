import com.day4.stringbuilder.RemoveDuplicates;
import org.junit.jupiter.api.Test;
import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateTest {
    @Test
    void duplicate(){
        RemoveDuplicates obj = new RemoveDuplicates();
        String str = "Hello";
        assertEquals("Helo",obj.removeDuplicate(str));
        out.println("after remove duplicate: " + obj.removeDuplicate(str));
    }

}
