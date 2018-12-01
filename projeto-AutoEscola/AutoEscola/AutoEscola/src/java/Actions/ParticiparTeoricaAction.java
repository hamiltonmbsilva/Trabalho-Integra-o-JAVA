/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import DAO.AulaTeoricaDAO;
import DAO.PagamentoDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.AulaTeorica;
import Models.Pagamento;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ParticiparTeoricaAction implements ICommander {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Aluno a = (Aluno) request.getSession().getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        AulaTeorica aula = new AulaTeoricaDAO().getById(id);
        Pagamento p = new PagamentoDAO().getPorAluno(a);
        boolean verifica = true;

        for (Aluno al : aula.getAlunoList()) {
            if (al.getMatricula() == a.getMatricula()) {
                verifica = false;
            }
        }
        
        if(a.getAulaTeoricaList().size() < p.getQtdAulaTeorica()){

            if (verifica) {
                List<AulaTeorica> aulas = a.getAulaTeoricaList();
                aulas.add(aula);
                a.setAulaTeoricaList(aulas);

                AlunoDAO aDAO = new AlunoDAO();
                aDAO.edit(a);

                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Matricula realizada com sucesso");
            } else {
                request.setAttribute("verifica", true);
                request.setAttribute("mensagem", "Você já esta matriculado nesta aula");
            }
        }
        else{
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Você já excedeu seu pacote de aulas praticas. Contrate mais aulas para novas marcações.");
        }

        new AulaTeoricaAlunoViewAction().executar(request, response);

    }

}
