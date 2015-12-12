import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;

/**
 * Created by Adam on 11.12.2015.
 */

public class MongoDBJDBC {

    public static void main( String args[] ) {

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "test" );
//            System.out.println("Connect to database successfully");
//            boolean auth = db.authenticate(myUserName, myPassword);
//            System.out.println("Authentication: "+auth);

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}