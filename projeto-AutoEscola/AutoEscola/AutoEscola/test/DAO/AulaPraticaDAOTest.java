package DAO;

import Models.Aluno;
import Models.AulaPratica;
import Models.Professor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AulaPraticaDAOTest {
    
    public AulaPraticaDAOTest() {
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
        AulaPratica teorica = null;
        AulaPraticaDAO instance = new AulaPraticaDAO();
        instance.save(teorica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AulaPraticaDAO instance = new AulaPraticaDAO();
        List<AulaPratica> expResult = null;
        List<AulaPratica> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        AulaPraticaDAO instance = new AulaPraticaDAO();
        AulaPratica expResult = null;
        AulaPratica result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        AulaPratica aula = null;
        AulaPraticaDAO instance = new AulaPraticaDAO();
        instance.edit(aula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPorAluno() {
        System.out.println("getPorAluno");
        Aluno aluno = null;
        AulaPraticaDAO instance = new AulaPraticaDAO();
        List<AulaPratica> expResult = null;
        List<AulaPratica> result = instance.getPorAluno(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSemAluno() {
        System.out.println("getSemAluno");
        AulaPraticaDAO instance = new AulaPraticaDAO();
        List<AulaPratica> expResult = null;
        List<AulaPratica> result = instance.getSemAluno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPorProfessor() {
        System.out.println("getPorProfessor");
        Professor professor = null;
        AulaPraticaDAO instance = new AulaPraticaDAO();
        List<AulaPratica> expResult = null;
        List<AulaPratica> result = instance.getPorProfessor(professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
