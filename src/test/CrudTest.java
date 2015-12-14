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
    public void testInsertDocument() throws Exception {
        String desc = "Przykładowy opis", start = "21.12.2015", end = "25.12.2015";

        crud.insertDocument(desc, start, end);

        assertEquals(crud.read(), desc);
    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testDeleteDocument() throws Exception {
        String desc = "Usuwany rekord", start = "11.12.2015", end = "5.12.2015";

        DBObject dbo = crud.insertDocument(desc, start, end);

        DBObject deletedDBO = crud.deleteDocument();

        assertEquals(dbo.get("Opis"), deletedDBO.get("Opis"));
    }

    @Test
    public void testUpdateDocument() throws Exception{
        String desc = "Przed updateem", start = "11.12.2015", end = "5.12.2015", afterUpdate = "afterUpdate";

        DBObject dbo = crud.insertDocument(desc, start, end);

        DBObject someOtherObject = crud.updateDocument(desc, afterUpdate);

        assertSame(someOtherObject.get("Opis"), afterUpdate);
    }
}