package com.bm.vendingmachine.dao;

import com.bm.vendingmachine.dao.exceptions.FailedLoadOfVendingItemsException;
import com.bm.vendingmachine.dao.exceptions.FailedSaveOfVendingItemsException;
import com.bm.vendingmachine.dto.VendingMachineItem;
import java.util.List;
import java.util.Optional;

/**
 * The Dao interface that all Daos in this application must implement
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public interface VendingMachineDao {
    public void loadItems() throws FailedLoadOfVendingItemsException;
    public List<VendingMachineItem> getAllItems();
    public Optional<VendingMachineItem> getItemByName(String name);
    public Optional<VendingMachineItem> removeOneOfItem(String name);
    public void saveItems() throws FailedSaveOfVendingItemsException;
}
