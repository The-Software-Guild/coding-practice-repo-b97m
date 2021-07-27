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
    public static final UserIO USER_IO = new BasicIO(new Scanner(System.in));
    
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
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("-- Choose an operation below --\n");
        promptBuilder.append("0 -- addition\n");
        promptBuilder.append("1 -- subtraction\n");
        promptBuilder.append("2 -- multiplication\n");
        promptBuilder.append("3 -- division\n");
        promptBuilder.append("4 -- exit program");
        
        return OpChoice.values()[USER_IO.readInt(promptBuilder.toString(), 0, 4)];
    }
    
    public static double[] getOperands() {
        double[] retr = new double[2];
        
        System.out.println("-- Left Operand --");
        retr[0] = USER_IO.readDouble("Enter a number");
        System.out.println("-- Right Operand --");
        retr[1] = USER_IO.readDouble("Enter a number");
        
        return retr;
    }
}
