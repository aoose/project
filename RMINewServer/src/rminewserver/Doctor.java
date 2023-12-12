package rminewserver;
import rminewserver.Person;
import java.rmi.RemoteException;

public class Doctor extends Person {
    public String workinghours;
    public String Specialization;
    public int experienceYears;
    
    public Doctor() throws RemoteException{
    }

    public Doctor(String workinghours, String Specialization, int experienceYears, String name, String phoneNo, String Email, String age, String password) {
        super(name, phoneNo, Email, age, password);
        this.workinghours = workinghours;
        this.Specialization = Specialization;
        this.experienceYears = experienceYears;
    }
    
}