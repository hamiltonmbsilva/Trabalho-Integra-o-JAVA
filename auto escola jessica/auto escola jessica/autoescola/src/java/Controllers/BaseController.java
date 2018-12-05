/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.Actions.AgendaViewAction;
import Controllers.Actions.AulaViewAction;
import Controllers.Actions.CadastrarViewAction;
import Controllers.Actions.ContratoViewAction;
import Controllers.Actions.DetalharAlunoViewAction;
import Controllers.Actions.DetalharContratoViewAction;
import Controllers.Actions.DetalharPlanoPagamentoViewAction;
import Controllers.Actions.DetalharVeiculoViewAction;
import Controllers.Actions.Face.ICommander;
import Controllers.Actions.HomeViewAction;
import Controllers.Actions.ListarAgendaViewAction;
import Controllers.Actions.ListarAlunosViewAction;
import Controllers.Actions.ListarAulasViewAction;
import Controllers.Actions.ListarContratosViewAction;
import Controllers.Actions.ListarPagamentosViewAction;
import Controllers.Actions.ListarPlanoPagamentoViewAction;
import Controllers.Actions.ListarVeiculosViewAction;
import Controllers.Actions.LogarAction;
import Controllers.Actions.LoginViewAction;
import Controllers.Actions.MatricularViewAction;
import Controllers.Actions.NewHome;
import Controllers.Actions.PlanoPagamentoViewAction;
import Controllers.Actions.RecebimentoViewAction;
import Controllers.Actions.SaveAgendaAction;
import Controllers.Actions.SaveAulaAction;
import Controllers.Actions.SaveContratoAction;
import Controllers.Actions.SaveMatriculaAction;
import Controllers.Actions.SavePessoaAction;
import Controllers.Actions.SavePlanoPagamentoAction;
import Controllers.Actions.SaveRecebimentoAction;
import Controllers.Actions.SaveVeiculoAction;
import Controllers.Actions.UpdateContratoAction;
import Controllers.Actions.UpdatePessoaAction;
import Controllers.Actions.VeiculoViewAction;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jessica
 */
@WebServlet(name="BaseController",urlPatterns = {"/BaseController"} )
public class BaseController extends HttpServlet {
    
    static HashMap<String,ICommander> comandos = new HashMap<>();
    
    static {
        // para novas rotas precisa criar novas aqui
//        comandos.put(null, new HomeViewAction());
        comandos.put("login", new LoginViewAction());
        comandos.put("cadastrar", new CadastrarViewAction());
        comandos.put("savepessoa", new SavePessoaAction());
        comandos.put("matricular", new MatricularViewAction());
        comandos.put("savematricula", new SaveMatriculaAction());
        comandos.put("logar", new LogarAction());
        comandos.put("listarAlunos", new ListarAlunosViewAction());
        comandos.put("detalharaluno", new DetalharAlunoViewAction());
        comandos.put("contrato", new ContratoViewAction());
        comandos.put("savecontrato", new SaveContratoAction());
        comandos.put("listarContratos", new ListarContratosViewAction());
        comandos.put("planopagamento", new PlanoPagamentoViewAction());
        comandos.put("saveplanopagamento", new SavePlanoPagamentoAction());
        comandos.put("pagamentos", new RecebimentoViewAction());  
        comandos.put("saverecebimento", new SaveRecebimentoAction());
        comandos.put("veiculo", new VeiculoViewAction());
        comandos.put("listarveiculos", new ListarVeiculosViewAction());
        comandos.put("saveveiculo", new SaveVeiculoAction());
        comandos.put("listaraulas", new ListarAulasViewAction());
        comandos.put("aula", new AulaViewAction());
        comandos.put("saveaula", new SaveAulaAction());
        comandos.put("listaragenda", new ListarAgendaViewAction());
        comandos.put("agenda", new AgendaViewAction());
        comandos.put("saveagenda", new SaveAgendaAction());
        comandos.put("updatepessoa", new UpdatePessoaAction());
        comandos.put("listarrecebimentos", new ListarPagamentosViewAction());
        comandos.put("detalharcontrato", new DetalharContratoViewAction());
        comandos.put("updatecontrato", new UpdateContratoAction());
        comandos.put("listarPlanosPagamento", new ListarPlanoPagamentoViewAction());
        comandos.put("detalharplanopagamento", new DetalharPlanoPagamentoViewAction());
        comandos.put("detalharveiculo", new DetalharVeiculoViewAction());
        comandos.put(null, new NewHome());
    }
    
    
    //
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      String option = request.getParameter("act");
        try {
            comandos.get(option).Executar(request,response);
        } catch (Exception ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
