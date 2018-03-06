package course2.week.one;

import edu.duke.FileResource;
import org.junit.Test;

public class WordLengthsTest {
    @Test
    public void testCountWordLengths(){
        WordLengths wl = new WordLengths();
        FileResource resource = new FileResource("manywords.txt");
        int[] counts = new int[31];
        wl.countWordLengths(resource,counts);

        int [] value = counts;
        int maxIndex = wl.indexOfMax(value);
        System.out.println("The most common word length in the file " + maxIndex);
    }
}
