package rminewserver;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class DB {
    public static MongoClient mongoClient;
    public static MongoDatabase database;
    MongoCollection<Document> collection1;
    MongoCollection<Document> collection2;
    public static Gson gson = new Gson();

    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initializeuri
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        // Database name
        database = mongoClient.getDatabase("DoctorReservationSystem");
        // Collection for the doctor
        collection1 = database.getCollection("Doctor");
        collection2 = database.getCollection("Person");
    }

    public void insertPerson(Person person) {
        collection2.insertOne(Document.parse(gson.toJson(person)));
        System.out.println("Person is inserted with ID: " + person.getId() + " and persontypeid: "+person.getPersonTypeID());
    }

    public void insertDoctor(Doctor doctor) {
        // Query to find the last inserted doctor
        Document lastDoctor = collection2.find().sort(new Document("id", -1)).limit(1).first();

        int lastDoctorId = (lastDoctor != null) ? lastDoctor.getInteger("id", 0) : 0;
        int newDoctorId = lastDoctorId + 1;

        // Set the new ID for the doctor
        doctor.setId(newDoctorId);
        doctor.setPersonTypeID(2);

        // Insert the new doctor
        collection1.insertOne(Document.parse(gson.toJson(doctor)));

        // Create a corresponding Person and insert it
        Person person = new Person(doctor.getName(), doctor.getPhoneNo(), doctor.getEmail(), doctor.getAge(), doctor.getPassword());
        person.setId(newDoctorId);
        person.setPersonTypeID(2);
        insertPerson(person);

        System.out.println("Doctor and corresponding Person are inserted with ID: " + newDoctorId + " and persontypeid: 2");
    }

    public void updateDoctor(String name, String newSpecialization) {
        // Update the document where the name is equal to the specified name
        // Set the new specialization value
        UpdateResult result = collection1.updateOne(
            Filters.eq("name", name),
            new Document("$set", new Document("specialization", newSpecialization)),
            new UpdateOptions().upsert(false)
        );

        System.out.println("Matched " + result.getMatchedCount() + " document(s) and modified " + result.getModifiedCount() + " document(s).");
    }

    public void close() {
        mongoClient.close();
    }
}