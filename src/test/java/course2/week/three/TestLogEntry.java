package course2.week.three;

import course2.week.three.LogEntry;

import edu.duke.*;
import org.junit.Test;

import java.util.*;

public class TestLogEntry {
    @Test
    public void testLogEntry(){
        LogEntry le = new LogEntry("1.2.3.4.", new Date(),"example request", 200, 500);
        System.out.println(le);

        LogEntry le2 = new LogEntry("1.2.100.4.", new Date(),"example request 2", 300, 400);
        System.out.println(le2);
    }
    @Test
    public void testLogAnalyzer(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    @Test
    public void testCountUnqueIPs(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("There are " + la.countUniqueIps() + " IPs");
    }
    @Test
    public void tetPrintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log.txt");
        la.printAllHigherThanNum(400);
    }
    @Test
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println(la.uniqueIPVisitsOnDay("Sep 27"));
    }
    @Test
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println(la.countUniqueIPsInRange(200,299));
    }
    @Test
    public void testCountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log.txt");
        System.out.println("Number of times that IP address appears:" + la.countVisitsPerIP());
    }
    @Test
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("Number of most visits by IP: " + la.mostNumberVisitsByIP(la.getCounts()));
    }
    @Test
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("Ip's with most visits: " + la.iPsMostVisits(la.getCounts()));
    }
    @Test
    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println("Ip's per day: " + la.iPsForDays());
    }
    @Test
    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("Day with most IP visits is " + la.dayWithMostIPVisits(la.getIpsForDays()));
    }
    @Test
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("Ip's with most visits on day are: " + la.iPsWithMostVisitsOnDay(la.getIpsForDays(),"Sep 30"));
    }
}
