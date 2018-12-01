package DAO;

import Models.AulaTeorica;
import Models.Professor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AulaTeoricaDAOTest {
    
    public AulaTeoricaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        System.out.println("save");
        AulaTeorica teorica = null;
        AulaTeoricaDAO instance = new AulaTeoricaDAO();
        instance.save(teorica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AulaTeoricaDAO instance = new AulaTeoricaDAO();
        List<AulaTeorica> expResult = null;
        List<AulaTeorica> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        AulaTeoricaDAO instance = new AulaTeoricaDAO();
        AulaTeorica expResult = null;
        AulaTeorica result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        AulaTeorica aula = null;
        AulaTeoricaDAO instance = new AulaTeoricaDAO();
        instance.edit(aula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPorProfessor() {
        System.out.println("getPorProfessor");
        Professor professor = null;
        AulaTeoricaDAO instance = new AulaTeoricaDAO();
        List<AulaTeorica> expResult = null;
        List<AulaTeorica> result = instance.getPorProfessor(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
