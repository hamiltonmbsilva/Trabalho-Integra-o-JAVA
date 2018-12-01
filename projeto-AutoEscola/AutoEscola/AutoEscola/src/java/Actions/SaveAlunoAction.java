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
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class SaveAlunoAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Login login = new Login();
        login.setLogin(request.getParameter("login"));
        login.setSenha(request.getParameter("senha"));
        LoginDAO l = new LoginDAO();
        l.save(login);
        login = l.BuscaPorLogin(request.getParameter("login"));
        
        Aluno aluno = new Aluno();
        aluno.setNome(request.getParameter("nome"));
        aluno.setCpf(request.getParameter("cpf"));
        aluno.setEmail(request.getParameter("email"));
        aluno.setDataNascimento(sdf.parse(request.getParameter("dt_nasc")));
        aluno.setLogradouro(request.getParameter("logradouro"));
        aluno.setNumero(request.getParameter("numero"));
        aluno.setComplemento(request.getParameter("complemento"));
        aluno.setBairro(request.getParameter("bairro"));
        aluno.setCidade(request.getParameter("cidade"));
        aluno.setEstado(request.getParameter("estado"));
        aluno.setLoginId(login);
        
        new AlunoDAO().save(aluno);            

        request.setAttribute("verifica", true);
        request.setAttribute("mensagem", "Sua pré matrícula foi realizada, realize o pagamento para efetiva-la.");    
        new HomeViewAction().executar(request, response);
        
    }
    
}
