/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Interfaces.ICommander;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class HomeViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=home");
        rd.forward(request, response);
    
    }
    
}
