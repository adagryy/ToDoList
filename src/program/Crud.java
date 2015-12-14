package program;

import com.mongodb.*;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;


/**
 * Created by Adam on 13.12.2015.
 */
public class Crud {

    private DBCollection connectToDb() {

        // To connect to mongodb server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Now connect to your databases
        DB db = mongoClient.getDB("todolist");
        System.out.println("Connect to database successfully");

        DBCollection coll = db.getCollection("mycol");
        System.out.println("Collection mycol selected successfully");
        return coll;
    }

    public DBObject insertDocument(String desc,  String start, String end ){
        BasicDBObject doc = null;
        try{
            DBCollection coll = connectToDb();

            doc = new BasicDBObject("title", "MongoDB").
                    append("Opis", desc).
                    append("Początek", start).
                    append("KOniec", end).
                    append("by", "Adam");

            coll.insert(doc);
            System.out.println("Document inserted successfully");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return doc;
    }

    public String read(){
        // To connect to mongodb server
        DBCollection coll = connectToDb();

        DBCursor cursor = coll.find();
        int i = 1;
        String text = null;
        while (cursor.hasNext()) {
//            System.out.println("Inserted Document: "+i);
//            System.out.println(cursor.next());
            DBObject o = cursor.next();
            text = (String) o.get("Opis");
            i++;
        }
        return text;
    }

    public DBObject deleteDocument(){
        DBObject myDoc = null;
        try{
            // To connect to mongodb server
            DBCollection coll = connectToDb();

            myDoc = coll.findOne();
            coll.remove(myDoc);
            System.out.println(myDoc.get("Opis"));
            DBCursor cursor = coll.find();
            int i = 1;

            while (cursor.hasNext()) {
//                System.out.println("Inserted Document: "+i);
                System.out.println(cursor.next());
                i++;
            }

            System.out.println("Document deleted successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return myDoc;
    }

    public BasicDBObject updateDocument( String oldName, String newName) {
        DBCollection coll = connectToDb();

        BasicDBObject query = new BasicDBObject();
        query.put("Opis", oldName);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("Opis", newName);

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        coll.update(query, updateObj);

        return updateObj;
    }

}
