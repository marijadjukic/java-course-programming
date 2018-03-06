package course2.week.three;

import edu.duke.*;
import sun.rmi.runtime.Log;

import java.util.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    private HashMap<String, Integer> counts;
    private HashMap<String, ArrayList<String>> ipsForDays;

    public LogAnalyzer(){
        records = new ArrayList<LogEntry>();
        counts = new HashMap<String, Integer>();
        ipsForDays = new HashMap<String, ArrayList<String>>();
    }

    public HashMap<String, Integer> getCounts() {
        return counts;
    }

    public HashMap<String, ArrayList<String>> getIpsForDays() {
        return ipsForDays;
    }

    public void readFile(String filename){
        FileResource fr = new FileResource(filename);
        for(String line : fr.lines()){
           LogEntry log = WebLogParser.parseEntry(line);
           records.add(log);
        }
    }

    public int countUniqueIps(){
        //ArrayList<String> uniqueIps = new ArrayList<String>();
        //for(LogEntry le : records){
        //   String ipAddr = le.getIpAddress();
        //    if(!uniqueIps.contains(ipAddr)){
        //        uniqueIps.add(ipAddr);
        //   }
        //}
        HashMap<String, Integer> counts = countVisitsPerIP();
        return counts.size();
    }

    public void printAll(){
        for(LogEntry le : records){
            System.out.println(le);
        }
    }

    public void printAllHigherThanNum(int num){
        for(LogEntry le : records){
            int statusCode = le.getStatusCode();
            if(statusCode>num){
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIps = new ArrayList<String>();
        ArrayList<String> uniqueIpVisit = new ArrayList<String>();
        for(LogEntry le : records){
            Date time = le.getAccessTime();
            String day = time.toString();
            String mmmdd = day.substring(4,10);
            if(mmmdd.equals(someday)){
                String ipAddr = le.getIpAddress();
                if(!uniqueIps.contains(ipAddr)){
                    uniqueIps.add(ipAddr);
                    uniqueIpVisit.add(ipAddr);
                }
            }
        }
        System.out.println("Size of an array list is " + uniqueIpVisit.size());
        return uniqueIpVisit;
    }

    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqeIPsInRange = new ArrayList<String>();
        ArrayList<String> uniqueIps = new ArrayList<String>();
        for (LogEntry le : records){
            int statusCode = le.getStatusCode();
            if(statusCode>=low && statusCode<=high){
                String ipAddr = le.getIpAddress();
                if(!uniqueIps.contains(ipAddr)){
                    uniqueIps.add(ipAddr);
                    uniqeIPsInRange.add(ipAddr);
                }
            }

        }
        return uniqeIPsInRange.size();
    }
    public HashMap<String, Integer> countVisitsPerIP(){
        for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> countVisit){
        int maxNum = 0;
        countVisit = countVisitsPerIP();
        for (String ip : countVisit.keySet()){
            int value = countVisit.get(ip);
            if (value > maxNum){
                maxNum = value;
            }
        }
        return maxNum;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> countVisit){
        ArrayList<String> ips = new ArrayList<>();
        int maxNum = mostNumberVisitsByIP(countVisit);
        for (String ip : countVisit.keySet()){
            if (countVisit.get(ip) == maxNum){
                ips.add(ip);
            }
        }
        return ips;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        for(LogEntry le : records){
            Date time = le.getAccessTime();
            String day = time.toString();
            String mmmdd = day.substring(4,10);
            String ip = le.getIpAddress();
            if(!ipsForDays.containsKey(mmmdd)){
                ArrayList<String> newIps = new ArrayList<String>();
                newIps.add(ip);
                ipsForDays.put(mmmdd,newIps);

            } else {
                ArrayList<String> ips = ipsForDays.get(mmmdd);
                ips.add(ip);
                ipsForDays.put(mmmdd,ips);
            }
        }
        return ipsForDays;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> mapDays){
        mapDays = iPsForDays();
        int maxValue = 0;
        String mostVisitedDay = null;
        for(String day : mapDays.keySet()){
            int value = mapDays.get(day).size();
            if(value > maxValue){
                maxValue = value;
                mostVisitedDay = day;
            }
        }
        return mostVisitedDay;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> mapDays, String day){
        ArrayList<String> ipsMostVisit = new ArrayList<String>();
        int maxNum = 0;
        mapDays = iPsForDays();
        ArrayList<String> ipsOnDay = mapDays.get(day);
        HashMap<String, Integer> countIps = new HashMap<String, Integer>();
        for(int i = 0; i<ipsOnDay.size(); i++){
            String ip = ipsOnDay.get(i);
            if(!countIps.containsKey(ip)){
                countIps.put(ip,1);
            } else {
                countIps.put(ip, countIps.get(ip) + 1);
            }
        }
        for(String ip : countIps.keySet()){
            if(countIps.get(ip)>maxNum){
                maxNum = countIps.get(ip);
            }
        }
        for(String ip : countIps.keySet()){
            if(countIps.get(ip) == maxNum){
                ipsMostVisit.add(ip);
            }
        }
        return ipsMostVisit;
    }


}
