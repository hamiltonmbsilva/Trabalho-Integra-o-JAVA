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
import model.Pessoa;

/**
 *
 * @author Jessica
 */
public class SaveMatriculaAction implements ICommander {

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pessoa p = new Pessoa();
       p.setId(Integer.parseInt(request.getParameter("idPessoa")));
        Matricula matricula = new Matricula(
            request.getParameter("login"),
            request.getParameter("senha"),
            request.getParameter("email"),
            p,
            Boolean.parseBoolean(request.getParameter("matricula")),
            Boolean.parseBoolean(request.getParameter("psc")));
        
        Matricula m = new MatriculaDAO().Save(matricula);
        new ListarAlunosViewAction().Executar(request, response);
    }
    
}
