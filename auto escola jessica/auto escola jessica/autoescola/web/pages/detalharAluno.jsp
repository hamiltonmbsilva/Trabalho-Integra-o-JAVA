<%-- 
    Document   : detalharAluno
    Created on : Sep 30, 2018, 10:33:12 PM
    Author     : Jessica
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DAO.TipoPessoaDAO"%>
<%@page import="model.TipoPessoa"%>
<%@page import="java.util.List"%>
<%@page import="model.DAO.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    Pessoa p = new Pessoa(id);
    Pessoa pessoa = new PessoaDAO().FindById(p);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
%>
<div>
    <h3><i class="fa fa-angle-right"></i> Atualizar Aluno</h3>
    <div class="panel-body">
        <form action="BaseController?act=updatepessoa" method="POST">
            <div class="form-group">
                <input type="hidden" name="id" value="<%= pessoa.getId()%>">
                <label for="nome">Nome Completo:</label>
                <input id="nome" name="nome" class="form-control" type="text" value="<%= pessoa.getNome()%>" required>
            </div>
            <div class="form-group">
                <label for="dt_nasc">Data de Nascimento:</label>
                <input id="dt_nasc" name="dt_nasc" class="form-control" value="<%=sdf.format(pessoa.getDtNascimento())%>" type="date" required>
            </div>
            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input id="cpf" name="cpf" class="form-control" value="<%= pessoa.getCpf()%>" type="text" required>
            </div>
            <div class="form-group">
                <label>Sexo:</label>
                <label class="radio-inline"><input type="radio" name="sexo" value="false" 
                                                   <% if (pessoa.getSexo() == false) {
                                                           out.print("checked");
                                                       }
                                                   %>>Masculino</label>
                <label class="radio-inline"><input type="radio" name="sexo" value="true"
                                                   <% if (pessoa.getSexo() == true) {
                                                           out.print("checked");
                                                       }
                                                   %>>Feminino</label>
            </div>            
            <div class="form-group">
                <label class="checkbox-inline"><input type="checkbox" name="ativo" value="true"
                                                      <%if (pessoa.getAtiva() == true) {
                                                              out.print("checked");
                                                          }
                                                      %>>Ativo</label>
            </div>
            <div class="form-group">
                <label for="titular" >Tipo de Usuário:</label>
                <select id="titular" name="titular" class="form-control">
                    <option value="">Selecione...</option>
                    <%
                        List<TipoPessoa> tipos = new TipoPessoaDAO().All();
                        for (TipoPessoa tipo : tipos) {
                            if (tipo.getId() != 1) {
                                if (pessoa.getTipoPessoaId().getId() == tipo.getId()) {
                                    out.println("<option value='" + tipo.getId() + "' selected>" + tipo.getNome() + "</option>");
                                } else {
                                    out.println("<option value='" + tipo.getId() + "'>" + tipo.getNome() + "</option>");
                                }

                            }
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