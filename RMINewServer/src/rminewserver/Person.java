package rminewserver;

import com.mongodb.client.MongoClient;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Person {
    private String name;
    private String phoneNo;
    private String Email;
    private String age;
    private String password;
    public int id ;
    private int personTypeID;
    ArrayList<Person> Persons = new ArrayList<Person>();
    
    DB db ; 
    
    public Person() throws RemoteException{
    }
    
    
    public Person(String name, String phoneNo, String Email, String age, String password) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.Email = Email;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonTypeID() {
        return personTypeID;
    }

    public void setPersonTypeID(int personTypeID) {
        this.personTypeID = personTypeID;
    }

    public ArrayList<Person> getPersons() {
        return Persons;
    }

    public void setPersons(ArrayList<Person> Persons) {
        this.Persons = Persons;
    }
}