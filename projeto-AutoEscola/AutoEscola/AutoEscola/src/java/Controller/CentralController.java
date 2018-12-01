/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Actions.AdminLoginViewAction;
import Actions.AgendaAulaPraticaProfessorViewAction;
import Actions.AgendaAulaTeoricaProfessorViewAction;
import Actions.AulaPraticaAlunoViewAction;
import Actions.AulaTeoricaAlunoViewAction;
import Actions.ControleAlunosViewAction;
import Actions.ControleProfessoresViewAction;
import Actions.DadosAlunoAction;
import Actions.EditaAlunoAction;
import Actions.HomeViewAction;
import Actions.LoginProfessorAction;
import Actions.LoginViewAction;
import Actions.LogoutAction;
import Actions.MarcaAulaPraticaAlunoViewAction;
import Actions.MarcaAulaTeoricaAlunoViewAction;
import Actions.MatriculaAction;
import Actions.MatriculaPagamentoViewAction;
import Actions.MinhasAulasTeoricasViewAction;
import Actions.MinhasAulasViewAction;
import Actions.ParticiparPraticaAction;
import Actions.ParticiparTeoricaAction;
import Actions.SaveAlunoAction;
import Actions.SavePagamentoAction;
import Actions.SelecionaAlunoViewAction;
import Actions.ValidaLoginAction;
import Actions.ValidaLoginAdminAction;
import Actions.ValidaLoginProfessorAction;
import Interfaces.ICommander;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "CentralController", urlPatterns = {"/control"})
public class CentralController extends HttpServlet {
    
    static HashMap<String,ICommander> tabela = new HashMap<>();
    
    static {
        tabela.put(null, new HomeViewAction());
        tabela.put("login", new LoginViewAction());
        tabela.put("matricula", new MatriculaAction());        
        tabela.put("gravarUser", new SaveAlunoAction());
        
        tabela.put("adminLogin", new AdminLoginViewAction());
        tabela.put("validaLogin", new ValidaLoginAction());
        tabela.put("validaLoginAdmin", new ValidaLoginAdminAction());
        tabela.put("logout", new LogoutAction());
        tabela.put("controleProfessores", new ControleProfessoresViewAction());
        tabela.put("controleAlunos", new ControleAlunosViewAction());
        tabela.put("dadosAluno", new DadosAlunoAction());
        tabela.put("editarUser", new EditaAlunoAction());
        tabela.put("matriculaPagamento", new MatriculaPagamentoViewAction());
        tabela.put("savePagamento", new SavePagamentoAction());
        tabela.put("selecionaAluno", new SelecionaAlunoViewAction());
        tabela.put("MarcaAlaPraticaAluno", new MarcaAulaPraticaAlunoViewAction());
        tabela.put("MarcaAlaTeoricaAluno", new MarcaAulaTeoricaAlunoViewAction());
        
        tabela.put("aulaTeorcaAluno", new AulaTeoricaAlunoViewAction());
        tabela.put("participarTeorica", new ParticiparTeoricaAction());
        tabela.put("minhasAulasTeoricas", new MinhasAulasTeoricasViewAction());
        
        tabela.put("aulaPraticaAluno", new AulaPraticaAlunoViewAction());
        tabela.put("participarPratica", new ParticiparPraticaAction());
        tabela.put("minhasAulasPraticas", new MinhasAulasViewAction());
        
        tabela.put("professorLogin", new LoginProfessorAction());
        tabela.put("validaProfessorLogin", new ValidaLoginProfessorAction());
        tabela.put("agendaAulasTeoricas", new AgendaAulaTeoricaProfessorViewAction());
        tabela.put("agendaAulasPraticas", new AgendaAulaPraticaProfessorViewAction());

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String action = request.getParameter("ac");
        
        try {
            tabela.get(action).executar(request, response);
        } catch (Exception ex) {
           response.getWriter().print(ex.getMessage());
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
