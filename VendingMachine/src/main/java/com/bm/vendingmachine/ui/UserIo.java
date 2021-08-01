package com.bm.vendingmachine.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Provides basic user i/o functionalities
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public interface UserIo {
    public void displayLine(String line);
    public void displayErrorLine(String line);
    public void displayInformationalLine(String line);
    public void displaySolicitationLine(String line);
    public void displayAroundContents(String basis, String[] contents);
    
    public Supplier<Integer> intSupplier(
        String prompt, 
        Predicate<Integer> test, 
        String errorText
    );
    
    public Supplier<String> stringSupplier(
        String prompt, 
        Predicate<String> test, 
        String errorText
    );
    
    public Supplier<BigInteger> bigIntegerSupplier(
        String prompt, 
        Predicate<BigInteger> test, 
        String errorText
    );
    
    public Supplier<BigDecimal> bigDecimalSupplier(
        String prompt, 
        Predicate<BigDecimal> test, 
        String errorText
    );
    
    public void close();
}
