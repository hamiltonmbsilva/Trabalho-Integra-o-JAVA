/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.TestUnitario;

import model.Contrato;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hamilton
 */
public class TestUnitario {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Contrato con;
    
    @Before
    public void setUp() {
        System.out.println("testando antes");
        con = new Contrato();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSoma() {
        System.out.println("executando teste 1");
        Double parcela = 10.0, valor=1000.0;     
        double resultadoEsperado = 100.0;
        double resultadoObtido = con.ValorPrestacacao(parcela, valor);
        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
        
    }
    
    @Test
    public void testSoma1() {
        System.out.println("executando teste 2");
        
        Double parcela = 0.0, valor=1000.0;     
        double resultadoEsperado = 1000.0;
        double resultadoObtido = con.ValorPrestacacao(parcela, valor);
        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
        
    }
    
    @Test
    public void testSoma2() {
        System.out.println("executando teste 3");
        
         Double parcela = 10.0, valor=-1000.0;     
        double resultadoEsperado = 100.0;
        double resultadoObtido = con.ValorPrestacacao(parcela, valor);
        assertEquals(resultadoEsperado, resultadoObtido, 5.0);
        
    }
}
