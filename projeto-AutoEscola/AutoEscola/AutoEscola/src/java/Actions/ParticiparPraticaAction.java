/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AulaPraticaDAO;
import DAO.PagamentoDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.AulaPratica;
import Models.Pagamento;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ParticiparPraticaAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Aluno a = (Aluno) request.getSession().getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        AulaPratica aula = new AulaPraticaDAO().getById(id);
        List<AulaPratica> aulas = new AulaPraticaDAO().getPorAluno(a);
        Pagamento p = new PagamentoDAO().getPorAluno(a);
        
        if(aulas.size() == p.getQtdAulaPratica()){
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Você já excedeu seu pacote de aulas praticas. Contrate mais aulas para novas marcações.");
        }        
        else if(aula.getAlunoMatricula() == null || aula.getAlunoMatricula().getMatricula() == a.getMatricula()){
            aula.setAlunoMatricula(a);
            AulaPraticaDAO aDAO = new AulaPraticaDAO();
            aDAO.edit(aula);
            
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Agora você esta matriculado nesta aula");
        }
        else{
            request.setAttribute("verifica", true);
            request.setAttribute("erro", "Você não pode alterar/participar dessa aula");
        }
        
        new AulaPraticaAlunoViewAction().executar(request, response);
        
    }
    
}
