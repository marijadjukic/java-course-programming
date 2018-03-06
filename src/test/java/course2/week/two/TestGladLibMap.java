package course2.week.two;

import org.junit.Test;


public class TestGladLibMap {
    @Test
    public void makeStory(){
        GladLibMap glm = new GladLibMap();
        System.out.println("\n");
        String story = glm.fromTemplate("data/madtemplate2.txt");
        glm.printOut(story, 60);
        System.out.println();
        System.out.println("Total number of words that were replaced is " + glm.totalWordsConsidered());
        System.out.println("Total number of words that were possible to pick from is " + glm.totalWordsInMap());
    }
}
