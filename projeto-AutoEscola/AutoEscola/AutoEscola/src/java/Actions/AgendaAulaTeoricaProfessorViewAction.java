/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AulaTeoricaDAO;
import Interfaces.ICommander;
import Models.AulaTeorica;
import Models.Professor;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class AgendaAulaTeoricaProfessorViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Professor p = (Professor) request.getSession().getAttribute("professor");
        List<AulaTeorica> teoricas = new AulaTeoricaDAO().getPorProfessor(p);
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=professor/agendaTeoricas");
        request.setAttribute("teoricas", teoricas);
        rd.forward(request, response);
        
    }
    
}
