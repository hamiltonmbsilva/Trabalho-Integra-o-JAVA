/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.MatriculaDAO;
import model.Matricula;

/**
 *
 * @author Jessica
 */
public class LogarAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Matricula p = new MatriculaDAO().Login(login,senha);
        
        if (p == null){
//            request.setAttribute("info", "Login ou Senha Incorreta!!!");
            new LoginViewAction().Executar(request, response);
        }else{
            request.getSession().setAttribute("user", p);
            new HomeViewAction().Executar(request, response);
        }    
    
    }
    
}
