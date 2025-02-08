import org.junit.jupiter.api.Test;
import static com.day6.FileReading.measureFileReader;
import static com.day6.FileReading.measureInputStreamReader;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReadingTest {

    private static final String FILE_1MB = "src/main/java/com/day6/1MBSize.txt";
    private static final String FILE_100MB = "src/main/java/com/day6/100MBSize.txt";
    private static final String FILE_500MB = "src/main/java/com/day6/500MBSize.txt";
    @Test
    public void testFileReaderPerformance() {

        long time1MB = measureFileReader(FILE_1MB);
        System.out.println("1MB FileReader time: " + time1MB + " ms");
        assertTrue(time1MB > 0);

        long time100MB = measureFileReader(FILE_100MB);
        System.out.println("100MB FileReader time: " + time100MB + " ms");
        assertTrue(time100MB > 0);

        long time500MB = measureFileReader(FILE_500MB);
        System.out.println("500MB FileReader time: " + time500MB + " ms");
        assertTrue(time500MB > 0);
    }
    @Test
    public void testInputStreamReaderPerformance() {

        long time1MB = measureInputStreamReader(FILE_1MB);
        System.out.println("1MB InputStreamReader time: " + time1MB + " ms");
        assertTrue(time1MB > 0);

        long time100MB = measureInputStreamReader(FILE_100MB);
        System.out.println("100MB InputStreamReader time: " + time100MB + " ms");
        assertTrue(time100MB > 0);

        long time500MB = measureInputStreamReader(FILE_500MB);
        System.out.println("500MB InputStreamReader time: " + time500MB + " ms");
        assertTrue(time500MB > 0);
    }

}
