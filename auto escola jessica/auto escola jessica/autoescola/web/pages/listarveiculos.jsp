<%-- 
    Document   : listarveiculos
    Created on : Oct 2, 2018, 5:14:41 AM
    Author     : Jessica
--%>

<%@page import="model.DAO.VeiculoDAO"%>
<%@page import="model.Veiculo"%>
<%@page import="model.DAO.TipoVeiculoDAO"%>
<%@page import="model.TipoVeiculo"%>
<%@page import="java.util.List"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Veiculos</h3>
    <div class="panel-body">
        <div class="form-group">
            <a class="btn btn-outline-warning" href="BaseController?act=veiculo" >Novo Veiculo</a>
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
                        <th>Ano do veiculo</th>
                        <th>Placa</th>
                        <th>Tipo de veiculo</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <% List<Veiculo> lista = new VeiculoDAO().All();
                    for (Veiculo cont : lista) {%>
                <tr>
                    <td><%= cont.getId()%></td>
                    <td><%= cont.getAno()%></td>
                    <td><%= cont.getPlaca()%></td>
                    <td><%= cont.getTipoVeiculoId().getDescricao()%></td>
                    <td><a href="BaseController?act=detalharveiculo&id=<%=cont.getId()%>" class="btn btn-xs btn-warning">Editar</a></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</div>

