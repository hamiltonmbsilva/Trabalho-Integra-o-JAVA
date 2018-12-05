<%-- 
    Document   : contrato
    Created on : Sep 30, 2018, 10:47:49 PM
    Author     : Jessica
--%>

<%@page import="model.DAO.PlanoPagamentoDAO"%>
<%@page import="model.PlanoPagamento"%>
<%@page import="model.DAO.ContratoDAO"%>
<%@page import="model.Contrato"%>
<%@page import="java.util.List"%>
<%@page import="model.DAO.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<div class="panel-body">
     <h3><i class="fa fa-angle-right"></i> Contrato</h3>
    <form action="BaseController?act=savecontrato" method="POST">
        <div class="form-group">
            <label for="validade" >Data de Validade:</label>
            <input id="validade" name="validade" class="form-control" type="date">
        </div>
        <div class="form-group">
            <label for="titular" >Titular do Contrato:</label>
            <select id="titular" name="titular" class="form-control">
                <option value="">Selecione...</option>
                <%
                    List<Pessoa> pessoas = new PessoaDAO().All();
                    for (Pessoa p : pessoas){
                        out.println("<option value='"+p.getId()+"'>"+p.getNome()+"</option>");
                    }
                %>                
            </select> 
        </div>
        <div class="form-group">
            <label for="plano_pg" >Plano de Pagamento</label>
            <select id="plano_pg" name="plano_pg" class="form-control">
                <option value="">Selecione...</option>
                <%
                    List<PlanoPagamento> planos = new PlanoPagamentoDAO().All();
                    for (PlanoPagamento p : planos){
                        out.println("<option value='"+p.getId()+"'>"+p.getNome()+"</option>");
                    }
                %> 
            </select> 
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-warning">Salvar</button>
        </div>
    </form> 
</div>
