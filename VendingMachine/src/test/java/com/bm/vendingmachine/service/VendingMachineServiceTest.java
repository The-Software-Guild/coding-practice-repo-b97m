/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.vendingmachine.service;

import com.bm.vendingmachine.dto.VendingMachineItem;
import com.bm.vendingmachine.service.exceptions.InsufficientFundsException;
import com.bm.vendingmachine.service.exceptions.NoItemInventoryException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Benjamin Munoz
 */
public class VendingMachineServiceTest {
    
    private VendingMachineService service;
    
    public VendingMachineServiceTest() {
    }

    @BeforeEach
    public void setupService() {
        service = new VendingMachineService(
            new VendingMachineDaoStubImpl(),
            new VendingMachineAuditDaoStubImpl()
        );
    }
    
    @Test
    public void testGetAllItems() {
        List<VendingMachineItem> items = service.getAllItems();
        assertNotNull(items, "This element should not be null");
        
        // check consistency with the stub implementation of dao
        assertEquals(items.size(), 2, "There should be two items");
        assertTrue(
            items.contains(
                new VendingMachineItem(
                    "Pepsi", 
                    new BigDecimal("2.99"), 
                    new BigInteger("10")
                )
            )
        );
        assertTrue(
            items.contains(
                new VendingMachineItem(
                    "Coke", 
                    new BigDecimal("2.99"), 
                    new BigInteger("1")
                )
            )
        );
    }

    @Test
    public void testGetFundsAndAddCoins() {
        assertEquals(
            service.getFundsAvailable(), 
            BigDecimal.ZERO,
            "Services should start off with no funds"
        );
        
        BigDecimal totalFunds = BigDecimal.ZERO;
        for (Coin coin : Coin.values()) {
            service.addCoins(coin, BigInteger.ONE);
            totalFunds = totalFunds.add(coin.getValue());
        }
        
        assertEquals(service.getFundsAvailable(), totalFunds);
        
        totalFunds = totalFunds.add(new BigDecimal("0.15"));
        service.addCoins(Coin.NICKEL, new BigInteger("3"));
        
        assertEquals(service.getFundsAvailable(), totalFunds);
    }

    @Test
    public void testTransactItem() {
        List<VendingMachineItem> items = service.getAllItems();
        assertNotNull(items, "This element should not be null");
        
        // check consistency with the stub implementation of dao
        assertEquals(items.size(), 2, "There should be two items");
        assertTrue(
            items.contains(
                new VendingMachineItem(
                    "Pepsi", 
                    new BigDecimal("2.99"), 
                    new BigInteger("10")
                )
            )
        );
        assertTrue(
            items.contains(
                new VendingMachineItem(
                    "Coke", 
                    new BigDecimal("2.99"), 
                    new BigInteger("1")
                )
            )
        );
        
        try {
            service.transactItem("aowejfoawiejf");
        } catch (NoItemInventoryException ex) {
        } catch (InsufficientFundsException ex) {
            fail("Should've thrown a NoItemInventoryException");
        }
        
        try {
            service.transactItem("Pepsi");
        } catch (NoItemInventoryException ex) {
            fail("Should've thrown an InsufficientFundsException");
        } catch (InsufficientFundsException ex) {
        }
        
        // should be enough to buy a Pepsi and two Cokes
        // according to the stub implementation
        service.addCoins(Coin.QUARTER, new BigInteger("36"));
        
        try {
            service.transactItem("Pepsi");
        } catch (InsufficientFundsException | NoItemInventoryException ex) {
            fail("No exceptions should be thrown");
        }
        
        try {
            service.transactItem("Coke");
        } catch (InsufficientFundsException | NoItemInventoryException ex) {
            fail("No exceptions should be thrown");
        }
        
        items = service.getAllItems();
        assertNotNull(items, "This element should not be null");
        
        // Expect only the quantites of the items to change
        assertEquals(items.size(), 2, "There should still be two items");
        assertTrue(
            items.contains(
                new VendingMachineItem(
                    "Pepsi", 
                    new BigDecimal("2.99"), 
                    new BigInteger("9")
                )
            )
        );
        assertTrue(
            items.contains(
                new VendingMachineItem(
                    "Coke", 
                    new BigDecimal("2.99"), 
                    new BigInteger("0")
                )
            )
        );
        
        try {
            service.transactItem("Coke");
        } catch (NoItemInventoryException ex) {
        } catch (InsufficientFundsException ex) {
            fail("Should've thrown NoItemInventoryException");
        }
    }
}
