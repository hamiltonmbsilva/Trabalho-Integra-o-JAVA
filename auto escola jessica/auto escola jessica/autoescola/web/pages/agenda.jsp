<%-- 
    Document   : agenda
    Created on : Oct 2, 2018, 10:48:40 AM
    Author     : Jessica
--%>

<%@page import="model.DAO.AulaDAO"%>
<%@page import="model.Aula"%>
<%@page import="model.DAO.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<%@page import="java.util.List"%>
<div class="panel-body">
    <h3><i class="fa fa-angle-right"></i> Contrato</h3>
    <form action="BaseController?act=saveagenda" method="POST">        
        <div class="form-group">
            <label for="professor" >Professor:</label>
            <select id="professor" name="professor" class="form-control">
                <option value="">Selecione...</option>
                <%
                    List<Pessoa> pessoas = new PessoaDAO().getProfessores();
                    for (Pessoa p : pessoas) {
                        out.println("<option value='" + p.getId() + "'>" + p.getNome() + "</option>");
                    }
                %>                
            </select> 
        </div>
        <div class="form-group">
            <label for="aula" >Aula:</label>
            <select id="aula" name="aula" class="form-control">
                <option value="">Selecione...</option>
                <%
                    List<Aula> planos = new AulaDAO().All();
                    for (Aula p : planos) {
                        out.println("<option value='" + p.getId() + "'>" + p.getHora() + "</option>");
                    }
                %> 
            </select> 
        </div>
        <div class="form-group">
            <label for="disponivel" >
            <input id="disponivel" name="disponivel" class="checkbox-inline" type="checkbox"> Disponível</label>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-warning">Salvar</button>
        </div>
    </form> 
</div>
