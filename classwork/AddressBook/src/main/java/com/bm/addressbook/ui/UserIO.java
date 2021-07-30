/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.addressbook.ui;


public interface UserIO {
    /**
     * Retrieve a string from the user
     * @return The aforementioned string
     */
    public String queryString();
    
    /**
     * Display text to the user
     * @param prompt The text to display
     */
    public void displayText(String prompt);
    
    /**
     * Display the possible menu choices to the user
     */
    public void displayMenuChoices();
    
    /**
     * Retrieve a MenuChoice from the user
     * @return the aforementioned MenuChoice
     */
    public MenuChoice queryMenuChoice();
}
