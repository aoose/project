/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewclient;

import controllers.MainWindowController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * 
 */
public class RMINewClient {


    public static void main(String[] args) throws RemoteException {

        // We create an object from the GUI window
        MainWindow gui = new MainWindow();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true); // This shows the gui
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(3000);
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        MainWindowController gui_controller = new MainWindowController(gui, r);
        
    }
    
}
