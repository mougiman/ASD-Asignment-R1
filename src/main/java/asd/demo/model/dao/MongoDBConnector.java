package asd.demo.model.dao;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import asd.demo.model.User;
import asd.demo.model.Users;
import org.bson.Document;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class MongoDBConnector {
    MongoDatabase shopDB = getMongoDB();
    MongoCollection<Document> dbItems = shopDB.getCollection("Item");
    MongoCollection<Document> users = shopDB.getCollection("Users");

    public MongoDatabase getMongoDB(){
        if(shopDB == null){
            MongoClientURI uri = new MongoClientURI("mongodb://weize:Holyshit1.@asd-assignment-shard-00-00-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-01-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-02-5im26.gcp.mongodb.net:27017/test?ssl=true&replicaSet=ASD-Assignment-shard-0&authSource=admin&retryWrites=true&w=majority&maxIdleTimeMS=30000");
            MongoClient client = new MongoClient(uri);
            MongoDatabase db = client.getDatabase("ASD");
            return db;
        }
        return shopDB;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
	     public void changePrice(String itemId,double price)
     {
          Bson filter = Filters.eq("id", itemId);
   
    Document document = new Document("$set", new Document("price", price));
   
    dbItems.updateOne(filter, document);

     
       
}
     public void addAucItem(String id, String name, String datelisted, int quantity,  Double price, String desc, String category, String sellerId,String expdate,String CusID,boolean ifAuc)
     {
   

     
   
 Document document = new Document("id", id).
                   append("name", name).
                    append("datelisted", datelisted).
                    append("stock", quantity).
                    
                   append("price", price).
                    append("desc", desc).
                    append("category", category).
                    append("sellerId", sellerId).
                    append("expdate", expdate).
                    append("CusID", CusID).
                    append("ifAuc", true).
                    append("image", "https://m.media-amazon.com/images/I/716Tk-ycvAL._UY560_.jpg");
   
 
         dbItems.insertOne(document); 
     }
    
    public ItemList getItemList(){
        ItemList items = new ItemList();
        for (Document doc : dbItems.find()) {
            Item item = new Item((String) doc.get("id"), (String) doc.get("name"), 
                        (String) doc.get("dateListed"), (int) doc.get("stock"), 
                        (double) doc.get("price"), (String) doc.get("desc"), 
                        (String) doc.get("category"), (String) doc.get("sellerID"), 
                        (String) doc.get("expdate"), (String) doc.get("image"));
               items.addItem(item);
        }   
        return items;
    }
    
    public ItemList searchItemList(String query) {
        ItemList searchList = new ItemList();
        for (Document doc : dbItems.find()) {
            String name = (String)(doc.get("name"));
            if(name.contains(query)){
               
                Item item = new Item((String) doc.get("id"), (String) doc.get("name"), 
                        (String) doc.get("dateListed"), (int) doc.get("stock"), 
                        (double) doc.get("price"), (String) doc.get("desc"), 
                        (String) doc.get("category"), (String) doc.get("sellerID"), 
                        (String) doc.get("expdate"), (String) doc.get("image"));
                searchList.addItem(item);
            }
        }  
        return searchList;
    }
    
    public ItemList searchCategory(String query) {
        ItemList searchList = new ItemList();
        for (Document doc : dbItems.find()) {
            String name = (String)(doc.get("category"));
            if(name.contains(query)){
                Item item = new Item((String) doc.get("id"), (String) doc.get("name"), 
                        (String) doc.get("dateListed"), (int) doc.get("stock"), (double) doc.get("price"), 
                        (String) doc.get("desc"), (String) doc.get("category"), (String) doc.get("sellerID"), 
                        (String) doc.get("expdate"), (String) doc.get("image"));
                searchList.addItem(item);
            }
        }
        return searchList;
    }
    
    public Item getItem(String ID){
        for (Document doc : dbItems.find()) {
            String id = (String)(doc.get("id"));
            System.out.print(id + "------" + ID);
            if(id.equals(ID)){
                return (new Item((String) doc.get("id"), (String) doc.get("name"), (String) doc.get("dateListed"), 
                        (int) doc.get("stock"), (double) doc.get("price"), 
                        (String) doc.get("desc"), (String) doc.get("category"),
                        (String) doc.get("sellerID"), (String) doc.get("expdate"), (String) doc.get("image")));
            }
        }
        return null;
    }
    
     public User getUser(String ID){
        for (Document doc : users.find()) {
                String id = (String)(doc.get("id"));
            System.out.print(id + "------" + ID);
            if(ID.equals(ID)){
                return (new User((String) doc.get("id"), (String) doc.get("name"), (String) doc.get("email"),(String) doc.get("password"), (String) doc.get("phone"),(boolean) doc.get("isAdmin")));
            }
        }
        return null;
    }
    
    public Users getUserList(){
        Users userList = new Users();
        for (Document doc : users.find()){
            
        }
        return userList;
    }
    public void add(User user) {
		 MongoDatabase shopDB = getMongoDB();
		List<Document> users = new ArrayList<>();
		users.add(new Document("Username", user.getEmail())
			.append("Password", user.getPassword())
			.append("Name", user.getName())
			.append("Phone", user.getPhone())
                        .append("IsAdmin", user.getIsAdmin()));
		MongoCollection<Document> userlist = shopDB.getCollection("Users"); 
		userlist.insertMany(users);
	}

	public void showUsers() {
		 MongoDatabase shopDB = getMongoDB();
		MongoCollection<Document> userlist = shopDB.getCollection("Users");
		try (MongoCursor<Document> cursor = userlist.find().iterator()) {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		}
	}
	
	public void addUser(String id, String name, String email, String password, String phone){
         
		Document document = new Document("id", id).
                    append("name", name).
                    append("email", email).
                    append("password", password).
                    append("phone", phone);
 
         users.insertOne(document); 
     }

	/**
	 
	 * @return
	 */
	public Users loadUsers() {
		 MongoDatabase shopDB = getMongoDB();
		Users users = new Users();
	  
			MongoCollection<Document> userlist = shopDB
					.getCollection("Users");
			for (Document doc : userlist.find()) {
				User user = new User((String)doc.get("Id"),
                                        (String) doc.get("Name"),
						(String) doc.get("Username"),
						(String) doc.get("Password"), (String) doc.get("Phone"),(Boolean) doc.get("isAdmin"));
				users.addUser(user);
			}
		return users;
	}

	/**
	 
	 * @param email
	 * @param password
	 * @return
	 */
	public User userExists(String email, String password) {
		 MongoDatabase shopDB = getMongoDB();
			MongoCollection<Document> userlist = shopDB.getCollection("Users");
			Document doc = userlist.find(and(eq("email", email), eq("password", password))).first();
                        if(doc ==null){
                            return null;
                        }
			User user = new User((String)doc.get("id"),(String) doc.get("name"), (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phone"),(Boolean) doc.get("isAdmin"));
		return user;
	}
}


