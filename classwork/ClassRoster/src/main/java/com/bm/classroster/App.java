/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster;

import com.bm.classroster.controller.ClassRosterController;
import com.bm.classroster.dao.ClassRosterAuditDao;
import com.bm.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.bm.classroster.dao.ClassRosterDao;
import com.bm.classroster.dao.ClassRosterDaoFileImpl;
import com.bm.classroster.service.ClassRosterServiceLayer;
import com.bm.classroster.service.ClassRosterServiceLayerImpl;
import com.bm.classroster.ui.ClassRosterView;
import com.bm.classroster.ui.UserIO;
import com.bm.classroster.ui.UserIOConsoleImpl;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl(new Scanner(System.in));
        ClassRosterView myView = new ClassRosterView(myIo);
        
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(
            myDao, 
            myAuditDao
        );
        
        ClassRosterController controller = new ClassRosterController(
            myService, 
            myView
        );
        controller.run();
    }
}
