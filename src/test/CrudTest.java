package test;

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
        String desc1 = crud.read();

        assertEquals("Przykładowy opis", desc);
    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testDeleteDocument() throws Exception {

    }
}