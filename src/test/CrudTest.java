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

    }

    @Test
    public void shouldDeleteTask() throws Exception {
        String desc = "Usuwany rekord", start = "11.12.2015", end = "5.12.2015";

        DBObject task = crud.createTask(desc, start, end);

        DBObject deletedTask = crud.deleteTask();

        assertEquals(task.get("Opis"), deletedTask.get("Opis"));
    }

    @Test
    public void shouldUpdateDescription() throws Exception{
        String desc = "Przed updateem", start = "11.12.2015", end = "5.12.2015", afterUpdate = "afterUpdate";

        DBObject dbo = crud.createTask(desc, start, end);

        DBObject someOtherObject = crud.updateTaskName(desc, afterUpdate);

        assertSame(someOtherObject.get("Opis"), afterUpdate);
    }
}