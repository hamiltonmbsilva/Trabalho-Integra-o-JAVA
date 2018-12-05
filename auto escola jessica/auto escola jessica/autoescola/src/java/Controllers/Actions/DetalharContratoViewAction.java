/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contrato;
import model.DAO.ContratoDAO;
import model.DAO.PlanoPagamentoDAO;
import model.PlanoPagamento;

/**
 *
 * @author Jessica
 */
public class DetalharContratoViewAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contrato contrato = new ContratoDAO().FindById(Integer.parseInt(request.getParameter("id")));
        List<PlanoPagamento> planos = new PlanoPagamentoDAO().All();
        request.setAttribute("detalheContrato", contrato);
        request.setAttribute("listagemPlanos", planos);
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=detalharcontrato");
        rd.forward(request, response); 
    }
    
}
