<%-- 
    Document   : matricular
    Created on : Sep 30, 2018, 4:44:54 PM
    Author     : Jessica
--%>
<div>
    <h3><i class="fa fa-angle-right"></i> Cadastro</h3>
    <div class="panel-body">
        <form action="BaseController?act=savematricula" method="POST">
            <input type="hidden" name="idPessoa" value="<%=request.getAttribute("pessoa")%>">
            <div class="form-group">
                <label for="login">Login:</label>
                <input id="login" name="login" class="form-control" type="text"  maxlength="45" required>
            </div>
            <div class="form-group">
                <label for="senha">Senha:</label>
                <input id="senha" name="senha" class="form-control" type="password" maxlength="45" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input id="email" name="email" class="form-control" maxlength="200" type="email" required>
            </div>
            <span> Matrícula</span>
            <hr>
            <div class="form-group" style="display: none;">  
                <label>
                <input id="matricula" name="matricula" class="checkbox-inline" value="true" type="checkbox" checked>
                Pré-Matricula</label>
            </div>
            <div class="form-group" style="display: none;">                
                <label>
                <input id="psc" name="psc" class="checkbox-inline" value="true" type="checkbox" checked>
                Psicotécnico</label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-outline-warning">Cadastar</button>
            </div>
        </form>
    </div>
</div>

