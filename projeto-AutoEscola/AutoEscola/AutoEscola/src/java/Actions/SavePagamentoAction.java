/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import DAO.PagamentoDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.Pagamento;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class SavePagamentoAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Aluno a = new AlunoDAO().getByID(request.getParameter("matricula"));
        a.setMatriculado(Boolean.parseBoolean(request.getParameter("matriculado")));
        
        Pagamento p = new Pagamento();
        p.setAlunoMatricula(a);
        p.setSituacao(request.getParameter("situacao"));
        p.setValor(Double.parseDouble(request.getParameter("valTotal")));
        p.setAvista(Boolean.parseBoolean(request.getParameter("tipo")));
        p.setDataPagamento(sdf.parse(request.getParameter("dt_pag")));
        p.setQtdAulaTeorica(Integer.parseInt(request.getParameter("qtdTeoricas")));
        p.setQtdAulaPratica(Integer.parseInt(request.getParameter("qtdPraticas")));
        
        if(!p.getAvista()){
            p.setNumParcelas(Integer.parseInt(request.getParameter("numParcelas")));
            p.setValorParcelas(Double.parseDouble(request.getParameter("valParcelas")));
        }
        
        new AlunoDAO().edit(a);
        new PagamentoDAO().save(p);
        
        request.setAttribute("verifica", true);
        request.setAttribute("mensagem", "Alterações efetuadas com sucesso!"); 
        new ControleAlunosViewAction().executar(request, response);
    }    
}
