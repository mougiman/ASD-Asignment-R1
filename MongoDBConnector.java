
package asd.demo.model.dao;
import org.bson.Document;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

public class MongoDBConnector {
    MongoDatabase shopDB = getMongoDB();
    MongoCollection<Document> dbItems = shopDB.getCollection("Item");

    MongoCollection<Document> users = shopDB.getCollection("Users");

    public MongoDatabase getMongoDB(){
        MongoClientURI uri = new MongoClientURI("mongodb://weize:Holyshit1.@asd-assignment-shard-00-00-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-01-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-02-5im26.gcp.mongodb.net:27017/test?ssl=true&replicaSet=ASD-Assignment-shard-0&authSource=admin&retryWrites=true&w=majority&connect   TimeoutMS=36000000");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase("ASD");
        return db;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
    
    public ItemList getItemList(){
        ItemList items = new ItemList();
        for (Document doc : dbItems.find()) {
            Item item = new Item((String) doc.get("id"), (String) doc.get("name"), 
                        (String) doc.get("dateListed"), (int) doc.get("stock"), 
                        (double) doc.get("price"), (String) doc.get("desc"), 
                        (String) doc.get("category"), (String) doc.get("sellerID"), 
                        (String) doc.get("expdate"),(boolean)doc.get("ifAuc"), (String) doc.get("image"));
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
                        (String) doc.get("expdate"),(boolean)doc.get("ifAuc"), (String) doc.get("image"));
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
                        (String) doc.get("expdate"),(boolean)doc.get("ifAuc"), (String) doc.get("image"));
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
                        (String) doc.get("sellerID"), (String) doc.get("expdate"), (boolean)doc.get("ifAuc"),(String) doc.get("image")));
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
     public boolean comparePrice(String itemId, double price)
     {
         Bson filter = Filters.eq("id", itemId);
         FindIterable<Document> findIterable = dbItems.find(filter);  
         MongoCursor<Document> mongoCursor = findIterable.iterator(); 
      

    
           
         Document studentDocument = mongoCursor.next();
         double oriPrice = studentDocument.getDouble("price");
          
         
    
            if(oriPrice < price)
            {
                return true;
            
            }
            else {
              return false;
            }
            
    
         
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
}


