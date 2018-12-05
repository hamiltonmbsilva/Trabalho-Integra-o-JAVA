<%-- 
    Document   : listarContratos
    Created on : Oct 1, 2018, 2:05:36 AM
    Author     : Jessica
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Contrato"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Contratos</h3>
    <div class="panel-body">
        <div class="form-group">
            <a class="btn btn-outline-warning" href="BaseController?act=contrato" >Novo Contrato</a>
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
                        <th>Validade</th>
                        <th>Titular</th>
                        <th>Plano de Pagamento</th>
                        <th>Opções</th>
                    </tr>
                </thead>

                <% List<Contrato> lista = (List<Contrato>) request.getAttribute("contratos");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    for (Contrato cont : lista) {%>
                <tr>
                    <td><%= cont.getId()%></td>
                    <td><%= sdf.format(cont.getValidade()) %></td>
                    <td><%= cont.getPessoaId().getNome()%></td>
                    <td><%= cont.getPlanoPagamentoId().getNome()%></td>
                    <td><a href="BaseController?act=detalharcontrato&id=<%=cont.getId()%>" class="btn btn-xs btn-info">Ver</a></td>
                </tr>
                <%}%> 
            </table>
        </div>
    </div>
</div>
