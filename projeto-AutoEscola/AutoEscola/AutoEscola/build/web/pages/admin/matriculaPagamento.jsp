<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container" style="margin-top: 50px; margin-bottom: 50px; width: 800px;">
    <div class="container">

        <h3>Situação da Matrícula</h3>
        <hr>
        <form action="control" method="POST">
            <input type="hidden" name="ac" value="savePagamento" />
            <div class="form-group">
                <label for="matricula">Matricula</label>
                <input id="matricula" class="form-control" name="matricula" type="text" readonly="true" value="${a.matricula}">
            </div>
            <div class="form-group">
                <label for="nome">Aluno</label>
                <input id="cidade" name="cidade" class="form-control" type="text" value="${a.nome}">
            </div>
            <div class="form-group">
                <label for="nome">Matriculado</label>
                <select class="form-control" name="matriculado" id="matriculado">   
                    <c:if test="${a.matriculado}">
                        <option value="${a.matriculado}" selected="">SIM</option>
                        <option value="false"> NÃO </option>
                    </c:if>
                    <c:if test="${!a.matriculado}">
                        <option value="${!a.matriculado}" selected=""> NÃO </option>
                        <option value="true"> SIM </option>
                    </c:if>    
                </select>
            </div>
            
            <br>
            <h3>Pagamento</h3>
            <hr>
            <div class="form-group">
                <label for="nome">Situação</label>
                <select class="form-control" name="situacao" id="situacao"> 
                    <option value="PAGO"> PAGO </option>
                    <option value="A PAGAR"> A PAGAR </option>
                </select>
            </div>
            <div class="form-group">
                <label for="qtdTeoricas">Pacote Aulas Teóricas</label>
                <select class="form-control" name="qtdTeoricas" id="qtdTeoricas">
                    <option value="15"> 15 Aulas </option>
                    <option value="20"> 20 Aulas </option>
                    <option value="25"> 25 Aulas </option>
                    <option value="30"> 30 Aulas </option>
                    <option value="35"> 35 Aulas </option>
                </select>
            </div>
            <div class="form-group">
                <label for="qtdPraticas">Pacote Aulas Práticas</label>
                <select class="form-control" name="qtdPraticas" id="qtdPraticas"> 
                    <option value="10"> 10 Aulas </option>
                    <option value="15"> 15 Aulas </option>
                    <option value="20"> 20 Aulas </option>
                    <option value="25"> 25 Aulas </option>
                </select>
            </div>
            <div class="form-group">
                <label for="nome">Valot Total a Pagar</label>
                <input id="valTotal" name="valTotal" class="form-control" type="number">
            </div>
            
            <div class="form-group">
                <label for="nome">Tipo Pagamento: &nbsp;&nbsp;&nbsp;&nbsp;</label>
                <input id="tipo" name="tipo" type="radio" value="true" checked="true" onclick="escondeDiv()">A Vista &nbsp;&nbsp;&nbsp;&nbsp;
                <input id="tipo" name="tipo" type="radio" value="false" onclick="mostraDiv()">Parcelado
            </div>
            <div id="divParcelas" hidden="true">
                <div class="form-group">
                    <label for="nome">Numero de Parcelas</label>
                    <input id="numParcelas" name="numParcelas" class="form-control" type="number" onchange="setaParcelas()">
                </div>
                <div class="form-group">
                    <label for="nome">Valor das Parcelas</label>
                    <input id="valParcelas" name="valParcelas" class="form-control" type="text" readonly="true">
                </div>
            </div>
            <div class="form-group">
                <label for="dt_pag">Data Pagamento:</label>
                <input id="dt_pag" class="form-control" name="dt_pag" type="date" value="${data}">
            </div>
            <div>
                <button class="btn btn-primary" type="submit"> Salvar</button>
            </div>
        </form>
    </div>
</div>
            
<script>
    
    function mostraDiv(){
        document.getElementById("divParcelas").hidden = false;
    }
    
    function escondeDiv(){
        document.getElementById("divParcelas").hidden = true;
    }
    
    function setaParcelas(){
        var value = document.getElementById("numParcelas").value;
        var total = document.getElementById("valTotal").value;
        if(value < 0){
            alert("Valor de Parcelas inválido!");
        }
        else if(value == 0){
            alert("Para 0 numero de parcelas, selecione a opção PAGAMENTO A VISTA.");
        }
        else if(total == 0 || total == null){
            alert("Valor Total Inválido!");
        }
        else{
            var parcelas = total / value;
            document.getElementById("valParcelas").value = parcelas.toFixed(2);
            document.getElementById("valParcelas");           
        }
    }
</script>

