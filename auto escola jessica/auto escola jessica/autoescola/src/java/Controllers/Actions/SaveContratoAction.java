/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contrato;
import model.DAO.ContratoDAO;
import model.DAO.PlanoPagamentoDAO;
import model.DAO.RecebimentoDAO;
import model.Pessoa;
import model.PlanoPagamento;
import model.Recebimento;

/**
 *
 * @author Jessica
 */
public class SaveContratoAction implements ICommander {

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pessoa p = new Pessoa();
        p.setId(Integer.parseInt(request.getParameter("titular")));
        PlanoPagamento pl = new PlanoPagamento();
        pl.setId(Integer.parseInt(request.getParameter("plano_pg")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Contrato contrato = new Contrato(
                sdf.parse(request.getParameter("validade")),
                p,
                pl);

        Contrato m = new ContratoDAO().Save(contrato); 
        
        PlanoPagamento plan = new PlanoPagamentoDAO().FindById(m.getPlanoPagamentoId().getId());
        
        int q = plan.getQdtParcelas();
        double d = plan.getValorTotal();
        Double valor =  d/q ;
        for (int i = 1; i <= q; i++) {
            Recebimento recebimento = new Recebimento(
                    new Date(),
                    m,
                    false,
                    valor);
            Recebimento rec = new RecebimentoDAO().Save(recebimento);
        }
        request.setAttribute("contratoSave", m);
        new ListarContratosViewAction().Executar(request, response);
    }

}
