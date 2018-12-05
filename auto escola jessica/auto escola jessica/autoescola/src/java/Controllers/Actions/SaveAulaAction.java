/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aula;
import model.DAO.AulaDAO;
import model.TipoAula;
import model.Veiculo;

/**
 *
 * @author Jessica
 */
public class SaveAulaAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoAula ta = new TipoAula(Integer.parseInt(request.getParameter("aula")));
        Veiculo v = new Veiculo(Integer.parseInt(request.getParameter("veiculo")));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Aula aula = new Aula(
            sdf.parse(request.getParameter("data")),
            request.getParameter("hora"),
            ta,
            v);
        
        Aula a = new AulaDAO().Save(aula);
        new ListarAulasViewAction().Executar(request, response);
    }
    
}
