<div class="container" style="margin-top: 50px; margin-bottom: 50px; width: 800px;">
    <div class="container">

        <h3>Dados Pessoais</h3>
        <hr>
        <form action="control" method="POST">
            <input type="hidden" name="ac" value="gravarUser" />
           
            <div class="form-group">
                <label for="nome">Nome Completo:</label>
                <input id="nome" name="nome" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input id="cpf" name="cpf" class="form-control" type="text" onchange="pegarCpf()">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input id="email" name="email" class="form-control" type="email">
            </div>
            <div class="form-group">
                <label for="dt_nasc">Data Nascimento:</label>
                <input id="dt_nasc" class="form-control" name="dt_nasc" type="date">
            </div>
            
            <br>
            <h3>Endereço</h3>
            <hr>
            <div class="form-group">
                <label for="nome">Logradouro:</label>
                <input id="logradouro" name="logradouro" class="form-control" type="text" placeholder="Rua XXX ou avenida XXX">
            </div>
            <div class="form-group">
                <label for="nome">Numero:</label>
                <input id="numero" name="numero" class="form-control" type="number">
            </div>
            <div class="form-group">
                <label for="nome">Complemento:</label>
                <input id="complemento" name="complemento" class="form-control" type="text" placeholder="Apto XXX ou casa XX">
            </div>
            <div class="form-group">
                <label for="nome">Bairro:</label>
                <input id="bairro" name="bairro" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="nome">Cidade:</label>
                <input id="cidade" name="cidade" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="nome">Estado:</label>
                <select class="form-control" name="estado" id="estado">
                    <option value="AC"> AC </option>
                    <option value="AL"> AL </option>
                    <option value="AP"> AP </option>
                    <option value="AM"> AM </option>
                    <option value="BA"> BA </option>
                    <option value="CE"> CE </option>
                    <option value="DE"> DF </option>
                    <option value="ES"> ES </option>
                    <option value="GO"> GO </option>
                    <option value="MA"> MA </option>
                    <option value="MT"> MT </option>
                    <option value="MS"> MS </option>
                    <option value="MG"> MG </option>
                    <option value="PA"> PA </option>
                    <option value="PB"> PB </option>
                    <option value="PR"> PR </option>
                    <option value="PE"> PE </option>
                    <option value="PI"> PI </option>
                    <option value="RJ"> RJ </option>
                    <option value="RN"> RN </option>
                    <option value="RS"> RS </option>
                    <option value="RO"> RO </option>
                    <option value="RR"> RR </option>
                    <option value="SC"> SC </option>
                    <option value="SP"> SP </option>
                    <option value="SE"> SE </option>
                    <option value="TO"> TO </option>
                </select>
            </div>
            
            <br>
            <div class="alert alert-danger">
                <strong>Atenção!</strong> Você somente conseguirá logar no sistema depois de estar devidamente matrículado.
            </div>
            <h3>Login</h3>
            <div class="form-group">
                <label for="cpf">Login:</label>
                <input id="login" name="login" class="form-control" type="text" minlength="8" maxlength="25" placeholder="Digite o Login">
            </div>
            <div class="form-group">
                <label for="cpf">Senha:</label>
                <input id="senha" name="senha" class="form-control" type="password" minlength="10" maxlength="25" placeholder="Digite a Senha">
            </div>
            <div>
                <button class="btn btn-primary" type="submit"> Salvar</button>
            </div>
        </form>
    </div>
</div>

<script>
    
    function pegarCpf(){
        var cpf = document.getElementById("cpf").value;
        validarCPF(cpf);
    }
    
    function validarCPF(cpf) {	
	cpf = cpf.replace(/[^\d]+/g,'');	
	if(cpf == ''){
            document.getElementById("cpf").value = '';
            return alert("CPF inválido!");
        }	
	// Elimina CPFs invalidos conhecidos	
	if (cpf.length != 11 || 
		cpf == "00000000000" || 
		cpf == "11111111111" || 
		cpf == "22222222222" || 
		cpf == "33333333333" || 
		cpf == "44444444444" || 
		cpf == "55555555555" || 
		cpf == "66666666666" || 
		cpf == "77777777777" || 
		cpf == "88888888888" || 
		cpf == "99999999999"){
                        document.getElementById("cpf").value = '';
			return alert("CPF inválido!");
                    }
	// Valida 1o digito	
	add = 0;	
	for (i=0; i < 9; i ++)		
		add += parseInt(cpf.charAt(i)) * (10 - i);	
		rev = 11 - (add % 11);	
		if (rev == 10 || rev == 11)		
			rev = 0;	
		if (rev != parseInt(cpf.charAt(9))){
                        document.getElementById("cpf").value = '';
			return alert("CPF inválido!");		
                    }
	// Valida 2o digito	
	add = 0;	
	for (i = 0; i < 10; i ++)		
		add += parseInt(cpf.charAt(i)) * (11 - i);	
	rev = 11 - (add % 11);	
	if (rev == 10 || rev == 11)	
		rev = 0;	
	if (rev != parseInt(cpf.charAt(10))){
                document.getElementById("cpf").value = '';
		return alert("CPF inválido!");		
            }
	return true;   
}
    
</script>
