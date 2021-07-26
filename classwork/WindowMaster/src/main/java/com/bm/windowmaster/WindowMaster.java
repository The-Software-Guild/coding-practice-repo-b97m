/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 26, 2021
 * purpose: Code for the WindowMaster code-along
 */

package com.bm.windowmaster;

import java.util.Scanner;


public class WindowMaster {
    public static void main(String[] args) {
        boolean isValid = false;
        
        float height = 0;
        float width = 0;

        int windowCount = 0;
        
        // declare String variables to hold the user's height and 
        // width input
        String stringHeight = "";
        String stringWidth = "";
        
        
        // declare other variables
        float areaOfWindow = 0;
        float cost = 0;
        float perimeterOfWindow = 0;
        
        // cost variables
        float costPerWindowSqFt = 0;
        float costPerTrimFt = 0;
        
        // declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);
        
        // get input from the user
        // also handle bad inputs with try/catch pattern
        do {
            try {
                System.out.println("Please enter the number of windows:");
                windowCount = Integer.parseInt(myScanner.nextLine());
                isValid = windowCount >= 0;
            } catch (NumberFormatException ex) {
                System.out.println("That input was invalid");
            }
        } while (!isValid);
        
        isValid = false;        
        do {
            try {
                System.out.println("Please enter window height:");
                stringHeight = myScanner.nextLine();
                height = Float.parseFloat(stringHeight);
                isValid = height >= 0;
            } catch (NumberFormatException ex) {
                System.out.println("That input was invalid");
            }
        } while (!isValid);

        isValid = false;
        do {
            try {
                System.out.println("Please enter window width:");
                stringWidth = myScanner.nextLine();                            
                width = Float.parseFloat(stringWidth);
                isValid = width >= 0;
            } catch (NumberFormatException ex) {
                System.out.println("That input was invalid");
            }
        } while (!isValid);

        isValid = false;
        do {
            try {
                System.out.println("Please enter window width:");
                stringWidth = myScanner.nextLine();                            
                width = Float.parseFloat(stringWidth);
                isValid = width >= 0;
            } catch (NumberFormatException ex) {
                System.out.println("That input was invalid");
            }
        } while (!isValid);
        
        isValid = false;
        do {
            try {
                System.out.println("Please enter the cost per square foot of window:");
                costPerWindowSqFt = Float.parseFloat(myScanner.nextLine());
                isValid = costPerWindowSqFt >= 0;
            } catch (NumberFormatException ex) {
                System.out.println("That input was invalid");
            }
        } while (!isValid);

        isValid = false;
        do {
            try {
                System.out.println("Please enter the cost per trim foot:");
                costPerTrimFt = Float.parseFloat(myScanner.nextLine());
                isValid = costPerTrimFt >= 0;
            } catch (NumberFormatException ex) {
                System.out.println("That input was invalid");
            }
        } while (!isValid);     
        
        // calculate the area of the window
        areaOfWindow = height * width;
        
        // calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);
        
        // calculate the total cost - use a hard-coded value
        // for material cost
        cost = ((costPerWindowSqFt * areaOfWindow) + (costPerTrimFt * perimeterOfWindow));
        cost *= windowCount;
        
        // display results to the user
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);
    }
}
