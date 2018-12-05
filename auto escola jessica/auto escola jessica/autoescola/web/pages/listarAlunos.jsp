<%-- 
    Document   : listarAlunos
    Created on : Sep 30, 2018, 8:06:19 PM
    Author     : Jessica
--%>
<%@page import="model.DAO.ContratoDAO"%>
<%@page import="model.Contrato"%>
<%@page import="java.util.List"%>
<%@page import="model.Matricula"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Alunos</h3>
    <div class="panel-body">
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
                        <th>Nome</th>
                        <th>Matrícula</th>
                        <th>Contrato</th>
                        <th>Ativa</th>
                        <th>Opções</th>
                    </tr>
                </thead>

                <% List<Matricula> lista = (List<Matricula>) request.getAttribute("alunos");
                    for (Matricula mat : lista) {
                        List<Contrato> c = new ContratoDAO().FindByPersonId(mat.getPessoaId());
                        int contrato = 0;
                        if (!c.isEmpty()) {
                            contrato = c.get(0).getId();
                        }
                %>
                <tr>
                    <td><%= mat.getPessoaId().getNome()%></td>
                    <td><%= mat.getId()%></td>
                    <td><%= contrato%></td>
                    <td><%= mat.getPessoaId().getAtiva()%></td>
                    <td><a id="ver" role="button" href="BaseController?act=detalharaluno&id=<%= mat.getPessoaId().getId()%>"
                           class="btn btn-xs btn-warning">Editar</a></td>
                </tr>
                <%}%> 
            </table>
        </div>
    </div>
</div>
