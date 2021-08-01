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
    
    public void displayInformationalLine(String line) {
        userIo.displayInformationalLine(line);
    }
    
    public void displayErrorLine(String line) {
        userIo.displayErrorLine(line);
    }
    
    public void displayMainMenuOptions(String... options) {
        userIo.displayAroundContents("MAIN MENU OPTIONS", options);
    }
    
    public void displayCoinDepositOptions(String... options) {
        userIo.displayAroundContents("COIN DEPOSIT OPTIONS", options);
    }
    
    public void displayVendingItems(List<VendingMachineItem> items) {
        this.userIo.displayInformationalLine("Featured Vending Items");
        items.forEach(item -> {
            this.userIo.displayAroundContents(
                item.getName(),
                new String[] {
                    "Cost: $" + item.getCost(),
                    "Quantity: " + item.getQuantity()
                }
            );
        });
    }
    
    public void displayChange(BigDecimal change) {
        BigInteger cents = change.multiply(new BigDecimal("100")).toBigInteger();
        
        BigInteger quarters = cents.divide(new BigInteger("25"));
        cents = cents.remainder(new BigInteger("25"));
        
        BigInteger dimes = cents.divide(new BigInteger("10"));
        cents = cents.remainder(new BigInteger("10"));
        
        BigInteger nickels = cents.divide(new BigInteger("5"));
        cents = cents.remainder(new BigInteger("5"));
        
        userIo.displayAroundContents(
            "Change provided",
            new String[] {
                "Quarters: " + quarters.toString(),
                "Dimes: " + dimes.toString(),
                "Nickels: " + nickels.toString(),
                "Pennies: " + cents.toString()
            }
        );
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
    
    public Supplier<BigInteger> bigIntegerSupplier(
        String prompt, 
        Predicate<BigInteger> test, 
        String errorText) {
        
        return userIo.bigIntegerSupplier(prompt, test, errorText);
    }
    
    public Supplier<BigDecimal> bigDecimalSupplier(
        String prompt, 
        Predicate<BigDecimal> test, 
        String errorText) {
        
        return userIo.bigDecimalSupplier(prompt, test, errorText);
    }

    public void close() {
        userIo.close();
    }
}