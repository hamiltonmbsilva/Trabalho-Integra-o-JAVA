<%-- 
    Document   : planopagamento
    Created on : Oct 1, 2018, 2:37:00 AM
    Author     : Jessica
--%>
<h3><i class="fa fa-angle-right"></i> Planos de Pagamento</h3>
<div class="panel-body">
    <form method="POST" action="BaseController?act=saveplanopagamento">
        <div class="form-group">
            <label for="qdt_parcelas">Número Total de Parcelas:</label>
            <input id="qdt_parcelas" name="qdt_parcelas" class="form-control" type="number" required>
        </div>
        <div class="form-group">
            <label for="total">Valor Total do Plano:</label>
            <input id="total" name="total" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="nome">Nome para o Plano:</label>
            <input id="nome" name="nome" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="vencimento">Vencimento:</label>
            <input id="vencimento" name="vencimento" class="form-control" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-warning" >Salvar</button>
        </div>
    </form>
</div>

