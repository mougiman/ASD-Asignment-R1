/*
 * Author: Georges Bou Ghantous
 *
 * This class provides the methods to establish connection between ASD-Demo-app
 * and MongoDBLab cloud Database. The data is saved dynamically on mLab cloud database as
 * as JSON format.
 */
package asd.demo.model.dao;

import java.net.UnknownHostException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.*;
import asd.demo.model.*;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class MongoDBConnector {

    //private List<Document> users = new ArrayList();
    String uri = "mongodb://weize:Holyshit1.@asd-assignment-shard-00-00-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-01-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-02-5im26.gcp.mongodb.net:27017/test?ssl=true&replicaSet=ASD-Assignment-shard-0&authSource=admin&retryWrites=true&w=majority";
    MongoClientURI clientURI = new MongoClientURI(uri);
    MongoClient mongoClient = new MongoClient(clientURI);
    // private String owner;
    // private String password;

    /*  public MongoDatabase getMongoDB(){
       MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + "@ds029496.mlab.com:29496/heroku_59pxdn6j");
       MongoDatabase db;
       try (MongoClient client = new MongoClient(uri)) {
            db = client.getDatabase(uri.getDatabase());
       }
       return db;
    }
    
    public MongoDBConnector(String owner, String password) throws UnknownHostException {
        this.owner = owner;
        this.password = password;
    }

    public void showall(Users users) {
        for (User u : users.getList()) {
            System.out.println(u.getName());
        }
    }

    

    public void showUsers() {
        MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + "@ds029496.mlab.com:29496/heroku_59pxdn6j");
        try (MongoClient client = new MongoClient(uri)) {
            MongoDatabase db = client.getDatabase(uri.getDatabase());
            MongoCollection<Document> userlist = db.getCollection("ASD-Demo-app-users");
            try (MongoCursor<Document> cursor = userlist.find().iterator()) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            }
        }
    }

    public Users loadUsers() {
        MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + "@ds029496.mlab.com:29496/heroku_59pxdn6j");
        Users users;
        try (MongoClient client = new MongoClient(uri)) {
            MongoDatabase db = client.getDatabase(uri.getDatabase());
            users = new Users();
            MongoCollection<Document> userlist = db.getCollection("ASD-Demo-app-users");
            for (Document doc : userlist.find()) {
                User user = new User((String) doc.get("Name"), (String) doc.get("Username"), (String) doc.get("Password"), (String) doc.get("Phone"));
                users.addUser(user);
            }
        }
        return users;
    }

    public User user(String email, String password) {
        MongoClientURI uri = new MongoClientURI("mongodb://" + this.owner + ":" + this.password + "@ds029496.mlab.com:29496/heroku_59pxdn6j");
        User user;
        try (MongoClient client = new MongoClient(uri)) {
            MongoDatabase db = client.getDatabase(uri.getDatabase());
            MongoCollection<Document> userlist = db.getCollection("ASD-Demo-app-users");
            Document doc = userlist.find(and(eq("Username", email), eq("Password", password))).first();
            user = new User((String) doc.get("Name"), (String) doc.get("Username"), (String) doc.get("Password"), (String) doc.get("Phone"));
        }
        return user;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
    
    public void add(User user) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://weize:Holyshit1.@asd-assignment-5im26.gcp.mongodb.net/test?retryWrites=true&w=majority");
        try (MongoClient client = new MongoClient(uri)) {
            MongoDatabase db = client.getDatabase(uri.getDatabase());
            users.add(new Document("Username", user.getEmail()).append("Password", user.getPassword()).append("Name", user.getName()).append("Phone", user.getPhone()));
            MongoCollection<Document> userlist = db.getCollection("ASD-Demo-app-users"); //Create a collection ASD-Demo-app-users on mLab
            userlist.insertMany(users);
        }
    }
     */
    public void addAucItem(String id, String name, String datelisted, int quantity, Double price, String desc, String category, String sellerId, String expdate, String CusID) {

        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Product");
        Document document = new Document("id", id).
                append("name", name).
                append("datelisted", datelisted).
                append("quantity", quantity).
                append("price", price).
                append("desc", desc).
                append("category", category).
                append("sellerId", sellerId).
                append("expdate", expdate).
                append("CusID", CusID);

        collection.insertOne(document);
    }

    public void addItem(String id, String name, String datelisted, int quantity, Double price, String desc, String category, String sellerId, String CusID) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Product");
        Document document = new Document("id", id).
                append("name", name).
                append("datelisted", datelisted).
                append("quantity", quantity).
                append("price", price).
                append("desc", desc).
                append("category", category).
                append("sellerId", sellerId).
                append("CusID", CusID);
        collection.insertOne(document);
    }

    public ArrayList<Item> getItemList() {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Product");
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        ArrayList<Item> items = new ArrayList<Item>();
        for (Document document : documents) {
            Item item = new Item("" + document.get("id"), "" + document.get("name"), "" + document.get("datelisted"), Integer.parseInt("" + document.get("quantity")), Double.parseDouble("" + document.get("price")), "" + document.get("desc"), "" + document.get("category"), "" + document.get("sellerId"), "" + document.get("expdate"), "" + document.get("CusID"));
            items.add(item);
            //String name = "Name: " + document.get("name");
            //Item item = new Item("test", name, "test", 10, 22, "test", "test", "test", "test", "test");
            //items.add(item);
            //names.add(name);
        }
        //Item item2 = new Item("test", "test", "test", 10, 22, "test", "test", "test", "test", "test");
        //items.add(item2);
        return items;
    }

    public Item getitem(String id) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Product");
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        Item item = new Item();
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals(id)) {
                item = new Item("" + document.get("id"), "" + document.get("name"), "" + document.get("datelisted"), Integer.parseInt("" + document.get("quantity")), Double.parseDouble("" + document.get("price")), "" + document.get("desc"), "" + document.get("category"), "" + document.get("sellerId"), "" + document.get("expdate"), "" + document.get("CusID"));
            }
        }
        return item;
    }
}
