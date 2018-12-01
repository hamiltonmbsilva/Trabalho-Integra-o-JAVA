/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.LoginDAO;
import DAO.PessoaDAO;
import Interfaces.ICommander;
import Models.Login;
import Models.Pessoa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ValidaLoginAdminAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        LoginDAO l = new LoginDAO();
        Login log = l.validaLogin(login, senha);
        
        PessoaDAO p = new PessoaDAO();
        Pessoa pessoa = p.BuscarPorLogin(log);
        
        if(pessoa == null){
            new AdminLoginViewAction().executar(request, response);
        }
        else{
            
            if(pessoa.getTipoPessoa().equals("atendente")){
                request.getSession().setAttribute("atendente", pessoa);
                new HomeViewAction().executar(request, response);
            }
            else{
                request.getSession().setAttribute("admin", pessoa);
                new HomeViewAction().executar(request, response);
            }
        }
    }
    
}
