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

package com.bm.statecapitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class StateCapitals {
    public static void main(String[] args) {
        Map<String, String> stateCapitalMap = new HashMap<>();
        
        // hard coding all the states and their capitals
        stateCapitalMap.put("Alabama", "Montgomery");
        stateCapitalMap.put("Alaska", "Juneau");
        stateCapitalMap.put("Arizona", "Phoenix");
        stateCapitalMap.put("Arkansas", "Little Rock");
        stateCapitalMap.put("California", "Sacramento");
        stateCapitalMap.put("Colorado", "Denver");
        stateCapitalMap.put("Connecticut", "Hartford");
        stateCapitalMap.put("Delaware", "Dover");
        stateCapitalMap.put("Florida", "Tallahassee");
        stateCapitalMap.put("Georgia", "Atlanta");
        stateCapitalMap.put("Hawaii", "Honolulu");
        stateCapitalMap.put("Idaho", "Boise");
        stateCapitalMap.put("Illinois", "Springfield");
        stateCapitalMap.put("Indiana", "Indianapolis");
        stateCapitalMap.put("Iowa", "Des Moines"); 
        stateCapitalMap.put("Kansas", "Topeka"); 
        stateCapitalMap.put("Kentucky", "Frankfort"); 
        stateCapitalMap.put("Louisiana", "Baton Rouge"); 
        stateCapitalMap.put("Maine", "Augusta"); 
        stateCapitalMap.put("Maryland", "Annapolis"); 
        stateCapitalMap.put("Massachusetts", "Boston"); 
        stateCapitalMap.put("Michigan", "Lansing"); 
        stateCapitalMap.put("Minnesota", "Saint Paul"); 
        stateCapitalMap.put("Mississippi", "Jackson"); 
        stateCapitalMap.put("Missouri", "Jefferson City"); 
        stateCapitalMap.put("Montana", "Helena"); 
        stateCapitalMap.put("Nebraska", "Lincoln"); 
        stateCapitalMap.put("Nevada", "Carson City"); 
        stateCapitalMap.put("New Hampshire", "Concord"); 
        stateCapitalMap.put("New Jersey", "Trenton"); 
        stateCapitalMap.put("New Mexico", "Santa Fe"); 
        stateCapitalMap.put("New York", "Albany"); 
        stateCapitalMap.put("North Carolina", "Raleigh"); 
        stateCapitalMap.put("North Dakota", "Bismarck"); 
        stateCapitalMap.put("Ohio", "Columbus"); 
        stateCapitalMap.put("Oklahoma", "Oklahoma City"); 
        stateCapitalMap.put("Oregon", "Salem"); 
        stateCapitalMap.put("Pennsylvania", "Harrisburg"); 
        stateCapitalMap.put("Rhode Island", "Providence"); 
        stateCapitalMap.put("South Carolina", "Columbia"); 
        stateCapitalMap.put("South Dakota", "Pierre"); 
        stateCapitalMap.put("Tennessee", "Nashville"); 
        stateCapitalMap.put("Texas", "Austin"); 
        stateCapitalMap.put("Utah", "Salt Lake City"); 
        stateCapitalMap.put("Vermont", "Montpelier"); 
        stateCapitalMap.put("Virginia", "Richmond"); 
        stateCapitalMap.put("Washington", "Olympia"); 
        stateCapitalMap.put("West Virginia", "Charleston"); 
        stateCapitalMap.put("Wisconsin", "Madison"); 
        stateCapitalMap.put("Wyoming", "Cheyenne");
        
        System.out.println("STATES:");
        System.out.println("=======");
        for (String state : stateCapitalMap.keySet()) {
            System.out.println(state);
        }
        
        System.out.println("CAPITALS:");
        System.out.println("=======");
        for (String state : stateCapitalMap.keySet()) {
            System.out.println(stateCapitalMap.get(state));
        }
        
        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("====================");
        for (Entry<String, String> pair : stateCapitalMap.entrySet()) {
            System.out.format("%14s - %-20s%n", pair.getKey(), pair.getValue());
        }
    }
}
