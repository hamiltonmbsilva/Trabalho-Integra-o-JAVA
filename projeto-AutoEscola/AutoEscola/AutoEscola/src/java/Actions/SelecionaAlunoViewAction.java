/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import Interfaces.ICommander;
import Models.Aluno;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class SelecionaAlunoViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List<Aluno> alunos = new AlunoDAO().getAllMatriculados();
               
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=admin/selecionaAlunoAula");
        request.setAttribute("alunos", alunos);
        rd.forward(request, response);
        
    }
    
}
