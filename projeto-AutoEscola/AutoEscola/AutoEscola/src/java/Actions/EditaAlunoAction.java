/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import Interfaces.ICommander;
import Models.Aluno;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class EditaAlunoAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Aluno aluno = new AlunoDAO().getByID(request.getParameter("matricula"));
        
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
        aluno.setMatriculado(Boolean.parseBoolean(request.getParameter("matriculado")));
        
        new AlunoDAO().edit(aluno);
        
        new ControleAlunosViewAction().executar(request, response);
        
    }
    
}
