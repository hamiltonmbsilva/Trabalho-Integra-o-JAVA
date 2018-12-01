/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.LoginDAO;
import DAO.ProfessorDAO;
import Interfaces.ICommander;
import Models.Login;
import Models.Professor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ValidaLoginProfessorAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        LoginDAO l = new LoginDAO();
        Login log = l.validaLogin(login, senha);
        
        ProfessorDAO p = new ProfessorDAO();
        Professor professor = p.BuscarPorLogin(log);
        
        if(professor == null){
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Login ou senha incorretos!");
            new LoginViewAction().executar(request, response);
        }
        else{
            request.getSession().setAttribute("professor", professor);
            new HomeViewAction().executar(request, response);
        }
        
    }
}
