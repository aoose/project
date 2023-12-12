package rminewserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.GradeInterface;

public class RMINewServer {

    static Doctor d1;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        
                   
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        
        //Calling the class for the database 
        DB db = new DB();
        
        // Here we create our remote object
        //GradeInterface g = new Grade();
        
        // An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(3000);
        
        // Our remote object g is binded to the name "grade"
        //r.bind("grade", g);
        
        // Outputs that the server is ready
        System.out.println("The server is ready");
        
        
        d1 = new Doctor ("8 hrs","bones",10,"adham adel","01212411550","adham123@gmail.com","21","adham123");
        
        db.insertDoctor(d1);
        
        db.close();
        } 


         
    
    
}
