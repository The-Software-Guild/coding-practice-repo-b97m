/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.addressbook.ui;

import java.util.Scanner;


public class ConsoleIO implements UserIO {
    private Scanner input;
    
    public ConsoleIO(Scanner input) {
        this.input = input;
    }
    
    @Override
    public void displayMenuChoices() {
        MenuChoice[] choices = MenuChoice.values();
        System.out.println("--- Select an operation to perform ---");
        for (int i = 0; i < choices.length; i++) {
            String choiceString;
            switch (choices[i]) {
                case ADD:
                    choiceString = "Add an Address";
                    break;
                case DELETE:
                    choiceString = "Delete an Address";
                    break;
                case FIND:
                    choiceString = "Find an Address";
                    break;
                case TALLY:
                    choiceString = "List Address Count";
                    break;
                case ALL:
                    choiceString = "List all Addresses";
                    break;
                case EXIT:
                    choiceString = "Exit";
                    break;
                default:
                    choiceString = "(Unknown Operation)";
            }
            System.out.format("    %d: %s%n", i, choiceString);
        }
        System.out.println("-".repeat(38));
    }
    
    @Override
    public MenuChoice queryMenuChoice() {
        MenuChoice[] choices = MenuChoice.values();
        int choiceIndex = -1;
        boolean isValid = false;
        while (!isValid) {
            try {
                choiceIndex = Integer.parseInt(input.nextLine());
                if (choiceIndex < 0 || choices.length <= choiceIndex) {
                    System.out.println("!!--------- Error ---------!!");
                    System.out.println("!! The input is not one of !!");
                    System.out.println("!!    the above choices    !!");
                    System.out.println("!!-------------------------!!");
                    System.out.println("----- Enter valid input -----");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("!!------------- Error --------------!!");
                System.out.println("!! The input could not be converted !!");
                System.out.println("!!     converted into an integer    !!");
                System.out.println("!!----------------------------------!!");
                System.out.println("---------- Enter valid input ---------");
            }
        }
        return choices[choiceIndex];
    }

    @Override
    public String queryString() {
        return input.nextLine();
    }

    @Override
    public void displayText(String prompt) {
        System.out.println(prompt);
    }
}
