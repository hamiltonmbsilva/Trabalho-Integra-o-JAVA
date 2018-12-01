/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import DAO.AulaTeoricaDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.AulaTeorica;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class MarcaAulaTeoricaAlunoViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Aluno aluno = new AlunoDAO().getByID(request.getParameter("id"));
        request.getSession().setAttribute("user",aluno);
        
        List<AulaTeorica> aulas = new AulaTeoricaDAO().getAll();
        List<AulaTeorica> teoricas = new ArrayList<AulaTeorica>();
        
        if(aluno != null){
            for(AulaTeorica at: aulas){
                
                if(at.getAlunoList().size() < 20){
                    teoricas.add(at);
                }
                
                for(Aluno al: at.getAlunoList()){
                    if(al.getMatricula() == aluno.getMatricula()){
                        teoricas.remove(at);
                    }
                }
            }
        }
        else{        
            for(AulaTeorica a: aulas)
            {
                if(a.getAlunoList().size() < 20){
                    teoricas.add(a);
                }
            }
        }
               
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=aluno/aulaTeorica");
        request.setAttribute("teoricas", teoricas);
        rd.forward(request, response);
        
    }
    
}
