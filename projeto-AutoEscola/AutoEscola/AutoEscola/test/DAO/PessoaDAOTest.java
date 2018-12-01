package DAO;

import Models.Login;
import Models.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaDAOTest {
    
    public PessoaDAOTest() {
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
        Pessoa pessoa = null;
        PessoaDAO instance = new PessoaDAO();
        instance.save(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarPorLogin() {
        System.out.println("BuscarPorLogin");
        Login idLogin = null;
        PessoaDAO instance = new PessoaDAO();
        Pessoa expResult = null;
        Pessoa result = instance.BuscarPorLogin(idLogin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
