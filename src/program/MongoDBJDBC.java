package program;

/**
 * Created by Adam on 11.12.2015.
 */

public class MongoDBJDBC {

    public static void main( String args[] ) {
        Crud crud = new Crud();
        crud.createTask("Napisanie projektu na testowanie testowania", "15.12.2015", "17.12.2015");
//        System.out.println(crud.readTaskDesc());
//        crud.deleteTask();
//        crud.deleteTask();
//        crud.deleteTask();
//        crud.updateTaskName("Przed updateem", "after update");
        crud.readTaskDesc();
    }
}