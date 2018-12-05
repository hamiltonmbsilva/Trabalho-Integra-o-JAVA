/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Aula;
import model.DAO.AulaDAO;
import model.DAO.PessoaDAO;
import model.DAO.VeiculoDAO;
import model.Pessoa;
import model.TipoAula;
import model.TipoPessoa;
import model.TipoVeiculo;
import model.Veiculo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Hamilton
 */
public class TestDaoMosck {
    List<Pessoa> listaPessoa;
    List<Veiculo> listaVeiculos;
    List<Aula> listaAula;
    
    @Before
    public void inicializarTeste(){    
        listaPessoa = new ArrayList<Pessoa>();
        listaVeiculos = new ArrayList<Veiculo>();
        listaAula = new ArrayList<Aula>();
        
        //Banco de Pessoa
        Pessoa p1;
        p1 = new Pessoa(1,
                "Marcos Paulo Gamarano",
                new Date(2018-05-05),
                "123456789",
                true,
                true,
                new TipoPessoa(1,"Administrador"));
        listaPessoa.add(p1);
        
         Pessoa p2;
        p2 = new Pessoa(2,
                "Marcos Paulo Gamarano",
                new Date(2018-05-05),
                "123456789",
                true,
                true,
                new TipoPessoa(2,"Funcionário"));
        listaPessoa.add(p2); 
        
         Pessoa p3;
        p3 = new Pessoa(3,
                "Marcos Paulo Gamarano",
                new Date(2018-05-05),
                "123456789",
                true,
                true,
                new TipoPessoa(4,"Professor"));
        listaPessoa.add(p3); 
        
        //Banco de Veiculos
        
        Veiculo v1;
        v1 = new Veiculo(2018,             
                "PDF 1234",
                new TipoVeiculo(1,"Moto")               
        );
        listaVeiculos.add(v1);
        
        Veiculo v2;
        v2 = new Veiculo(2017,             
                "PDF 1234",
                new TipoVeiculo(2,"Carro")             
        );
        listaVeiculos.add(v2);
        
        //Banco Aula
        
        Aula a1;
        a1 = new Aula(
                new Date(2018-05-05),
                "10:00",
                new TipoAula(1,"Pratica",100),
                new Veiculo(2)
        );
        listaAula.add(a1);
        
        Aula a2;
        a2 = new Aula(
                new Date(2018-05-05),
                "12:00",
                new TipoAula(2,"Teorica",150),
                new Veiculo(1)
        );
        listaAula.add(a2);
        
    }
    
    @Test
    public void testBuscarTodasPessoas() {
        
        PessoaDAO instance = Mockito.mock(PessoaDAO.class);
        
        
      
        Mockito.when(instance.All()).thenReturn(listaPessoa);
        
        int expResult = 3;
        List<Pessoa> result = instance.All();
        
        assertEquals(expResult, result.size());
    }
    
   @Test
    public void testBuscarTodasVeiculos() {
        
        VeiculoDAO instance = Mockito.mock(VeiculoDAO.class);
        Mockito.when(instance.All()).thenReturn(listaVeiculos);
        
        int expResult = 2;
        List<Veiculo> result = instance.All();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarTodasAulas() {
        
        AulaDAO instance = Mockito.mock(AulaDAO.class);
        Mockito.when(instance.All()).thenReturn(listaAula);
        
        int expResult = 2;
        List<Aula> result = instance.All();
        
        assertEquals(expResult, result.size());
    }
    
}
