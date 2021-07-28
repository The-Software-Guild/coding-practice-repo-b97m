/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.statecapitals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class StateCapitals3 {
    public static final String STE_CAP_FNAME = "MoreStateCapitals.txt";
    
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Capital> stateCapitalMap = new HashMap<>();
        
        Scanner fInput = new Scanner(new BufferedReader(new FileReader(STE_CAP_FNAME)));
        
        while (fInput.hasNextLine()) {
            String record[] = fInput.nextLine().split("::");
            
            String state = record[0];
            
            String capName = record[1];
            int population = Integer.parseInt(record[2]);
            double sqMiles = Double.parseDouble(record[3]);
            Capital capital = new Capital(capName, population, sqMiles);
            
            stateCapitalMap.put(state, capital);
        }
        fInput.close();
        
        System.out.format(
            "|| %d State-Capital Mappings Loaded ||%n", 
            stateCapitalMap.size()
        );
        
        System.out.println();
        
        printHeaders();
        stateCapitalMap.entrySet().stream()
            .sorted((Entry<String, Capital> a, Entry<String, Capital> b) -> {
                return a.getKey().compareTo(b.getKey());
            })
            .forEach(entry -> {
                System.out.format(
                    "%14s - %-18s | %-10d | %7.2f%n",
                    entry.getKey(),
                    entry.getValue().getName(),
                    entry.getValue().getPopulation(),
                    entry.getValue().getSqMiles()
                );
            });
        System.out.println("-".repeat(69));
        
        System.out.println();
        
        System.out.println("|| At this point, you will query info ||");
        System.out.println("|| for all states whose population    ||");
        System.out.println("|| exceeds a given integer            ||");
        
        System.out.println();
        
        Scanner uInput = new Scanner(System.in);
        
        int popMin = queryPopMin(uInput);
        
        printHeaders();
        stateCapitalMap.entrySet().stream()
            .filter((Entry<String, Capital> x) -> {
                return x.getValue().getPopulation() > popMin;
            })
            .sorted((Entry<String, Capital> a, Entry<String, Capital> b) -> {
                return a.getKey().compareTo(b.getKey());
            })
            .forEach(entry -> {
                System.out.format(
                    "%14s - %-18s | %-10d | %7.2f%n",
                    entry.getKey(),
                    entry.getValue().getName(),
                    entry.getValue().getPopulation(),
                    entry.getValue().getSqMiles()
                );
            });
        System.out.println("-".repeat(69));
        
        System.out.println();
        
        System.out.println("|| Now you will query info for all states ||");
        System.out.println("|| whose area (in square miles) is less   ||");
        System.out.println("|| than some given number                 ||");
        
        System.out.println();
        
        double sqMax = querySqMax(uInput);
        uInput.close();
        
        printHeaders();
        stateCapitalMap.entrySet().stream()
            .filter((Entry<String, Capital> x) -> {
                return x.getValue().getSqMiles() < sqMax;
            })
            .sorted((Entry<String, Capital> a, Entry<String, Capital> b) -> {
                return a.getKey().compareTo(b.getKey());
            })
            .forEach(entry -> {
                System.out.format(
                    "%14s - %-18s | %-10d | %7.2f%n",
                    entry.getKey(),
                    entry.getValue().getName(),
                    entry.getValue().getPopulation(),
                    entry.getValue().getSqMiles()
                );
            });
        System.out.println("-".repeat(69));
    }
    
    public static void printHeaders() {
        System.out.println("-".repeat(69));        
        System.out.format(
            "%14s - %-18s | %-10s | %-16s%n",
            "State",
            "Capital",
            "Population",
            "Area (sq. miles)"
        );
        System.out.println("-".repeat(69));
    }
    
    public static int queryPopMin(Scanner uInput) {
        int popMin = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("?? What do wish the above integer to be ??");
            try {
                popMin = Integer.parseInt(uInput.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("!!------------- Error --------------!!");
                System.out.println("!! The input could not be converted !!");
                System.out.println("!! to an integer                    !!");
                System.out.println("!!----------------------------------!!");
            }
            System.out.println();
        }
        return popMin;
    }
    
    public static double querySqMax(Scanner uInput) {
        double sqMax = Double.POSITIVE_INFINITY;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("?? What do you wish the above number to be ??");
            try {
                sqMax = Double.parseDouble(uInput.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("!!------------- Error --------------!!");
                System.out.println("!! The input could not be converted !!");
                System.out.println("!! to a number                      !!");
                System.out.println("!!----------------------------------!!");
            }
            System.out.println();
        }
        return sqMax;
    }
}