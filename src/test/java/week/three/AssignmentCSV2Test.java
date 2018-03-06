package week.three;

import edu.duke.FileResource;
import org.apache.commons.csv.*;
import org.junit.Test;
import java.io.*;

public class AssignmentCSV2Test {
    @Test
    public void testColdestHourInFile(){
        AssignmentCSV2 assignmentCSV2 = new AssignmentCSV2();
        FileResource fr = new FileResource();
        CSVRecord coldest = assignmentCSV2.coldestHourInFile(fr.getCSVParser());
        System.out.println("The coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("TimeEDT"));
    }
    @Test
    public void testFileWithColdestTemperature(){
        AssignmentCSV2 assignmentCSV2 = new AssignmentCSV2();
        String fileName = assignmentCSV2.fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + fileName.split("\\\\")[fileName.split("\\\\").length-1]);

        FileResource fr = new FileResource(fileName);
        CSVRecord coldest = assignmentCSV2.coldestHourInFile(fr.getCSVParser());
        System.out.println("The coldest temperature on that day was " + coldest.get("TemperatureF"));

        System.out.println("All the Temperatures on the coldest day were: ");
        for (CSVRecord record : fr.getCSVParser()){
            System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));

        }

    }
    @Test
    public void testLowestHumidityInFile(){
        AssignmentCSV2 assignmentCSV2 = new AssignmentCSV2();
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = assignmentCSV2.lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    @Test
    public void testLowestHumidityInManyFiles(){
        AssignmentCSV2 assignmentCSV2 = new AssignmentCSV2();
        CSVRecord lowest = assignmentCSV2.lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    @Test
    public void testAverageTemperatureInFile(){
        AssignmentCSV2 assignmentCSV2 = new AssignmentCSV2();
        FileResource fr = new FileResource();
        double averageTemp = assignmentCSV2.averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemp);
    }
    @Test
    public void testAverageTemperatureWithHighHumidityInFile(){
        AssignmentCSV2 assignmentCSV2 = new AssignmentCSV2();
        FileResource fr = new FileResource();
        assignmentCSV2.averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
    }
}
