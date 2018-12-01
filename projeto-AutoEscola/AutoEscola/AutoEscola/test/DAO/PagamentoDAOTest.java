package DAO;

import Models.Aluno;
import Models.Pagamento;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PagamentoDAOTest {
    
    public PagamentoDAOTest() {
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
        Pagamento pagamento = null;
        PagamentoDAO instance = new PagamentoDAO();
        instance.save(pagamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Pagamento pagamento = null;
        PagamentoDAO instance = new PagamentoDAO();
        instance.edit(pagamento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        PagamentoDAO instance = new PagamentoDAO();
        List<Pagamento> expResult = null;
        List<Pagamento> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetByID() {
        System.out.println("getByID");
        String id = "";
        PagamentoDAO instance = new PagamentoDAO();
        Pagamento expResult = null;
        Pagamento result = instance.getByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPorAluno() {
        System.out.println("getPorAluno");
        Aluno aluno = null;
        PagamentoDAO instance = new PagamentoDAO();
        Pagamento expResult = null;
        Pagamento result = instance.getPorAluno(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
