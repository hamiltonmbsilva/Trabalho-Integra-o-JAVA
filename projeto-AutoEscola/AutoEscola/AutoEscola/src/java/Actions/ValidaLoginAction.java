/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import DAO.LoginDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ValidaLoginAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        LoginDAO l = new LoginDAO();
        Login log = l.validaLogin(login, senha);
        
        AlunoDAO a = new AlunoDAO();
        Aluno aluno = a.BuscarPorLogin(log);
        
        if(aluno == null){
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Login ou senha incorretos!");
            new LoginViewAction().executar(request, response);
        }
        else if(!aluno.getMatriculado()){
            request.setAttribute("verifica", true);
            request.setAttribute("mensagem", "Finalize sua matricula para logar no sistema.");
            new LoginViewAction().executar(request, response);
        }
        else{
            request.getSession().setAttribute("user", aluno);
            new HomeViewAction().executar(request, response);
        }
        
    }
    
}
