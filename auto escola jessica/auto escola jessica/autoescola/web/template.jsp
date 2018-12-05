<%@page import="model.Matricula"%>
<%@page import="model.Pessoa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>DASHGUM - Bootstrap Admin Template</title>

        <!-- Bootstrap core CSS -->
        <link href="layout/assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="layout/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
        <link href="layout/assets/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet"/>

        <!-- Custom styles for this template -->
        <link href="layout/assets/css/style.css" rel="stylesheet">
        <link href="layout/assets/css/style-responsive.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <header class="header black-bg">
            <div class="sidebar-toggle-box">
                <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
            </div>
            <a href="index.html" class="logo"><b>AUTO ESCOLA XYZ</b></a>
        </header>

        <aside>
            <div id="sidebar" class="nav-collapse ">
                <ul class="sidebar-menu" id="nav-accordion">                    
                    <p class="centered"><a href="profile.html">
                            <img src="./layout/assets/img/MarioCart.jpg" class="img-circle" width="60"></a></p>
                            <% if (request.getSession().getAttribute("user") != null) {%>
                    <h5 class="centered">
                        <%
                            Matricula p = (Matricula) request.getSession().getAttribute("user");
                            out.print(p.getPessoaId().getNome());
                        %></h5>                        
                    <li class="mt">
                        <a href="BaseController?">
                            <i class="fa fa-dashboard"></i>
                            <span>Home</span>
                        </a>
                    </li>    
                    <%
                        if (p.getPessoaId().getTipoPessoaId().getId() != 3) {
                    %>
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-desktop"></i>
                            <span>Aluno</span>
                        </a>
                        <ul class="sub">                            
                            <li><a href="BaseController?act=listarAlunos">Alunos</a></li>
                            <li><a href="BaseController?act=pagamentos">Pagamentos</a></li>
                            <li><a href="BaseController?act=listarContratos">Contratos</a></li>
                        </ul>
                    </li>                    
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-cogs"></i>
                            <span>Sistema</span>
                        </a>
                        <ul class="sub">
                            <li class=""><a href="BaseController?act=listarPlanosPagamento">Planos de Pagamento</a></li>
                            <li><a href="BaseController?act=listarveiculos">Veiculos</a></li>                            
                            <li><a href="BaseController?act=agenda">Agenda</a></li>

                            <li><a href="BaseController?act=listaraulas">Aulas</a></li>
                        </ul>
                    </li>
                    <%} else {%>
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="fa fa-cogs"></i>
                            <span>Sistema</span>
                        </a>
                        <ul class="sub">
                            <li><a href="BaseController?act=listaraulas">Aulas</a></li>
                        </ul>
                    </li>
                    <%  }
                      } else {
                          out.print("");%>
                    <li class="sub-menu">
                        <a href="BaseController?act=cadastrar">
                            <i class="fa fa-desktop"></i>
                            <span>Cadastre-se</span>
                        </a>
                    </li>
                    <li class="sub-menu">
                        <a href="./pages/login.jsp">
                            <i class="fa fa-desktop"></i>
                            <span>Logar</span>
                        </a>
                    </li>
                    <%}%>
                </ul>
            </div>
        </aside>



        <section id="main-content">
            <section class="wrapper site-min-height">
                <c:if test="${param.page == null}">
                    <jsp:include page="pages/home.jsp" />
                </c:if>
                <c:if test="${param.page != null}">
                    <jsp:include page="pages/${param.page}.jsp" />
                </c:if>
            </section>
        </section>
        <footer class="site-footer">
            <div class="text-center">
                2014 - Alvarez.is
                <a href="calendar.html#" class="go-top">
                    <i class="fa fa-angle-up"></i>  
                </a>
            </div>
        </footer>


        <!-- js placed at the end of the document so the pages load faster -->

        <script src="layout/assets/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="layout/assets/js/jquery.js"></script>
        <script src="layout/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="layout/assets/js/fullcalendar/fullcalendar.min.js"></script>
        <script src="layout/assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="layout/assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="layout/assets/js/jquery.scrollTo.min.js"></script>
        <script src="layout/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="layout/assets/js/common-scripts.js"></script>

        <!--script for this page-->
        <script src="layout/assets/js/calendar-conf-events.js"></script>

        <script>

            $(function () {
                $("select.styled").customSelect();
            });

        </script>

    </body>
</html>

