package DAO;

import Models.Login;
import Models.Professor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorDAOTest {
    
    public ProfessorDAOTest() {
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
        Professor professor = null;
        ProfessorDAO instance = new ProfessorDAO();
        instance.save(professor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarPorLogin() {
        System.out.println("BuscarPorLogin");
        Login idLogin = null;
        ProfessorDAO instance = new ProfessorDAO();
        Professor expResult = null;
        Professor result = instance.BuscarPorLogin(idLogin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProfessorDAO instance = new ProfessorDAO();
        List<Professor> expResult = null;
        List<Professor> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
