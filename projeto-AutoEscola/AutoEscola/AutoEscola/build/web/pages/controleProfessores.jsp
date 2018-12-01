<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-top: 50px; margin-bottom: 50px; width: 1000px;">
    <div class="container">

        <table class="table table-striped bg-light">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th td colspan="4">Ações</th>
                </tr>
            </thead>

            <tbody  id="tabela">
                <c:if test="${requestScope.professores.size() == 0}">
                    <tr>
                        <td colspan="4">  Não há Professores Cadastrados </td>
                    </tr>
                </c:if>
                <c:forEach items="${requestScope.professores}" var="m">
                    <tr>
                        <td>${m.nome}</td>
                        <td>${m.email}</td>
                        <td><a href="control?ac=alteraProfessor"> <button type="button" class="btn btn-warning">Alterar</button> </a></td>
                        <td><a href="control?ac=deletaProfessor"> <button type="button" class="btn btn-danger">Deletar</button> </a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>
