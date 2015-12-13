//import com.mongodb.MongoClient;
//import com.mongodb.MongoException;
//import com.mongodb.WriteConcern;
//
//
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBObject;
//import com.mongodb.DBCursor;
//
//import com.mongodb.ServerAddress;
//import java.util.Arrays;

/**
 * Created by Adam on 11.12.2015.
 */

public class MongoDBJDBC {

    public static void main( String args[] ) {
        Crud crud = new Crud();
        crud.insertDocument("Napisanie projektu na testowanie", "15.12.2015", "17.12.2015");
        crud.read();
    }
}