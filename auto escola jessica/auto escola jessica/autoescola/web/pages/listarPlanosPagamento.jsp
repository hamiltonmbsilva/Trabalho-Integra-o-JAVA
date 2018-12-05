<%-- 
    Document   : listarPlanosPagamento
    Created on : 04/10/2018, 16:52:19
    Author     : jroza
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.PlanoPagamento"%>
<%@page import="java.util.List"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Planos de Pagamento</h3>
    <div class="panel-body">
        <div class="form-group">
            <a class="btn btn-outline-warning" href="BaseController?act=planopagamento">Novo</a>
        </div>
        <form>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search">
                <div class="input-group-btn">
                    <button class="btn btn-warning" type="submit">
                        <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </form>
        <br>
        <div>
            <table class="table table-responsive table-striped">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Total de Parcelas</th>
                        <th>Valor Total</th>
                        <th>Vencimento</th>
                        <th>Opções</th>
                    </tr>
                </thead>

                <% List<PlanoPagamento> lista = (List<PlanoPagamento>) request.getAttribute("planosPagamento");
                    for (PlanoPagamento plano : lista) {%>
                <tr>
                    <td><%= plano.getId()%></td>
                    <td><%= plano.getNome() %></td>
                    <td><%= plano.getQdtParcelas()%></td>
                    <td><%= plano.getValorTotal()%></td>
                    <td><%= plano.getVencimento()%></td>
                    <td><a href="BaseController?act=detalharplanopagamento&id=<%=plano.getId()%>" class="btn btn-xs btn-info">Ver</a></td>
                </tr>
                <%}%> 
            </table>
        </div>
    </div>
</div>
