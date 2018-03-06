package week.four;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100) {
                System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int countNames = 0;
        int countGirlsNames = 0;
        int countBoysNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            countNames++;
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;

            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
                countBoysNames++;
            } else {
                totalGirls += numBorn;
                countGirlsNames++;
            }
        }
        System.out.println("Total births = " + totalBirths);
        System.out.println("Total girls = " + totalGirls);
        System.out.println("Total boys = " + totalBoys);
        System.out.println("Total number of names = " + countNames);
        System.out.println("Total number of girls names = " + countGirlsNames);
        System.out.println("Total number of boys names = " + countBoysNames);
    }

    public int getRank (Integer year, String name, String gender ){
        int rank = 0;
        FileResource fr = new FileResource("us_babynames_by_year/yob"+ year +".csv");

        for(CSVRecord rec : fr.getCSVParser(false)){
            if (gender.equals(rec.get(1))){
                rank++;
            }
            if (name.equals(rec.get(0)) && gender.equals(rec.get(1))) {
                    return rank;
            }
        }
        return -1;
    }

    public String getName(Integer year, Integer rank, String gender){
        FileResource fr = new FileResource("us_babynames_by_year/yob"+ year +".csv");
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(!gender.equals(rec.get(1))){
                continue;
            }
            String name1 = rec.get(0);
            int rank1 = getRank(year, name1, gender);
            if (rank == rank1) {
                return rec.get(0);
            }
        }
        return "NO NAME";
    }

    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        String newName = null;
        int rank = 0;
        rank = getRank(year, name, gender);
        newName = getName(newYear, rank, gender);

        return newName;
    }

    public int yearOfHighestRank(String name, String gender){
        int rank = Integer.MAX_VALUE;
        int result = -1;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            String fileName = f.getName();
            String sYear = fileName.substring(3,7);
            int year = Integer.parseInt(sYear);
            int currentRank = getRank(year,name,gender);
            if (currentRank < rank && currentRank>0){
                    rank = currentRank;
                    result = year;
            }
        }
        return result;
    }

    public double getAverageRank (String name, String gender){
        double totalRank = 0.0;
        double averageRank = 0.0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            count++;
            String fileName = f.getName();
            String sYear = fileName.substring(3,7);
            int year = Integer.parseInt(sYear);
            int rank = getRank(year,name,gender);
            if (rank == -1){
                return -1.0;
            }
            totalRank = totalRank + rank;
        }
        averageRank = totalRank/count;
        return averageRank;
    }
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        FileResource fr = new FileResource("us_babynames_by_year/yob"+ year +".csv");
        int rank = getRank(year, name, gender);
        int total = 0;
        int newRank = 0;
        if(rank == -1){
            return -1;
        }
        for(CSVRecord rec : fr.getCSVParser(false)){
            if (newRank > rank){
                break;
            }
            if(!gender.equals(rec.get(1))){
                continue;
            }
            String newName = rec.get(0);
            newRank = getRank(year,newName,gender);
            if (gender.equals(rec.get(1)) && rank>newRank){
                int births = Integer.parseInt(rec.get(2));
                total = total + births;
            }
        }
        return total;
    }

}
