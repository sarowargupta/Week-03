import com.day5.linearsearch.SearchFirstNegativeNumber;
import org.junit.jupiter.api.Test;
import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchFirstNegativeNumberTest {
    @Test
    void search(){
        SearchFirstNegativeNumber obj = new SearchFirstNegativeNumber();
        int[] numbers = {1, -5, -7, 7, 8, -6};
        assertEquals(1,obj.findFirstNegative(numbers));
        out.println("First negative number found at index: " + obj.findFirstNegative(numbers));
    }
}
