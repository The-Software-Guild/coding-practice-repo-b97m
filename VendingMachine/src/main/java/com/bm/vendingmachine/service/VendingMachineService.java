package com.bm.vendingmachine.service;

import com.bm.vendingmachine.dao.VendingMachineAuditDao;
import com.bm.vendingmachine.dao.VendingMachineDao;
import com.bm.vendingmachine.dao.exceptions.FailedLoadOfVendingItemsException;
import com.bm.vendingmachine.dao.exceptions.FailedSaveOfVendingItemsException;
import com.bm.vendingmachine.dto.VendingMachineItem;
import com.bm.vendingmachine.service.exceptions.InsufficientFundsException;
import com.bm.vendingmachine.service.exceptions.NoItemInventoryException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * ... 
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public class VendingMachineService {
    private BigDecimal fundsAvailable;
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineService(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
        this.fundsAvailable = BigDecimal.ZERO;
    }
    
    public void loadItems() throws FailedLoadOfVendingItemsException {
        dao.loadItems();
        auditDao.appendRecord("Loaded vending items into memory");
    }
    
    public void saveItems() throws FailedSaveOfVendingItemsException {
        dao.saveItems();
        auditDao.appendRecord("Saved vending items to external source(s)");
    }
    
    public List<VendingMachineItem> getAllItems() {
        auditDao.appendRecord("Acquiring list of all items");
        return dao.getAllItems();
    }
    
    public BigDecimal getFundsAvailable() {
        auditDao.appendRecord("Vending machine funds queried");
        return fundsAvailable;
    }
    
    public void addCoins(Coin coin, BigInteger quantity) {
        fundsAvailable = fundsAvailable.add(
            coin.getValue().multiply(new BigDecimal(quantity.toString()))
        );
    }
    
    public void transactItem(String itemName) throws
        NoItemInventoryException,
        InsufficientFundsException {
        
        auditDao.appendRecord("Transaction attempted for " + itemName);
        
        Optional<VendingMachineItem> possItem = dao.getItemByName(itemName);
        if (possItem.isEmpty()) {
            auditDao.appendRecord("Transaction failed - no such item");
            throw new NoItemInventoryException(
                "The vending machine does not have this item"
            );
        }
        
        VendingMachineItem item = possItem.get();
        
        if (fundsAvailable.compareTo(item.getCost()) < 0) {
            auditDao.appendRecord("Transaction failed - not enough funds for item");
            throw new InsufficientFundsException(
                "Not enough funds have been provided to purchase this item "
                + "(Item cost: $" + item.getCost().toString() 
                + ", Funds available: $" + fundsAvailable.toString() + ")"
            );
        }
        
        if (dao.removeOneOfItem(item.getName()).isEmpty()) {
            auditDao.appendRecord("Transaction failed - no such item");
            throw new NoItemInventoryException(
                "The vending machine has run out of this item"
            );
        }
        fundsAvailable = fundsAvailable.subtract(item.getCost());
        auditDao.appendRecord("Transaction successful");
    }
    
    public void close() {
        auditDao.close();
    }
}
