/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Actions;

import Controllers.Actions.Face.ICommander;
import static java.lang.Boolean.parseBoolean;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.PessoaDAO;
import model.Pessoa;
import model.TipoPessoa;

/**
 *
 * @author Jessica
 */
public class UpdatePessoaAction implements ICommander {

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        TipoPessoa tp = new TipoPessoa();
        tp.setId(Integer.parseInt(request.getParameter("titular")));
        Pessoa pessoa = new Pessoa(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("nome"),
                sd.parse(request.getParameter("dt_nasc")),
                request.getParameter("cpf"),
                parseBoolean(request.getParameter("sexo")),
                parseBoolean(request.getParameter("ativo")),
                tp);
        Pessoa a = new PessoaDAO().Update(pessoa);
        new ListarAlunosViewAction().Executar(request, response);

    }

}
