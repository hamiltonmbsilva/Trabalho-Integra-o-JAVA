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
public class SavePessoaAction implements ICommander{

    @Override
    public void Executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        TipoPessoa tp = new TipoPessoa();
        tp.setId(3);       
        Pessoa pessoa = new Pessoa(
            request.getParameter("nome"),
            sd.parse(request.getParameter("dt_nasc")),
            request.getParameter("cpf"),
            parseBoolean(request.getParameter("sexo")),
            true,
            tp);        
        Pessoa a =  new PessoaDAO().Save(pessoa);
        request.setAttribute("pessoa", a.getId());
        new MatricularViewAction().Executar(request, response);
    
   }
    
}
