/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.VeiculoDAO;
import model.TipoVeiculo;
import model.Veiculo;

/**
 *
 * @author Jessica
 */
public class SaveVeiculoAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoVeiculo tp = new TipoVeiculo(Integer.parseInt(request.getParameter("tipo")));
        Veiculo veiculo = new Veiculo(
            Integer.parseInt(request.getParameter("ano")),
            request.getParameter("placa"),
            tp);
        
        Veiculo v = new VeiculoDAO().Save(veiculo);
        request.setAttribute("veiculo", v);
        new ListarVeiculosViewAction().Executar(request, response);
        
    }
    
}
