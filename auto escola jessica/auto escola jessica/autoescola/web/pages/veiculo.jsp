<%-- 
    Document   : veiculo
    Created on : Oct 2, 2018, 4:54:39 AM
    Author     : Jessica
--%>
<%@page import="model.DAO.TipoVeiculoDAO"%>
<%@page import="model.TipoVeiculo"%>
<%@page import="java.util.List"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Cadastro</h3>
    <div class="panel-body">
        <form action="BaseController?act=saveveiculo" method="POST">
            <div class="form-group">
                <label for="ano">Ano de Fabricação:</label>
                <input id="ano" name="ano" class="form-control" type="number" required>
            </div>
            <div class="form-group">
                <label for="placa">Placa do Veiculo:</label>
                <input id="placa" name="placa" class="form-control" type="text" maxlength="8" required>
            </div>
            <div class="form-group">
            <label for="tipo" >Titular do Contrato:</label>
            <select id="tipo" name="tipo" class="form-control">
                <option value="">Selecione...</option>
                <%
                    List<TipoVeiculo> pessoas = new TipoVeiculoDAO().All();
                    for (TipoVeiculo p : pessoas){
                        out.println("<option value='"+p.getId()+"'>"+p.getDescricao()+"</option>");
                    }
                %>                
            </select> 
        </div>
            <div class="form-group">
                <button type="submit" class="btn btn-outline-warning">Cadastar</button>
            </div>
        </form>
    </div>
</div>