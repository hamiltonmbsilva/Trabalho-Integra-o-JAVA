/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.DbUnitHelper;
import Models.Aluno;
import Models.Login;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoDAOTest {
    
    static DbUnitHelper dbUnit;
    
    public AlunoDAOTest() {
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
        Aluno aluno = null;
        AlunoDAO instance = new AlunoDAO();
        instance.save(aluno);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarPorLoginNull() {
        System.out.println("BuscarPorLogin");
        Login idLogin = null;
        AlunoDAO instance = new AlunoDAO();
        Aluno expResult = null;
        Aluno result = instance.BuscarPorLogin(idLogin);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testBuscarPorLogin_LoginSenha() {
        System.out.println("BuscarPorLogin");
        
        Login login = new Login(19, "marcosgamarano", "123456");
        
        AlunoDAO instance = new AlunoDAO();
        
        Aluno expResult = new Aluno();
        expResult.setMatricula(4);
        expResult.setNome("Marcos Paulo Gamarano");
        expResult.setEmail("marcos_gamarano@gmail.com");
        expResult.setLogradouro("Rua Badi Geara");
        expResult.setBairro("Ipiranga");
        expResult.setNumero("897");
        expResult.setComplemento("casa");
        expResult.setCidade("Ipiranga");
        expResult.setEstado("MG");
        expResult.setMatriculado(false);
        expResult.setDataNascimento(new Date(1999-01-13));
        expResult.setLoginId(login);
        expResult.setCpf("123456789");
        
        Aluno result = instance.BuscarPorLogin(login);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testEdit() {
        System.out.println("edit");
        Aluno aluno = null;
        AlunoDAO instance = new AlunoDAO();
        instance.edit(aluno);
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AlunoDAO instance = new AlunoDAO();
        List<Aluno> expResult = null;
        List<Aluno> result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetByID() {
        System.out.println("getByID");
        String id = "";
        AlunoDAO instance = new AlunoDAO();
        Aluno expResult = null;
        Aluno result = instance.getByID(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllMatriculados() {
        System.out.println("getAllMatriculados");
        AlunoDAO instance = new AlunoDAO();
        List<Aluno> expResult = null;
        List<Aluno> result = instance.getAllMatriculados();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
