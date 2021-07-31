/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 * purpose: (TODO)
 */

package com.bm.interestcalculator;

import java.math.BigDecimal;
import java.util.Scanner;


public class InterestCalculatorApp {

    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        System.out.println("-- How much do you want to invest --");
        BigDecimal principle = queryBigDecimal(uInput);
        
        System.out.println("-- How many years are you investing --");
        BigDecimal investingYears = queryBigDecimalPositiveIntegral(uInput);
        
        System.out.println(
            "-- What is the percent annual interest "
            + "rate growth (compounded quarterly)? --"
        );
        BigDecimal quarterlyRate = queryBigDecimal(uInput).divide(BigDecimal.valueOf(400L));
        BigDecimal totalIncrement;
        
        System.out.println();
        System.out.println("|| Processing... ||");
        for (BigDecimal i = BigDecimal.ONE; i.compareTo(investingYears) <= 0; i = i.add(BigDecimal.ONE)) { 
            System.out.format("Year %s: %n", i);
            System.out.format("Began with $%s%n", principle);
            
            totalIncrement = BigDecimal.ZERO;
            for (int j = 0; j < 4; j++) {
                BigDecimal increment = principle.multiply(quarterlyRate);
                totalIncrement = totalIncrement.add(increment);
                principle = principle.add(increment);
            }
            System.out.format("Earned $%s%n", totalIncrement);
            System.out.format("Ended with $%s%n", principle);
            System.out.println();
        }
    }
    
    public static BigDecimal queryBigDecimalPositiveIntegral(Scanner uInput) {
        boolean invalid = true;
        BigDecimal retr = BigDecimal.ZERO;
        while (invalid) {
            try {
                retr = new BigDecimal(uInput.nextLine());
                invalid = (retr.signum() > 0) && 
                          (retr.equals(retr.divideToIntegralValue(BigDecimal.ONE)));
                invalid = !invalid;
                
                if (invalid) {
                    System.out.println("!! The input was not a positive integer !!");
                    System.out.println("-- Please enter a positive integer --");
                }
            } catch (NumberFormatException ex) {
                System.out.println("!! The input could not be converted !!");
                System.out.println("!! to an integer                    !!");
                System.out.println("-- Please enter an integer number --");
            }
        }
        
        return retr;
    }
    
    public static BigDecimal queryBigDecimal(Scanner uInput) {
        boolean invalid = true;
        BigDecimal retr = BigDecimal.ZERO;
        while (invalid) {
            try {
                retr = new BigDecimal(uInput.nextLine());
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
