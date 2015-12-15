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

    public DBObject createTask(String desc, String start, String end ){
        BasicDBObject task = null;
        try{
            DBCollection collection = connectToDb();

            task = new BasicDBObject("title", "MongoDB").
                    append("Opis", desc).
                    append("Początek", start).
                    append("KOniec", end).
                    append("by", "Adam");

            collection.insert(task);
            System.out.println("Document inserted successfully");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return task;
    }

    public String readTaskDesc(){
        // To connect to mongodb server
        DBCollection collection = connectToDb();

        DBCursor cursor = collection.find();
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

    public int readAllTask(){
        int i = 0;
        try{
        DBCollection coll = connectToDb();

        DBCursor cursor = coll.find();

        while (cursor.hasNext()) {
            System.out.println("Inserted Document: "+i);
            System.out.println(cursor.next());
            i++;
        }

    }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
        return i;
    }

    public DBObject deleteTask(){
        DBObject task = null;
        try{
            // To connect to mongodb server
            DBCollection coll = connectToDb();

            task = coll.findOne();
            coll.remove(task);
            System.out.println(task.get("Opis"));
            DBCursor cursor = coll.find();
            int i = 1;

            while (cursor.hasNext()) {
                System.out.println("Inserted Document: "+i);
                System.out.println(cursor.next());
                i++;
            }

            System.out.println("Document deleted successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return task;
    }

    public BasicDBObject updateTaskName(String oldName, String newName) {
        DBCollection collection = connectToDb();

        BasicDBObject query = new BasicDBObject();
        query.put("Opis", oldName);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("Opis", newName);

        BasicDBObject updateTask = new BasicDBObject();
        updateTask.put("$set", newDocument);

        collection.update(query, updateTask);

        return updateTask;
    }

    public long getCount(){
        DBCollection coll = connectToDb();
        return coll.count();
    }

}
