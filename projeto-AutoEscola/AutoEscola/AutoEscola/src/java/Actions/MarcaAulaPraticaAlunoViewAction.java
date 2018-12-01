/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import DAO.AulaPraticaDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.AulaPratica;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class MarcaAulaPraticaAlunoViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Aluno aluno = new AlunoDAO().getByID(request.getParameter("id"));
        request.getSession().setAttribute("user",aluno);
        
        List<AulaPratica> praticas = new AulaPraticaDAO().getSemAluno();
               
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=aluno/aulaPratica");
        request.setAttribute("praticas", praticas);
        rd.forward(request, response);
        
    }
    
}
