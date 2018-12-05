<%-- 
    Document   : listaraulas
    Created on : Oct 2, 2018, 5:42:16 AM
    Author     : Jessica
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO.AulaDAO"%>
<%@page import="model.Aula"%>
<%@page import="java.util.List"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Aulas</h3>
    <div class="panel-body">
        <div class="form-group">
            <a class="btn btn-outline-warning" href="BaseController?act=aula" >Novo Aula</a>
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
                        <th>Data</th>
                        <th>Hora</th>
                        <th>Modalidade</th>
                        <th>Veiculo Placa</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <% List<Aula> lista = new AulaDAO().All();
                    for (Aula cont : lista) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");                    
                %>
                <tr>
                    <td><%= cont.getId()%></td>
                    <td><%= sdf.format(cont.getData())%></td>
                    <td><%= cont.getHora()%></td>
                    <td><%= cont.getTipoAulaId().getNome()%></td>
                    <td><%= cont.getVeiculoId().getPlaca()%></td>
                    <td><a href="BaseController?act=" class="btn btn-xs btn-info">Ver</a></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</div>
