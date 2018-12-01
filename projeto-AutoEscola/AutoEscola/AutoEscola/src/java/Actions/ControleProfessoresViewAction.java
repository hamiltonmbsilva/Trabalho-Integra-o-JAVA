/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.ProfessorDAO;
import Interfaces.ICommander;
import Models.Professor;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ControleProfessoresViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=controleProfessores");
        List<Professor> professores = new ProfessorDAO().getAll();
        request.setAttribute("professores", professores);
        rd.forward(request, response);
        
    }
    
}
