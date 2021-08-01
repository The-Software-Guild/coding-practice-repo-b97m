package com.bm.vendingmachine.ui;

import com.bm.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public class VendingMachineView {
    private UserIo userIo;

    public VendingMachineView(UserIo userIo) {
        this.userIo = userIo;
    }
    
    public void displayLine(String line) {
        userIo.displayLine(line);
    }
    
    public void displayErrorLine(String line) {
        userIo.displayErrorLine(line);
    }
    
    public void displayMainMenuOptions(String[] options) {
        userIo.displayAroundContents("MAIN MENU OPTIONS", options);
    }
    
    public void displayVendingItems(List<VendingMachineItem> items) {
        items.forEach(item -> {
            this.userIo.displayAroundContents(
                item.getName(),
                new String[] {
                    "Cost: $" + item.getCost(),
                    "Quantity available: " + item.getQuantity()
                }
            );
        });
    }
    
    public Supplier<Integer> intSupplier(
        String prompt, 
        Predicate<Integer> test, 
        String errorText) {
        
        return userIo.intSupplier(prompt, test, errorText);
    }
    
    public Supplier<String> stringSupplier(
        String prompt, 
        Predicate<String> test, 
        String errorText) {
        
        return userIo.stringSupplier(prompt, test, errorText);
    }
    
    public Supplier<BigInteger> BigIntegerSupplier(
        String prompt, 
        Predicate<BigInteger> test, 
        String errorText) {
        
        return userIo.BigIntegerSupplier(prompt, test, errorText);
    }
    
    public Supplier<BigDecimal> BigDecimalSupplier(
        String prompt, 
        Predicate<BigDecimal> test, 
        String errorText) {
        
        return userIo.BigDecimalSupplier(prompt, test, errorText);
    }

    public void close() {
        userIo.close();
    }
}