package com.bm.vendingmachine;

import com.bm.vendingmachine.controller.VendingMachineController;
import com.bm.vendingmachine.dao.VendingMachineAuditDaoConsoleImpl;
import com.bm.vendingmachine.dao.VendingMachineDaoConsoleImpl;
import com.bm.vendingmachine.service.VendingMachineService;
import com.bm.vendingmachine.ui.UserIoConsoleImpl;
import com.bm.vendingmachine.ui.VendingMachineView;

/**
 * Serves as the entry point for the whole application
 * 
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 31, 2021
 */
public class App {
    public static void main(String[] args) {
        VendingMachineView view = new VendingMachineView(
            new UserIoConsoleImpl()
        );
    
        VendingMachineService service = new VendingMachineService(
            new VendingMachineDaoConsoleImpl(),
            new VendingMachineAuditDaoConsoleImpl()
        );
        
        VendingMachineController controller = new VendingMachineController(
            view,
            service
        );
        
        controller.run();
    }
}
