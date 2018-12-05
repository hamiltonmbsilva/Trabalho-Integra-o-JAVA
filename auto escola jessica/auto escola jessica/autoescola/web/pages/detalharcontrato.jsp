<%-- 
    Document   : detalharcontrato
    Created on : Oct 4, 2018, 3:30:27 AM
    Author     : Jessica
--%>

<%@page import="model.DAO.ContratoDAO"%>
<%@page import="model.Contrato"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO.PlanoPagamentoDAO"%>
<%@page import="model.PlanoPagamento"%>
<%@page import="model.DAO.PessoaDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<%
    Contrato contrato = (Contrato) request.getAttribute("detalheContrato");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

%>
<div class="panel-body">
    <h3><i class="fa fa-angle-right"></i> Contrato</h3>
    <form action="BaseController?act=updatecontrato" method="POST">
        <div class="form-group">
            <label for="titular" >Titular do Contrato:</label>
            <label class="form-control" name="titular"><%=contrato.getPessoaId().getNome()%></label>                
        </div>
        <div class="form-group">
            <input type="hidden" name="id" value="<%= contrato.getId()%>" >
            <label for="validade" >Data de Validade:</label>
            <label id="validade" name="validade" class="form-control"><%=sdf.format(contrato.getValidade())%></label>
        </div>        
        <div class="form-group">
            <label for="plano_pg" >Plano de Pagamento</label>
            <select id="plano_pg" name="plano_pg" class="form-control">
                <option value="">Selecione...</option>
                <%
                    List<PlanoPagamento> planos = (List<PlanoPagamento>) request.getAttribute("listagemPlanos");
                    for (PlanoPagamento p : planos) {
                        if (contrato.getPlanoPagamentoId().getId() == p.getId()) {
                            out.println("<option value='" + p.getId() + "' selected>" + p.getNome() + "</option>");
                        } else {
                            out.println("<option value='" + p.getId() + "'>" + p.getNome() + "</option>");
                        }
                    }
                %> 
            </select> 
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-warning">Salvar</button>
        </div>
    </form> 
</div>
