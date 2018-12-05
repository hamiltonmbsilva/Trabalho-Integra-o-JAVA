/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agenda;
import model.Aula;
import model.DAO.AgendaDAO;
import model.Pessoa;

/**
 *
 * @author Jessica
 */
public class SaveAgendaAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("professor")));
        Aula aula = new Aula(Integer.parseInt(request.getParameter("aula")));
        
        Agenda agenda = new Agenda(
                Boolean.parseBoolean(request.getParameter("disponivel")),
                aula,
                pessoa);
        
        Agenda a = new AgendaDAO().Save(agenda);
        new HomeViewAction().Executar(request, response);
        
    }
    
}
