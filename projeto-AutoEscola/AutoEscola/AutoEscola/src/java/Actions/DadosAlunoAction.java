/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import DAO.AlunoDAO;
import DAO.PagamentoDAO;
import Interfaces.ICommander;
import Models.Aluno;
import Models.Pagamento;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class DadosAlunoAction implements ICommander{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Aluno a = new AlunoDAO().getByID(request.getParameter("id"));
        
        String data = sdf.format(a.getDataNascimento());
        request.setAttribute("a", a);
        request.setAttribute("data", data);
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=admin/dadosAluno");
        rd.forward(request, response);
        
    }
    
}
