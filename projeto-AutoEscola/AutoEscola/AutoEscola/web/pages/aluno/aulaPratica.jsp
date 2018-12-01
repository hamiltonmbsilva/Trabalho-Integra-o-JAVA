<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="margin-top: 50px; margin-bottom: 50px; width: 1000px;">
    <div class="container">

        <table class="table table-striped bg-light">
            <thead>
                <tr>
                    <th>Data</th>
                    <th>Tema</th>
                    <th>Veiculo</th>
                    <th>Professor</th>
                    <th>Aluno</th>
                    <c:if test="${sessionScope.user != null}">
                        <th td colspan="4">Ações</th>
                    </c:if>
                </tr>
            </thead>

            <tbody  id="tabela">
            <c:if test="${requestScope.praticas.size() == 0}">
                    <tr>
                        <td colspan="4">  Não há Aulas Práticas Cadastrados </td>
                    </tr>
                </c:if>
                <c:forEach items="${requestScope.praticas}" var="p">
                    <tr>
                        <td>${p.dataAulaToString()}</td>
                        <td>${p.tema}</td>
                        <td>${p.veiculo}</td>
                        <td>${p.professorId.nome}</td>
                        
                        <c:if test="${p.alunoMatricula.nome != null}">
                            <td>${p.alunoMatricula.nome}</td>
                        </c:if>
                            <c:if test="${p.alunoMatricula.nome == null}">
                            <td>Disponível</td>
                        </c:if>
                          
                        <c:if test="${sessionScope.user != null}">
                            <td><a href="control?ac=participarPratica&id=${p.id}"> <button type="button" class="btn btn-warning">Participar</button> </a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>


