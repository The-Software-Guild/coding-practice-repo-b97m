/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bm.vendingmachine.controller;

import com.bm.vendingmachine.dao.exceptions.FailedLoadOfVendingItemsException;
import com.bm.vendingmachine.dao.exceptions.FailedSaveOfVendingItemsException;
import com.bm.vendingmachine.service.VendingMachineService;
import com.bm.vendingmachine.ui.VendingMachineView;

/**
 * Serves as controller for the whole application
 * 
 * Communicates with service and view components
 * 
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public class VendingMachineController {
    private VendingMachineView view;
    private VendingMachineService service;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }
    
    public void run() {
        
        try {
            service.loadItems();
        } catch (FailedLoadOfVendingItemsException ex) {
            view.displayErrorLine(
                "Warning: Unable to load vending items into memory"
            );
        }
        
        boolean active = true;
        
        view.displayMainMenuOptions(new String[] {
            "Add funds",
            "Purchase an Item"
        });
        // while(active) {
        view.displayVendingItems(service.getAllItems());
        // }
        
        try {
            this.service.saveItems();
        } catch (FailedSaveOfVendingItemsException ex) {
            this.view.displayErrorLine("Warning: Unable to save vending items");
        }
        this.view.close();
    }
}
