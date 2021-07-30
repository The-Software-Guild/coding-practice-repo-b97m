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

package com.bm.addressbook.controller;

import com.bm.addressbook.dao.AddressBookDao;
import com.bm.addressbook.dto.Address;
import com.bm.addressbook.dto.City;
import com.bm.addressbook.dto.Member;
import com.bm.addressbook.dto.StreetAddress;
import com.bm.addressbook.ui.AddressBookView;
import com.bm.addressbook.ui.UserIO;


public class PrimaryController {
    private AddressBookView view;
    private AddressBookDao dao;

    public PrimaryController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    public void run() {
        boolean active = true;
        while (active) {
            view.displayText("|| MAIN MENU ||");
            switch (view.retrieveMenuChoice()) {
                case ADD:
                    addAddress();
                    break;
                case DELETE:
                    deleteAddress();
                    break;
                case FIND:
                    findAddress();
                    break;
                case TALLY:
                    tally();
                    break;
                case ALL:
                    all();
                    break;
                case EXIT:
                    view.displayText("EXIT");
                    active = false;
                    break;
                default:
                    view.displayText("(Unknown command)");                    
            }
        }
        view.displayText("Thanks for using this appliation");
    }
    
    private void addAddress() {
        view.displayText("|| Address Addition Menu ||");
        String fName = view.retrieveString("--- Enter First Name ---");
        String lName = view.retrieveString("--- Enter Last Name ---");
        Member member = new Member(fName, lName);
        
        String streetNum = view.retrieveString("--- Enter Street Number ---");
        String streetName = view.retrieveString("--- Enter Street Name ---");
        StreetAddress streetAddr = new StreetAddress(streetNum, streetName);
        
        String cityName = view.retrieveString("--- Enter City ---");
        String stateName = view.retrieveString("--- Enter State ---");
        String zipCode = view.retrieveString("--- Enter Zip Code ---");
        City city = new City(cityName, stateName, zipCode);
    
        Address newAddr = new Address(streetAddr, city);
        
        dao.addAddress(member, newAddr);
        view.displayText("|| Address Added ||");
        pauseUser();
    }
    
    private void pauseUser() {
        view.retrieveString("-|- Press ENTER to continue -|-");
    } 

    private void deleteAddress() {
        view.displayText("|| ADDRESS DELETION MENU ||");
        
        String fName = view.retrieveString("--- Enter First Name ---");
        String lName = view.retrieveString("--- Enter Last Name ---");
        Member member = new Member(fName, lName);
        
        dao.removeAddressByMember(member).ifPresentOrElse(
            addr -> {
                view.displayText("|| The address record for this person ||");
                view.displayText("||          has now been removed      ||");
            },
            () -> {
                view.displayText("|| There are no addresses associated ||");
                view.displayText("||          with this person         ||");
            }
        );
        
        pauseUser();
    }
    
    private void findAddress() {
        view.displayText("|| ADDRESS QUERY MENU ||");
        
        String fName = view.retrieveString("--- Enter First Name ---");
        String lName = view.retrieveString("--- Enter Last Name ---");
        Member member = new Member(fName, lName);
        
        dao.getAddressByMember(member).ifPresentOrElse(
            addr -> {
                view.displayText("|| Address for this person ||");
                view.displayText(addr.getStreetAdddress().toString());
                view.displayText(addr.getCity().toString());
            },
            () -> {
                view.displayText("|| There are no addresses associated ||");
                view.displayText("||          with this person         ||");
            }
        );
        
        pauseUser();
    }
    
    private void tally() {
        view.displayText("|| Number of Addresses in Record ||");
        view.displayText(
            String.format("%d", dao.getAllAddresses().size())
        );
        pauseUser();
    }
    
    private void all() {
        view.displayText("|| Addresses in Record ||");
        dao.getAllAddresses().entrySet().stream().forEach(x -> {
            view.displayText(x.getKey().toString());
            view.displayText(x.getValue().getStreetAdddress().toString());
            view.displayText(x.getValue().getCity().toString());            
        });
        pauseUser();
    }
}
