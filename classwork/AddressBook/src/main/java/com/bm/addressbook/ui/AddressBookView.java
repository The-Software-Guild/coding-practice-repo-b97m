/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.addressbook.ui;


public class AddressBookView {
    private UserIO userIO;

    public AddressBookView(UserIO userIO) {
        this.userIO = userIO;
    }
    
    public MenuChoice retrieveMenuChoice() {
        this.userIO.displayMenuChoices();
        return this.userIO.queryMenuChoice();
    }
    
    public String retrieveString(String prompt) {
        this.userIO.displayText(prompt);
        return this.userIO.queryString();
    }
    
    public void displayText(String text) {
        this.userIO.displayText(text);
    }
    
    public void displayMenuChoices() {
        this.userIO.displayMenuChoices();;
    }
}
