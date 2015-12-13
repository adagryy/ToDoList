/**
 * Created by Mateusz on 2015-12-13.
 */

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 */

public class App {

    private static void addObj(DBCollection table, String   valueName, int valueAge){
        BasicDBObject document = new BasicDBObject();
        document.put("name", valueName);
        document.put("age", valueAge);
        document.put("createdDate", new Date());
        table.insert(document);
    }
    private static void findAndDisplay(DBCollection table,String valueName){
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", valueName);

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
    public static void main(String[] args) {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);

            /**** Get database ****/
            // if database doesn't exists, MongoDB will create it for you
            DB db = mongo.getDB("testdb");

            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection("user");

            /**** Insert ****/
           // addObj(table,"Rychu",34);
            //addObj(table,"Marika",54);
           // addObj(table,"Marian",64);
            /**** Find and display ****/


            /**** Update ****/
            // search document where name="mkyong" and update it with new values
            BasicDBObject query = new BasicDBObject();
            query.put("name", "Robcio");

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("name", "Mati-updated");

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            table.update(query, updateObj);

            /**** Find and display ****/
            findAndDisplay(table,"Rychu");
            /**** Done ****/
            System.out.println("Done");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}