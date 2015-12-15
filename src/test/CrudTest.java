package test;

import com.mongodb.DBObject;
import program.Crud;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adam on 13.12.2015.
 */
public class CrudTest {
    private Crud crud = new Crud();

    @Test
    public void shouldNotAddNewTask() throws Exception {
        DBObject task =  crud.createTask( null, null , null);
        assertNull(task);
    }

    @Test
    public void shouldAddNewTask() throws Exception {
        String desc = "Przykładowy opis", start = "21.12.2015", end = "25.12.2015";
        DBObject task =  crud.createTask(desc, start, end);
        assertNotNull(task);
    }

    @Test
    public void shouldReadAllTask() throws Exception {
        assertEquals(crud.getCount(), crud.readAllTask());
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        long count = crud.getCount();
        crud.deleteTask();
        assertEquals(count - 1, crud.getCount());
    }

    @Test
    public void shouldUpdateDescription() throws Exception{
        String desc = "Przed updateem", start = "11.12.2015", end = "5.12.2015", afterUpdate = "afterUpdate";

        DBObject dbo = crud.createTask(desc, start, end);

        DBObject someOtherObject = crud.updateTaskName(desc, afterUpdate);

        assertNotSame(dbo.get("Opis"), afterUpdate);
    }
}