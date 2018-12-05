/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.DbUnitHelper;
import java.util.List;
import model.DAO.PessoaDAO;
import model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yuri
 */
public class PessoaDAOTest {
    
    static DbUnitHelper dbUnit;
    
    @BeforeClass
    public static void setUpClass() {
        //dbUnit = new DbUnitHelper();
        
        //dbUnit.backupDataBase();
        
        //dbUnit.importar("BancoTeste.xml");
    }
    
    @AfterClass
    public static void tearDownClass() { 
        //dbUnit.RestoreDataBase();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBuscarTodos() {
        
        PessoaDAO instance = new PessoaDAO();        
        int expResult = 4;
        List<Pessoa> result = instance.All();
        assertEquals(expResult, result.size());
    }  
}
