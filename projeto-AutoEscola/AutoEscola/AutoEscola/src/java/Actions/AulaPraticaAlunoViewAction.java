/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AulaPraticaDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.AulaPratica;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class AulaPraticaAlunoViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Aluno a = (Aluno) request.getSession().getAttribute("user");
        
        List<AulaPratica> praticas = new AulaPraticaDAO().getSemAluno();
               
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=aluno/aulaPratica");
        request.setAttribute("praticas", praticas);
        rd.forward(request, response);
        
    }
    
}
