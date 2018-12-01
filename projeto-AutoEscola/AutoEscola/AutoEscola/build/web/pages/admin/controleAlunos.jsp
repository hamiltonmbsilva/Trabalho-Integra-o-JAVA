<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="margin-top: 50px; margin-bottom: 50px; margin-left: 5px; margin-right: 5px;">
    <div>

        <table class="table table-striped table-bordered bg-light">
            <thead>
                <tr class="text-center">
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Data de Nascimento</th>
                    <th>Email</th>
                    <th>Matriculado</th>
                    <th colspan="4">Ações</th>
                </tr>
            </thead>

            <tbody  id="tabela" class="text-center">
            <c:if test="${requestScope.alunos.size() == 0}">
                    <tr>
                        <td colspan="4">  Não há Alunos Cadastrados </td>
                    </tr>
                </c:if>
                <c:forEach items="${requestScope.alunos}" var="a">
                    <tr>
                        <td>${a.matricula}</td>
                        <td>${a.nome}</td>
                        <td>${a.cpf}</td>
                        <td>${a.dataNascimentoToString()}</td>
                        <td>${a.email}</td>
                        
                        <c:if test="${a.matriculado}">
                            <td>SIM</td>
                        </c:if>
                        <c:if test="${!a.matriculado}">
                            <td>PRÉ MATRICULADO</td>
                        </c:if>
                      
                        <td><a href="control?ac=dadosAluno&id=${a.matricula}"> <button type="button" class="btn btn-primary">Dados</button> </a></td>
                        <td><a href="control?ac=matriculaPagamento&id=${a.matricula}"> <button type="button" class="btn btn-info">Matrícula e Pagamento</button> </a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<script>
    <%
        if (request.getAttribute("verifica") != null && ((boolean) request.getAttribute("verifica"))) {
    %>
            alert("<%= request.getAttribute("mensagem")%>");
    <%
        }
    %>
</script>