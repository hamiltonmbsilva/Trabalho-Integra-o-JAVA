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
import model.DAO.PessoaDAO;
import model.DAO.RecebimentoDAO;
import model.Pessoa;
import model.Recebimento;

/**
 *
 * @author Jessica
 */
public class SaveRecebimentoAction implements ICommander {

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Contrato c = new Contrato(Integer.parseInt(request.getParameter("id")));
       Contrato c = new ContratoDAO().FindById(Integer.parseInt(request.getParameter("id")));

        Double v = c.getPlanoPagamentoId().getValorTotal() / c.getPlanoPagamentoId().getQdtParcelas();
        Recebimento recebimento = new Recebimento(
                new Date(),
                c,
                true,
                v
        );

        Recebimento rec = new RecebimentoDAO().Update(recebimento);
        request.setAttribute("contrato", c);
        new RecebimentoViewAction().Executar(request, response);
    }

}
