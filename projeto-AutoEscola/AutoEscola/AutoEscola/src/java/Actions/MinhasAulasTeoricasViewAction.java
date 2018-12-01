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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class MinhasAulasTeoricasViewAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Aluno aluno = (Aluno) request.getSession().getAttribute("user");
        
        List<AulaTeorica> todas = new AulaTeoricaDAO().getAll();
        List<AulaTeorica> teoricas = new ArrayList<>();
        
        for(AulaTeorica at: todas){
            for(Aluno a: at.getAlunoList()){
                if(aluno.getMatricula() == a.getMatricula()){
                    teoricas.add(at);
                }
            }
        }
               
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=aluno/minhasAulasTeoricas");
        request.setAttribute("teoricas", teoricas);
        rd.forward(request, response);
        
    }
    
}
