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
import model.DAO.RecebimentoDAO;

/**
 *
 * @author Jessica
 */
public class ListarPagamentosViewAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=pagamentos");
        request.setAttribute("pagamentos", new RecebimentoDAO().FindByPersonId(Integer.parseInt(request.getParameter("titular"))));
        rd.forward(request, response);
    }
    
}
