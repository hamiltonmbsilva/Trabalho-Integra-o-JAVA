<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->

<div class="container" style="margin-top: 100px; margin-bottom: 50px; width: 500px; height: 400px">
    <div class="container">
        
        <div class="alert alert-danger" id="alerta">
            <strong>Atenção!</strong> Somente conseguirão logar os alunos devidamente matrículados.
        </div>

        <form class="form-control" action="control" method="POST">
            <input type="hidden" name="ac" id="tipoPessoa"/>
            <h2 class="form-login-heading">Entrar</h2>
            <div class="login-wrap">

                <div class="alert alert-danger" style="display: none">
                    <strong>Danger!</strong> Login ou Senha Incorretos!
                </div>

                <br>
                <input type="text" name="login" class="form-control" placeholder="User ID" autofocus>
                <br>
                <input type="password" name="senha" class="form-control" placeholder="Password">
                <br>
                <label class="checkbox">
                    <span class="pull-right">
                        <a data-toggle="modal" href="login.html#myModal"> Esqueceu a senha?</a>

                    </span>
                </label>
                <br>
                <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i> Entrar</button>
                <hr>

            </div>

        </form>	  	

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

    
    <%
        if(request.getAttribute("access") == null){   
        %>
            document.getElementById("tipoPessoa").value = 'validaLogin';
        <%
    }
    else{
        %>
            document.getElementById("tipoPessoa").value = 'validaLoginAdmin';
            document.getElementById("alerta").hidden = true
        <%
    }
    %>
    
    $(function () {
        $('select.styled').customSelect();
    });

</script>

