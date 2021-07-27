/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: (TODO)
 */

package com.bm.simplecalculator;

import java.util.Scanner;


public class App {
    public static final Scanner READER = new Scanner(System.in);
    public static enum OpChoice {
        OP_ADD,
        OP_SUB,
        OP_MULT,
        OP_DIV,
        EXIT
    };
    
    public static void main(String[] args) throws Exception {
        OpChoice currChoice;
        double[] currOperands = {0, 0};
        char opChar = '.';
        double result = 0;
        do {
            currChoice = getNextOpChoice();
            switch (currChoice) {
                case OP_ADD:
                    currOperands = getOperands();
                    opChar = '+';
                    result = SimpleCalculator.add(currOperands[0], currOperands[1]);
                    break;
                case OP_SUB:
                    currOperands = getOperands();
                    opChar = '-';
                    result = SimpleCalculator.sub(currOperands[0], currOperands[1]);
                    break;
                case OP_MULT:
                    currOperands = getOperands();
                    opChar = '*';
                    result = SimpleCalculator.mult(currOperands[0], currOperands[1]);
                    break;
                case OP_DIV:
                    currOperands = getOperands();
                    opChar = '/';
                    result = SimpleCalculator.div(currOperands[0], currOperands[1]);
                    break;
                case EXIT:
                    System.out.println("Thank you for using this program!");
                    break;
                default:
                    throw new Exception("Uncaught case");
            }
            if (currChoice != OpChoice.EXIT) {
                System.out.format(
                    "%f %c %f = %f%n%n",
                    currOperands[0],
                    opChar,
                    currOperands[1],
                    result
                );
            }
        } while (currChoice != OpChoice.EXIT);
    }
    
    public static OpChoice getNextOpChoice() {
        boolean isValid = false;
        int userChoice = 0;
        
        while (!isValid) {
            System.out.println("-- Choose an operation below --");
            System.out.println("0 -- addition");
            System.out.println("1 -- subtraction");
            System.out.println("2 -- multiplication");
            System.out.println("3 -- division");
            System.out.println("4 -- exit program");
            try {
                userChoice = Integer.parseInt(READER.nextLine());
                if (userChoice < 0 || userChoice > 4) {
                    System.out.println("!! Please enter an int in the range [0, 3] !!");
                } else {
                    isValid = true;
                }
            } catch (Exception ex) {
                System.out.println("!! That input could not be converted to an int !!");
            }
        }
        return OpChoice.values()[userChoice];
    }
    
    public static double[] getOperands() {
        double[] retr = new double[2];
        
        System.out.println("-- Left Operand --");
        retr[0] = getNextDouble();
        System.out.println("-- Right Operand --");
        retr[1] = getNextDouble();
        
        return retr;
    }
    
    public static double getNextDouble() {
        boolean isValid = false;
        double retr = 0;
        while (!isValid) {
            try {
                System.out.println("Enter a number");
                retr = Double.parseDouble(READER.nextLine());
                isValid = true;
            } catch (Exception ex) {
                System.out.println("!! That input could not be converted to a number !!");
            }
        }
        return retr;
    }
}
