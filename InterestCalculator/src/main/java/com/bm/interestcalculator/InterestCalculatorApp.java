/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 * purpose: (TODO)
 */

package com.bm.interestcalculator;

import java.util.Scanner;


public class InterestCalculatorApp {

    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        System.out.println("-- How much do you want to invest --");
        double principle = queryDouble(uInput);
        
        System.out.println("-- How many years are you investing --");
        int investingYears = queryPostiveInt(uInput);
        
        System.out.println(
            "-- What is the percent annual interest "
            + "rate growth (compounded quarterly)? --"
        );
        double quarterlyRate = queryDouble(uInput) / 400.0;
        double increment;
        
        System.out.println();
        System.out.println("|| Processing... ||");
        for (int i = 1; i <= investingYears; i++) { 
            System.out.format("Year %d: %n", i);
            System.out.format("Began with $%.3f%n", principle);
            
            increment = 0;
            for (int j = 0; j < 4; j++) {
                increment += principle * quarterlyRate;
                principle += principle * quarterlyRate;
            }
            System.out.format("Earned $%.3f%n", increment);
            System.out.format("Ended with $%.3f%n", principle);
            System.out.println();
        }
    }
    
    public static int queryPostiveInt(Scanner uInput) {
        boolean invalid = true;
        int retr = - 1;
        while (invalid) {
            try {
                retr = Integer.parseInt(uInput.nextLine());
                invalid = !(retr > 0);
                if (invalid) {
                    System.out.println("!! The input must be a postive integer !!");
                    System.out.println("-- Please provide a postive integer --");
                }
            } catch (NumberFormatException ex) {
                System.out.println("!! The input could not be converted !!");
                System.out.println("!! to an integer                    !!");
                System.out.println("-- Please enter an integer --");
            }
        }
        return retr;
    }
    
    public static double queryDouble(Scanner uInput) {
        boolean invalid = true;
        double retr = -1;
        while (invalid) {
            try {
                retr = Double.parseDouble(uInput.nextLine());
                invalid = false;
            } catch (NumberFormatException ex) {
                System.out.println("!! The input could not be converted !!");
                System.out.println("!! to a number                      !!");
                System.out.println("-- Please enter a number --");
            }
        }
        
        return retr;
    }
    
}
