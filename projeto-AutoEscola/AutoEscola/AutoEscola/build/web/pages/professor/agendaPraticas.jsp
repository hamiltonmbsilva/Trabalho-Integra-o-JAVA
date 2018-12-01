<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="margin-top: 50px; margin-bottom: 50px; width: 1000px;">
    <div class="container">

        <h3>Minhas Aulas Pr�ticas</h3>
        <hr>
        
        <table class="table table-striped bg-light">
            <thead>
                <tr>
                    <th>Data</th>
                    <th>Tema</th>
                    <th>Veiculo</th>
                    <th>Professor</th>
                </tr>
            </thead>

            <tbody  id="tabela">
            <c:if test="${requestScope.praticas.size() == 0}">
                    <tr>
                        <td colspan="4">  N�o h� Aulas Pr�ticas Cadastrados </td>
                    </tr>
                </c:if>
                <c:forEach items="${requestScope.praticas}" var="p">
                    <tr>
                        <td>${p.dataAulaToString()}</td>
                        <td>${p.tema}</td>
                        <td>${p.veiculo}</td>
                        <td>${p.professorId.nome}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>
