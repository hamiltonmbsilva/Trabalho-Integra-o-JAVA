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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ControleAlunosViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");// FOrmat in This Format or you change Change as well 
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=admin/controleAlunos");
        List<Aluno> alunos = new AlunoDAO().getAll();
        
        for(Aluno a: alunos)
        {
            String data = sdf.format(a.getDataNascimento());
            a.setDataNascimento(sdf.parse(data));
            System.out.println("espera");
        }
        
        request.setAttribute("alunos", alunos);
        rd.forward(request, response);
        
    }
    
}
