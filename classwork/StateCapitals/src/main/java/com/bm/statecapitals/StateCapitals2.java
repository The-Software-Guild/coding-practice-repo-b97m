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
import java.util.Scanner;


public class StateCapitals2 {
    public static final String STE_CAP_FNAME = "StateCapitals.txt";
    
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> stateCapitalMap = new HashMap<>();
       
        Scanner fInput = new Scanner(new BufferedReader(new FileReader(STE_CAP_FNAME)));
       
        // load in each record, which is assumed to obey the grammar
        // RECORD =: STATE_NAME::CAPITAL_NAME
        while (fInput.hasNextLine()) {
            String[] record = fInput.nextLine().split("::");
            stateCapitalMap.put(record[0], record[1]);
        }
        fInput.close();
       
        System.out.format(
            "|| %d State-Capital Mappings Loaded ||%n%n",
            stateCapitalMap.size()
        );
        
        System.out.println("-- States with Mappings --");
        stateCapitalMap.keySet().stream().sorted().forEach(System.out::println);
        System.out.println("--------------------------");
        
        System.out.println();
        
        System.out.println("||---------- POP QUIZ -----------||");
        System.out.println("|| A random state will be chosen ||");
        System.out.println("|| You must guess the capital of ||");
        System.out.println("||           that state          ||");
        System.out.println("||-------------------------------||");
        System.out.println();

        Scanner uInput = new Scanner(System.in);
        
        String[] states = stateCapitalMap.keySet().toArray(new String[0]);
        int guessesLeft = queryGuessCount(states.length, uInput);

        // shuffle states
        for (int i = guessesLeft; i < states.length; i++) {
            int testIndex = (int) (Math.random() * i);
            if (testIndex < guessesLeft) {
                String tmp = states[i];
                states[i] = states[testIndex];
                states[testIndex] = tmp;
            }
        }
        
        int points = 0;
        for (int i = 0; i < guessesLeft; i++) {
            String nextState = states[i];
            String nextGuess = queryGuess(states[i], uInput);
            String target = stateCapitalMap.get(nextState);
            int increment;
            
            if (nextGuess.equalsIgnoreCase(target)) {
                System.out.println("||   Correct, 1 point gained   ||");
                increment = 1;
            } else {
                System.out.println("|| Incorrect, 1 point deducted ||");
                increment = -1;
            }
            points += increment;
            System.out.println();
        }
        System.out.format("|| Total Score: %d ||", points);
        uInput.close();
    }    
    
    public static String queryGuess(String target, Scanner uInput) {
        String guess = "";
        System.out.format("?? What is the capital of %s ??%n", target);
        while((guess = uInput.nextLine()).length() <= 0) {
            System.out.println("(( Please enter nonempty input ))");
        }
        
        return guess.toLowerCase();
    }
    
    public static int queryGuessCount(int maximum, Scanner uInput) {
        int guesses = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("?? How many guesses would you like to guess the state ??");
            try {
                guesses = Integer.parseInt(uInput.nextLine());
                if (guesses <= 0) {
                    System.out.println("!!-------- Error ---------!!");
                    System.out.println("!! Input must be positive !!");
                    System.out.println("!!------------------------!!");
                } else if (guesses > maximum) {
                    System.out.println("!!-------------- Error ---------------!!");
                    System.out.println("!! There are not enough loaded states !!");
                    System.out.println("!!        for that many guesses       !!");
                    System.out.println("!!------------------------------------!!");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("!!------------ Error -----------!!");
                System.out.println("!! Input could not be converted !!");
                System.out.println("!!         to an integer        !!");
                System.out.println("!!------------------------------!!");
            }
            System.out.println();
        }
        return guesses;
    }
}
