<%-- 
    Document   : detalharplanopagamento
    Created on : 04/10/2018, 18:14:18
    Author     : jroza
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO.PlanoPagamentoDAO"%>
<%@page import="model.PlanoPagamento"%>
<%@page import="java.util.List"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    PlanoPagamento plano = new PlanoPagamentoDAO().FindById(id);
%>
<h3><i class="fa fa-angle-right"></i> Atualizar Plano de Pagamento</h3>
<div class="panel-body">
    <form method="POST" action="BaseController?act=saveplanopagamento">
        <div class="form-group">
            <label for="qdt_parcelas">Número Total de Parcelas:</label>
            <input id="qdt_parcelas" name="qdt_parcelas" class="form-control" type="number" required 
                value="<%=plano.getQdtParcelas()%>">
        </div>
        <div class="form-group">
            <label for="total">Valor Total do Plano:</label>
            <input id="total" name="total" class="form-control" required value="<%=plano.getValorTotal()%>">
        </div>
        <div class="form-group">
            <label for="nome">Nome para o Plano:</label>
            <input id="nome" name="nome" class="form-control" required value="<%=plano.getNome()%>">
        </div>
        <div class="form-group">
            <label for="vencimento">Vencimento:</label>
            <input id="vencimento" name="vencimento" class="form-control" required value="<%=plano.getVencimento()%>">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-warning" >Salvar</button>
        </div>
    </form>
</div>
