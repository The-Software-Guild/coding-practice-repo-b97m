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

package com.bm.addressbook;

import com.bm.addressbook.controller.PrimaryController;
import com.bm.addressbook.dao.BasicDao;
import com.bm.addressbook.ui.AddressBookView;
import com.bm.addressbook.ui.ConsoleIO;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        PrimaryController controller = new PrimaryController(
            new AddressBookView(
                new ConsoleIO(new Scanner(System.in))
            ),
            new BasicDao()
        );
        
        controller.run();
    }
}
