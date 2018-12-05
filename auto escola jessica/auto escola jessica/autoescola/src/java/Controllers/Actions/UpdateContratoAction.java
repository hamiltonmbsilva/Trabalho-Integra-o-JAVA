/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contrato;
import model.DAO.ContratoDAO;
import model.DAO.PessoaDAO;
import model.DAO.PlanoPagamentoDAO;
import model.DAO.RecebimentoDAO;
import model.Pessoa;
import model.PlanoPagamento;
import model.Recebimento;

/**
 *
 * @author Jessica
 */
public class UpdateContratoAction implements ICommander {

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PlanoPagamento pl = new PlanoPagamentoDAO().FindById(Integer.parseInt(request.getParameter("plano_pg")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Contrato contrato = new ContratoDAO().FindById(Integer.parseInt(request.getParameter("id")));
        if (contrato.getPlanoPagamentoId().getId() != pl.getId()) {
            contrato.setPlanoPagamentoId(pl);
            for (Recebimento recebimento : contrato.getRecebimentoList()) {
                new RecebimentoDAO().Delete(recebimento.getId());
            }
            contrato.setRecebimentoList(new ArrayList<>());
            Contrato m = new ContratoDAO().Update(contrato);

            Double valor = contrato.getPlanoPagamentoId().getValorTotal() / contrato.getPlanoPagamentoId().getQdtParcelas();
            for (int i = 1; i <= contrato.getPlanoPagamentoId().getQdtParcelas(); i++) {
                Recebimento recebimento = new Recebimento(
                        new Date(),
                        m,
                        false,
                        valor);
                contrato.getRecebimentoList().add(recebimento);
                Recebimento rec = new RecebimentoDAO().Save(recebimento);
            }
        }
        new ListarContratosViewAction().Executar(request, response);
    }

}
