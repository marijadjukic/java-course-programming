package week.four;

import edu.duke.FileResource;
import org.apache.commons.csv.*;
import org.junit.Test;
import java.io.*;

public class BabyBirthsTest {
    @Test
    public void testTotalBirths(){
        BabyBirths bb = new BabyBirths();
        FileResource fr = new FileResource("us_babynames_by_year/yob1905.csv");
        bb.totalBirths(fr);
    }
    @Test
    public void testGetRank(){
        BabyBirths bb = new BabyBirths();
        int rank = bb.getRank(1960, "Emily", "F");
        System.out.println(rank);
    }
    @Test
    public void testGetName(){
        BabyBirths bb = new BabyBirths();
        String name = bb.getName(1980, 350, "F");
        System.out.println(name);
    }
    @Test
    public void testWhatIsNameInYear(){
        BabyBirths bb = new BabyBirths();
        String newName = bb.whatIsNameInYear("Susan",1972,2014,"F");
        System.out.println("Susan born in 1972 would be " + newName + " if she was born in 2014");

    }
    @Test
    public void testYearOfHighestRank(){
        BabyBirths bb = new BabyBirths();
        int year = bb.yearOfHighestRank("Mich", "M");
        System.out.println(year);

    }
    @Test
    public void testGetAverageRank(){
        BabyBirths bb = new BabyBirths();
        double averageRank = bb.getAverageRank("Susan","F");
        System.out.println(averageRank);
    }
    @Test
    public void testGetTotalBirthsRankedHigher(){
        BabyBirths bb = new BabyBirths();
        int totalBirths = bb.getTotalBirthsRankedHigher(1990,"Emily", "F");
        System.out.println(totalBirths);
    }
}
