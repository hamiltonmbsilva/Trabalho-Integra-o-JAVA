/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AulaTeoricaDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.AulaTeorica;
import Models.Professor;
import java.text.DateFormat;
import static java.text.DateFormat.FULL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class AulaTeoricaAlunoViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
           
        Aluno aluno = (Aluno) request.getSession().getAttribute("user");
        
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
