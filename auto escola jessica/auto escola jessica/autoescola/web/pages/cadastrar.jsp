<%-- 
    Document   : cadastrar
    Created on : Sep 29, 2018, 2:51:30 PM
    Author     : Jessica
--%>
<div>
    <h3><i class="fa fa-angle-right"></i> Cadastro</h3>
    <div class="panel-body">
        <form action="BaseController?act=savepessoa" method="POST">
            <div class="form-group">
                <label for="nome">Nome Completo:</label>
                <input id="nome" name="nome" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label for="dt_nasc">Data de Nascimento:</label>
                <input id="dt_nasc" name="dt_nasc" class="form-control" type="date" required>
            </div>
            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input id="cpf" name="cpf" class="form-control" type="text" required>
            </div>
            <div class="form-group">
                <label>Sexo:</label>
                <label class="radio-inline"><input type="radio" name="sexo" value="false" checked>Masculino</label>
                <label class="radio-inline"><input type="radio" name="sexo" value="true">Feminino</label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-outline-warning">Cadastar</button>
            </div>
        </form>
    </div>
</div>