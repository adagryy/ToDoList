import com.mongodb.*;

/**
 * Created by Adam on 13.12.2015.
 */
public class Crud {

    private DBCollection connectToDb() {

        // To connect to mongodb server
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Now connect to your databases
        DB db = mongoClient.getDB("test");
        System.out.println("Connect to database successfully");

//            boolean auth = db.authenticate(myUserName, myPassword);
//            System.out.println("Authentication: "+auth);
        DBCollection coll = db.getCollection("mycol");
        System.out.println("Collection mycol selected successfully");
        return coll;
    }

    public void insertDocument(String desc,  String start, String end ){
        try{
            DBCollection coll = connectToDb();


            BasicDBObject doc = new BasicDBObject("title", "MongoDB").
                    append("Opis", desc).
                    append("Początek", start).
                    append("KOniec", end).
                    append("by", "Adam");

            coll.insert(doc);
            System.out.println("Document inserted successfully");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void read(){
        // To connect to mongodb server
        DBCollection coll = connectToDb();

        DBCursor cursor = coll.find();
        int i = 1;

        while (cursor.hasNext()) {
            System.out.println("Inserted Document: "+i);
            System.out.println(cursor.next());
            i++;
        }
    }

    public void deleteDocument(){
        try{
            // To connect to mongodb server
            DBCollection coll = connectToDb();

            DBObject myDoc = coll.findOne();
            coll.remove(myDoc);
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
    }

}