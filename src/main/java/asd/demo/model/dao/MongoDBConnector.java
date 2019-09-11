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

    String uri = "mongodb://weize:Holyshit1.@asd-assignment-shard-00-00-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-01-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-02-5im26.gcp.mongodb.net:27017/test?ssl=true&replicaSet=ASD-Assignment-shard-0&authSource=admin&retryWrites=true&w=majority";
    MongoClientURI clientURI = new MongoClientURI(uri);
    MongoClient mongoClient = new MongoClient(clientURI);
    
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

    public void addReview(String id, String ItemID, String UserID, String Desc, String Title, String DateListed) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Review");
        Document document = new Document("id", id).
                append("UserID", UserID).
                append("Desc", Desc).
                append("Title", Title).
                append("DateListed", DateListed).
                append("ItemID", ItemID).
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
        }
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
    
    public ArrayList<Review> getItemReviews(String id) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Review");
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        ArrayList<Review> reviews = new ArrayList<Review>();
        for (Document document : documents) {
            String itemId = "" + document.get("itemid");
            if (itemId.equals(id)) {
                Review review = new Review("" + document.get("id"), "" + document.get("itemid"), "" + document.get("userid"), "" + document.get("desc"), "" + document.get("title"), "" + document.get("datelisted"));
                reviews.add(review);
            }
        }
        return reviews;
    }
    
    public ArrayList<Rating> getUserRatings(String id) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ASD");
        MongoCollection collection = mongoDatabase.getCollection("Rating");
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (Document document : documents) {
            String sellerId = "" + document.get("sellerid");
            if (sellerId.equals(id)) {
                Rating rating = new Rating("" + document.get("id"), "" + document.get("itemid"), "" + document.get("userid"), "" + document.get("desc"), "" + document.get("title"), "" + document.get("datelisted"), ""+document.get("score"));
                ratings.add(rating);
            }
        }
        return ratings;
    }
}
