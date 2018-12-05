<%-- 
    Document   : pagamentos
    Created on : Oct 2, 2018, 1:28:38 AM
    Author     : Jessica
--%>
<%@page import="model.Recebimento"%>
<%@page import="model.DAO.ContratoDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Contrato"%>
<%@page import="model.DAO.PessoaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Pessoa"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Pagamentos</h3>
    <div class="panel-body">
        <form method="POST" action="BaseController?act=listarrecebimentos">
            <label for="titular" >Titular do Contrato:</label>
            <div class="input-group">                
                <select id="titular" name="titular" class="form-control" data-search="true" required>
                    <option value="">Selecione...</option>
                    <%
                        List<Pessoa> pessoas = new PessoaDAO().All();
                        for (Pessoa p : pessoas) {
                            out.println("<option value='" + p.getId() + "'>" + p.getNome() + "</option>");
                        }
                    %>                
                </select> 
                <div class="input-group-btn">
                    <button class="btn btn-warning" type="submit">
                        <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </form>
        <div>
            <table class="table table-responsive table-striped">
                <thead>
                    <tr>
                        <th>Mensalidade</th>                        
                        <th>Contrato</th>
                        <th>Titular</th>
                        <th>Valor</th>
                        <th>Data</th>
                        <th>Opção</th>
                    </tr>
                </thead>
                <%
                    List<Recebimento> lista = null;
                    if (request.getAttribute("pagamentos") != null) {
                        lista = (List<Recebimento>) request.getAttribute("pagamentos");
                        int i = 1;
                        for (Recebimento c : lista) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                %>
                <tr>  
                    <td>Nº <%=i%> de <%= lista.size()%> </td>                    
                    <td><%=c.getContratoId().getId()%></td>
                    <td><%=c.getContratoId().getPessoaId().getNome()%></td>
                    <td><%=c.getValor()%></td>
                    <%
                        if (c.isPago()) {%>
                    <td><%=sdf.format(c.getData())%></td>
                    <td>Pago</td>
                        <%} else {
                        %>
                        <td>A pagar</td>    
                    <td><a class="btn btn-xs btn-warning" 
                           href="BaseController?act=saverecebimento&id=<%=c.getContratoId().getId()%>">Quitar</a></td>
                </tr>
                <%}
                            i++;
                        }
                    }%> 
            </table>
        </div>
    </div>
</div>
