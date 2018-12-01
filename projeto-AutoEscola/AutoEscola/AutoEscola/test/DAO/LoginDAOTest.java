package DAO;

import Models.Login;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginDAOTest {
    
    public LoginDAOTest() {
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
        Login login = null;
        LoginDAO instance = new LoginDAO();
        instance.save(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscaPorLogin() {
        System.out.println("BuscaPorLogin");
        String login = "";
        LoginDAO instance = new LoginDAO();
        Login expResult = null;
        Login result = instance.BuscaPorLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidaLogin() {
        System.out.println("validaLogin");
        String login = "";
        String senha = "";
        LoginDAO instance = new LoginDAO();
        Login expResult = null;
        Login result = instance.validaLogin(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
