<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Menu para qualquer usuario deslogado --%>
<c:if test="${sessionScope.user == null && sessionScope.admin == null && sessionScope.atendente == null && sessionScope.professor == null}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-around" id="navbarSupportedContent">
        <ul class="navbar-nav navbar-collapse justify-content-around">                        
            <li class="nav-item">
                <a class="nav-item" href="control">Home</a>
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Horário das Aulas
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=aulaTeorcaAluno">Teóricas</a>
                    <a class="dropdown-item" href="control?ac=aulaPraticaAluno">Práticas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Área do Aluno
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=matricula">Pré-Matrícula</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="control?ac=login">Login</a>
                </div>                     
            </li>
            
            
            <li class="nav-item">
                <a class="nav-item" href="#">Contato</a>
            </li>     
            

            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Administração
                </a> 
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=adminLogin">Atendente e Administrador</a>
                    <a class="dropdown-item" href="control?ac=professorLogin">Professores</a>
                </div>            
            </li>
            
        </ul>
    </div>
</nav>
</c:if>  

<%-- Menu Administrador Logado --%>
<c:if test="${sessionScope.user == null && sessionScope.admin != null && sessionScope.atendente == null && sessionScope.professor == null}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-around" id="navbarSupportedContent">
        <ul class="navbar-nav navbar-collapse justify-content-around">                        
            <li class="nav-item">
                <a class="nav-item" href="control">Home</a>
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Horário das Aulas
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=matricula">Teóricas</a>
                    <a class="dropdown-item" href="control?ac=matricula">Práticas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Área do Aluno
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=matricula">Pré-Matrícula</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="control?ac=login">Login</a>
                </div>                     
            </li>
            
            
            <li class="nav-item">
                <a class="nav-item" href="#">Contato</a>
            </li>     
            

            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Administração
                </a> 
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=adminLogin">Controle de Atendentes</a>
                    <a class="dropdown-item" href="control?ac=adminLogin">Controle de Professores</a>
                    <a class="dropdown-item" href="control?ac=adminLogin">Controle de Alunos</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="control?ac=logout">Logout</a>
                </div>            
            </li>
            
        </ul>
    </div>
</nav>
</c:if>  

<%-- Menu Atendente Logado --%>
<c:if test="${sessionScope.user == null && sessionScope.admin == null && sessionScope.atendente != null && sessionScope.professor == null || (sessionScope.atendente != null && sessionScope.user != null)}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-around" id="navbarSupportedContent">
        <ul class="navbar-nav navbar-collapse justify-content-around">                        
            <li class="nav-item">
                <a class="nav-item" href="control">Home</a>
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Horário das Aulas
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=aulaTeorcaAluno">Teóricas</a>
                    <a class="dropdown-item" href="control?ac=aulaPraticaAluno">Práticas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Área do Aluno
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=selecionaAluno">Marcação de Aulas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item">
                <a class="nav-item" href="#">Contato</a>
            </li>     
            

            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Administração
                </a> 
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=controleProfessores">Controle de Professores</a>
                    <a class="dropdown-item" href="control?ac=controleAlunos">Controle de Alunos</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="control?ac=logout">Logout</a>
                </div>            
            </li>
            
        </ul>
    </div>
</nav>
</c:if>  

<%-- Menu Aluno Logado --%>
<c:if test="${sessionScope.user != null && sessionScope.admin == null && sessionScope.atendente == null && sessionScope.professor == null}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-around" id="navbarSupportedContent">
        <ul class="navbar-nav navbar-collapse justify-content-around">                        
            <li class="nav-item">
                <a class="nav-item" href="control">Home</a>
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Horário das Aulas
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=aulaTeorcaAluno">Teóricas</a>
                    <a class="dropdown-item" href="control?ac=aulaPraticaAluno">Práticas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Área do Aluno
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=minhasAulasTeoricas">Minhas Aulas Teóricas</a>
                    <a class="dropdown-item" href="control?ac=minhasAulasPraticas">Minhas Aulas Praticas</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="control?ac=logout">Logout</a>
                </div>                     
            </li>
            
            
            <li class="nav-item">
                <a class="nav-item" href="#">Contato</a>
            </li>     
            

            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dados Pessoais
                </a>    
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=matricula">Alterar Informações Pessoais</a>
                    <a class="dropdown-item" href="control?ac=matricula">Alterar Login e Senha</a>
                </div>                
            </li>
            
        </ul>
    </div>
</nav>
</c:if> 

<%-- Menu Aluno Logado --%>
<c:if test="${sessionScope.user == null && sessionScope.admin == null && sessionScope.atendente == null && sessionScope.professor != null}">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-around" id="navbarSupportedContent">
        <ul class="navbar-nav navbar-collapse justify-content-around">                        
            <li class="nav-item">
                <a class="nav-item" href="control">Home</a>
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Horário das Aulas
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=aulaTeorcaAluno">Teóricas</a>
                    <a class="dropdown-item" href="control?ac=aulaPraticaAluno">Práticas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Área do Professor
                </a>                            
            
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=agendaAulasTeoricas">Agenda Aulas Teóricas</a>
                    <a class="dropdown-item" href="control?ac=agendaAulasPraticas">Agenda Aulas Praticas</a>
                </div>                     
            </li>
            
            
            <li class="nav-item">
                <a class="nav-item" href="#">Contato</a>
            </li>     
            

            <li class="nav-item dropdown">
                <a class="nav-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dados Pessoais
                </a>    
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="control?ac=matricula">Alterar Informações Pessoais</a>
                    <a class="dropdown-item" href="control?ac=matricula">Alterar Login e Senha</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="control?ac=logout">Logout</a>
                </div>                
            </li>
            
        </ul>
    </div>
</nav>
</c:if> 