/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.mock;

import DAO.AlunoDAO;
import DAO.AulaPraticaDAO;
import DAO.AulaTeoricaDAO;
import DAO.PagamentoDAO;
import DAO.PessoaDAO;
import DAO.ProfessorDAO;
import Models.Aluno;
import Models.AulaPratica;
import Models.AulaTeorica;
import Models.Login;
import static Models.Login_.login;
import Models.Pagamento;
import Models.Pessoa;
import Models.Professor;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;



/**
 *
 * @author Hamilton
 */
public class TestaDaoMockTest {
    List<Aluno> listaAluno;
    List<AulaPratica> listaAulaPratica;
    
   
//    @Before
//    public void inicializarTeste(){
//    
//        listaAluno = new ArrayList<Aluno>();
//        listaAulaPratica = new ArrayList<AulaPratica>();
////        Aluno a1
////        a1 = new Aluno(2,
////                "Marcos Paulo Gamarano",
////                "marcos_gamarano@gmail.com",
////                "Rua Badi Geara",
////                "Ipiranga",
////                "897",
////                "casa",
////                "Ipiranga", 
////                false,
////                 Date (1999-01-13),
////                "123456789");
////        listaAluno.add(a1);
//        
//        
////        aulaPratica = new AulaPratica(1,"Lesgislação");
////        listaAulaPratica.add(AulaPratica);
//        
//    }
    
    @Test
    public void testBuscarAluno() {
        
        AlunoDAO instance = Mockito.mock(AlunoDAO.class);
        
        List<Aluno> lista = new ArrayList<>();
        //lista.add(new Aluno());
       
        
        Mockito.when(instance.getAll()).thenReturn(lista);
        
        int expResult = 3;
        List<Aluno> result = instance.getAll();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarMatriculaAluno() {
        
        AlunoDAO instance = Mockito.mock(AlunoDAO.class);
        
        List<Aluno> lista = new ArrayList<>();
        //lista.add(new Aluno());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getAllMatriculados()).thenReturn(lista);
        
        int expResult = 3;
        List<Aluno> result = instance.getAllMatriculados();
        
        assertEquals(expResult, result.size());
    }
    
//        @Test
//    public void testBuscarSeEstaMatriculado() {
//        
//        Login login = new Login();
//        Aluno aluno = new Aluno();
//        
//        AlunoDAO instance = Mockito.mock(AlunoDAO.class);
////        
////        List<Aluno> lista = new ArrayList<>();
////        lista.add(new Aluno());
//        Aluno aluno1 = new Aluno();
//        aluno.getLoginId();
////        lista.add(new Aluno());
//        
//        Mockito.when(instance.BuscarPorLogin(login).thenReturn(aluno));
//        
//        int expResult = 1;
//        List<Aluno> result = instance.getAllMatriculados();
//        
//        assertEquals(expResult, result.size());
//    }
    
    @Test
    public void testBuscarTodaAulaPratica() {
        
        AulaPraticaDAO instance = Mockito.mock(AulaPraticaDAO.class);
        
        List<AulaPratica> lista = new ArrayList<>();
        lista.add(new AulaPratica());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getAll()).thenReturn(lista);
        
        int expResult = 15;
        List<AulaPratica> result = instance.getAll();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarAulaPraticaPorAulo() {
        
        Aluno aluno = new Aluno();
        
        AulaPraticaDAO instance = Mockito.mock(AulaPraticaDAO.class);
        
        List<AulaPratica> lista = new ArrayList<>();
        lista.add(new AulaPratica());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getPorAluno(aluno)).thenReturn(lista);
        
        int expResult = 5;
        List<AulaPratica> result = instance.getPorAluno(aluno);
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarAulaPraticaProfessor() {
        
       
        Professor professor = new Professor();
        
        AulaPraticaDAO instance = Mockito.mock(AulaPraticaDAO.class);
        
        List<AulaPratica> lista = new ArrayList<>();
        lista.add(new AulaPratica());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getPorProfessor(professor)).thenReturn(lista);
        
        int expResult = 15;
        List<AulaPratica> result = instance.getPorProfessor(professor);
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarAulaPraticaSemAluno() {
        
        Aluno aluno = new Aluno();
    
        
        AulaPraticaDAO instance = Mockito.mock(AulaPraticaDAO.class);
        
        List<AulaPratica> lista = new ArrayList<>();
        lista.add(new AulaPratica());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getSemAluno()).thenReturn(lista);
        
        int expResult = 10;
        List<AulaPratica> result = instance.getSemAluno();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarTodasAulaTeorica() {
        
        Aluno aluno = new Aluno();
    
        
        AulaTeoricaDAO instance = Mockito.mock(AulaTeoricaDAO.class);
        
        List<AulaTeorica> lista = new ArrayList<>();
        lista.add(new AulaTeorica());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getAll()).thenReturn(lista);
        
        int expResult = 10;
        List<AulaTeorica> result = instance.getAll();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarAulaTeoricaPorProfessor() {
        
        Professor professor = new Professor();
    
        
        AulaTeoricaDAO instance = Mockito.mock(AulaTeoricaDAO.class);
        
        List<AulaTeorica> lista = new ArrayList<>();
        lista.add(new AulaTeorica());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getPorProfessor(professor)).thenReturn(lista);
        
        int expResult = 2;
        List<AulaTeorica> result = instance.getPorProfessor(professor);
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarTodosPagamentos() {
        
        PagamentoDAO instance = Mockito.mock(PagamentoDAO.class);
        
        List<Pagamento> lista = new ArrayList<>();
        lista.add(new Pagamento());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getAll()).thenReturn(lista);
        
        int expResult = 2;
        List<Pagamento> result = instance.getAll();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarPagamentosPorAluno() {
        
        Aluno aluno = new Aluno();
        
        Pagamento pagamento = new Pagamento();
        
        PagamentoDAO instance = Mockito.mock(PagamentoDAO.class);
//        
//        List<Pagamento> lista = new ArrayList<>();
//        lista.add(new Pagamento());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getPorAluno(aluno)).thenReturn(pagamento);
        
        int expResult = 1;
        List<Pagamento> result = instance.getAll();
        
        assertEquals(expResult, result.size());
    }
    
    @Test
    public void testBuscarPessoaPorLogin() {
        
        Login login = new Login();
        Pessoa pessoa = new Pessoa();
        
        PessoaDAO instance = Mockito.mock(PessoaDAO.class);

        Mockito.when(instance.BuscarPorLogin(login)).thenReturn(pessoa);
        
        int expResult = 1;
        Pessoa result = instance.BuscarPorLogin(login);
        
        assertEquals(expResult, result);
    }
    
     @Test
    public void testBuscarProfessorPorLogin() {
        
        Login login = new Login();
        Professor professor = new Professor();
        
         ProfessorDAO instance = Mockito.mock(ProfessorDAO.class);

        Mockito.when(instance.BuscarPorLogin(login)).thenReturn(professor);
        
        int expResult = 1;
        Professor result = instance.BuscarPorLogin(login);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscarTodosProfessores() {
        
        ProfessorDAO instance = Mockito.mock(ProfessorDAO.class);
        
        List<Professor> lista = new ArrayList<>();
        lista.add(new Professor());
//        lista.add(new Aluno());
        
        Mockito.when(instance.getAll()).thenReturn(lista);
        
        int expResult = 4;
        List<Professor> result = instance.getAll();
        
        assertEquals(expResult, result.size());
    }

    
}
