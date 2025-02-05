import com.day5.linearsearch.SearchSpecificWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSpecificWordTest {
    @Test
    void searchWord(){
        SearchSpecificWord obj = new SearchSpecificWord();
        String[] sentences ={"Hello everyone.",
                "Welcome to the world of programming.",
                "As we no know that java is programming language.",
                "There are four pillar in oops."};

        String words ="java";
        assertEquals("As we no know that java is programming language.",obj.findSentenceWithWord(sentences,words));

    }
}
