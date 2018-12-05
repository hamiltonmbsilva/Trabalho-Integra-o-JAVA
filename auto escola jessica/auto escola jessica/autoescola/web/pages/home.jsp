<%@page import="model.DAO.MatriculaDAO"%>
<%@page import="model.Matricula"%>
<%@page import="model.DAO.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO.AgendaDAO"%>
<%@page import="model.Agenda"%>
<%@page import="java.util.List"%>
<div>
    <h3><i class="fa fa-angle-right"></i> Agenda de Aulas</h3>
    <div class="panel-body">
<!--        <div class="form-group">
            <a class="btn btn-outline-warning" href="BaseController?act=aula" >Novo Aula</a>
        </div>-->
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
                        <th>Vagas</th>
                        <th>Professor</th>
                    </tr>
                </thead>
                <% List<Agenda> lista = new AgendaDAO().getAulasDisponiveis();
                    if (lista.size() > 0) {
                        for (Agenda cont : lista) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                %>
                <tr>
                    <td><%= cont.getId()%></td>
                    <td><%= sdf.format(cont.getAulaId().getData())%></td>
                    <td><%= cont.getAulaId().getHora()%></td>
                    <td><%= cont.getAulaId().getTipoAulaId().getNome()%></td>
                    <td><%= cont.getDisponivel()%></td>
                    <td><%= cont.getProfessorId().getNome()%></td>
                </tr>
                <%}
                    }%>
            </table>
        </div>
    </div>
</div>