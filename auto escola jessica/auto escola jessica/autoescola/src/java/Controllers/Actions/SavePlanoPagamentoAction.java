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
import model.DAO.PlanoPagamentoDAO;
import model.PlanoPagamento;

/**
 *
 * @author Jessica
 */
public class SavePlanoPagamentoAction implements ICommander {
    
    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        PlanoPagamento pg = new PlanoPagamento(
                Integer.parseInt(request.getParameter("qdt_parcelas")),
                Double.parseDouble(request.getParameter("total")),
                request.getParameter("nome"),
                request.getParameter("vencimento"));        
        PlanoPagamento a = new PlanoPagamentoDAO().Save(pg);
        request.setAttribute("pessoa", a);
        new ListarPlanoPagamentoViewAction().Executar(request, response);
    }
    
}
