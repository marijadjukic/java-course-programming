package week.three;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class AssignmentCSV2 {
    public CSVRecord coldestHourInFile (CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRow : parser){
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currentTemp < coldestTemp && currentTemp != -9999){
                    coldestSoFar = currentRow;
                }
            }
        }
        return coldestSoFar;
    }

    public String fileWithColdestTemperature (){
        String fileName = null;
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
                fileName = f.getPath();
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currentTemp < coldestTemp){
                    coldestSoFar = currentRow;
                    fileName = f.getPath();
                }
            }
        }
        return fileName;
    }

    public CSVRecord lowestHumidityInFile (CSVParser parser){
        CSVRecord lowestHum = null;
        for(CSVRecord currentRow : parser){
            if (currentRow.get("Humidity").equals("N/A")){
                break;
            }
            if(lowestHum == null){
                lowestHum = currentRow;
            } else {
                int currentHum = Integer.parseInt(currentRow.get("Humidity"));
                int lowHum = Integer.parseInt(lowestHum.get("Humidity"));
                if (currentHum < lowHum){
                    lowestHum = currentRow;
                }
            }
        }
        return lowestHum;
    }

    public CSVRecord lowestHumidityInManyFiles (){
        CSVRecord lowestHum = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            if(lowestHum == null){
                lowestHum = currentRow;
            } else {
                double currentHum = Double.parseDouble(currentRow.get("Humidity"));
                double lowHum = Double.parseDouble(lowestHum.get("Humidity"));
                if (currentHum < lowHum){
                    lowestHum = currentRow;
                }
            }
        }
        return lowestHum;
    }

    public double averageTemperatureInFile(CSVParser parser){
        double averageTemp = 0.0;
        int count = 0;
        double temp = 0.0;
        for(CSVRecord currentRow : parser){
            count++;
            double tempF = Double.parseDouble(currentRow.get("TemperatureF"));
            temp = temp + tempF;
        }
        averageTemp = temp/count;
        return averageTemp;
    }

    public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
        double highHumTemp = 0.0;
        double averageTempHighHum = 0.0;
        int count = 0;
        for (CSVRecord currentRow : parser){
            double highHum = Double.parseDouble(currentRow.get("Humidity"));
            double temp = Double.parseDouble(currentRow.get("TemperatureF"));
            if(highHum >= value){
                count++;
                highHumTemp = highHumTemp + temp;
            }

        }
        averageTempHighHum = highHumTemp/count;
        if(count == 0){
            System.out.println("No temperatures with that humidity.");
        } else {
            System.out.println("Average Temp when high Humidity is " + averageTempHighHum);
        }
        return averageTempHighHum;
    }

}
