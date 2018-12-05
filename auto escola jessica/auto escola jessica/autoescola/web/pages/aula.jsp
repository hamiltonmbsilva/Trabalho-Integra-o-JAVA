<%-- 
    Document   : aula
    Created on : Oct 2, 2018, 5:48:25 AM
    Author     : Jessica
--%>

<%@page import="model.DAO.VeiculoDAO"%>
<%@page import="model.Veiculo"%>
<%@page import="model.DAO.TipoAulaDAO"%>
<%@page import="model.TipoAula"%>
<%@page import="model.TipoAula"%>
<%@page import="model.DAO.TipoVeiculoDAO"%>
<%@page import="model.TipoVeiculo"%>
<%@page import="java.util.List"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Aula</h3>
    <div class="panel-body">
        <form action="BaseController?act=saveaula" method="POST">
            <div class="form-group">
                <label for="data">Data em que será ministrada a aula:</label>
                <input id="data" name="data" class="form-control" type="date" required>
            </div>
            <div class="form-group">
                <label for="hora">Hora:</label>
                <input id="hora" name="hora" class="form-control" type="text" maxlength="5" required>
            </div>
            <div class="form-group">
                <label for="veiculo" >Veiculo:</label>
                <select id="veiculo" name="veiculo" class="form-control">
                    <option value="-1">Não Possui</option>
                    <%
                        List<Veiculo> veiculos = new VeiculoDAO().All();
                        for (Veiculo p : veiculos) {
                            out.println("<option value='" + p.getId() + "'>" + p.getTipoVeiculoId().getDescricao()+
                                        "- Placa:"+p.getPlaca() + "</option>");
                        }
                    %>                
                </select> 
            </div>
            <div class="form-group">
                <label for="aula" >Modalidade da Aula:</label>
                <select id="aula" name="aula" class="form-control">
                    <option value="">Selecione...</option>
                    <%
                        List<TipoAula> aulas = new TipoAulaDAO().All();
                        for (TipoAula p : aulas) {
                            out.println("<option value='" + p.getId() + "'>" + p.getNome() + "</option>");
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