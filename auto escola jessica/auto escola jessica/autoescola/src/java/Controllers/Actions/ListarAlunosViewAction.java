/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.MatriculaDAO;
import model.Matricula;

/**
 *
 * @author Jessica
 */
public class ListarAlunosViewAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=listarAlunos");
        request.setAttribute("alunos", new MatriculaDAO().All());
        rd.forward(request, response);
    }
    
}
