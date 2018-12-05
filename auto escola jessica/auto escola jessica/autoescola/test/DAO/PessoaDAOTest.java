/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.DbUnitHelper;
import java.sql.Date;
import java.util.List;
import model.Contrato;
import model.DAO.ContratoDAO;
import model.DAO.PessoaDAO;
import model.DAO.PlanoPagamentoDAO;
import model.DAO.RecebimentoDAO;
import model.Pessoa;
import model.PlanoPagamento;
import model.Recebimento;
import model.TipoPessoa;
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
        dbUnit = new DbUnitHelper();
        
        dbUnit.backupDataBase();
        
        dbUnit.importar("BkpTeste.xml");
    }
    
    @AfterClass
    public static void tearDownClass() { 
        dbUnit.RestoreDataBase();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBuscarTodosProfessores() { 
        PessoaDAO instance = new PessoaDAO();        
        int expResult = 1;
        List<Pessoa> result = instance.getProfessores();
        assertEquals(expResult, result.size());
        
    } 
    
    @Test
    public void testPagouTodasParcelas(){
        PessoaDAO pessoaDao = new PessoaDAO();
        ContratoDAO contratoDao = new ContratoDAO();
        PlanoPagamentoDAO planoPagamentoDao = new PlanoPagamentoDAO();
        RecebimentoDAO recebimentoDao = new RecebimentoDAO();
        
        double valor = 0;
        
        Pessoa pessoa = new Pessoa();
        pessoa.setId(47);
        pessoa = pessoaDao.FindById(pessoa);
        
        if(!pessoa.getTipoPessoaId().getNome().equals("Aluno"))
            fail("A pessoa buscada não é um aluno");
        
        List<Contrato> contratos = contratoDao.FindByPersonId(pessoa);
        
        List<PlanoPagamento> planosPagamento = planoPagamentoDao.All();
        
        PlanoPagamento plano = new PlanoPagamento();
        
        for(PlanoPagamento p : planosPagamento)
            for(Contrato c : p.getContratoList())
                if(c.getId() == contratos.get(0).getId()){
                    plano = p;
                }
        
        if(plano != new PlanoPagamento()){
            List<Recebimento> recebimentos = recebimentoDao.FindByPersonId(pessoa.getId());
            
            for(Recebimento r : recebimentos){
                if(r.getContratoId().getId() == contratos.get(0).getId() && r.isPago()){
                    valor += r.getValor();
                }
            }
            
        }else{
            fail("A pessoa buscada não é um aluno");
        }
        
        assertEquals(200, valor, 0.0);
    }
    
    @Test
    public void testInserirPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Yuri");
        pessoa.setDtNascimento(new Date(2018-10-01));
        pessoa.setCpf("123456");
        pessoa.setSexo(false);
        pessoa.setAtiva(true);
        pessoa.setTipoPessoaId(new TipoPessoa(1, "Administrador"));
        
        Pessoa result = new PessoaDAO().Save(pessoa);
        pessoa.setId(51);
        assertEquals(pessoa, result);
    }
}
