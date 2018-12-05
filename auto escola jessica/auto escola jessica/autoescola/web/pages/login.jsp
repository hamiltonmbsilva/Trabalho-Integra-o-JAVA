<%-- 
    Document   : login
    Created on : Sep 29, 2018, 2:45:31 PM
    Author     : Jessica
--%>

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
        <link href="../layout/assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../layout/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="../layout/assets/css/style.css" rel="stylesheet">
        <link href="../layout/assets/css/style-responsive.css" rel="stylesheet">
    </head>

    <body>
        <div id="login-page">
            <div class="container">
                <form class="form-login" method="POST" action="../BaseController?act=logar">
                    <h2 class="form-login-heading">Logar-se</h2>
                    <div class="login-wrap">
                        <input type="text" id="login" name="login" class="form-control" placeholder="Login" autofocus>
                        <br>
                        <input id="senha" name="senha" type="password" class="form-control" placeholder="Senha">
                        <label class="checkbox">
                            <span class="pull-right">
                                <a data-toggle="modal" href="login.html#myModal"> Esqueceu a senha?</a>
                            </span>
                        </label>
                        <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i> IR</button>
                        <hr><!--
                        <div class="login-social-link centered">
                            <p>ou você pode se cadastrar antes</p>
                            <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
                            <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
                        </div>-->
                        <div class="registration">
                            Não possui um cadastro?<br/>
                            <a class="" href="#">
                                Criar uma Conta
                            </a>
                        </div>		
                    </div>		
                    <!-- Modal -->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Esqueceu a senha ?</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Digite seu email</p>
                                    <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                                    <button class="btn btn-theme" type="button">Enviar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- modal -->		
                </form>   	
            </div>
        </div>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="../layout/assets/js/jquery.js"></script>
        <script src="../layout/assets/js/bootstrap.min.js"></script>

        <!--BACKSTRETCH-->
        <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
        <script type="text/javascript" src="../layout/assets/js/jquery.backstretch.min.js"></script>
        <script>
            $.backstretch("../layout/assets/img/login-bg.jpg", {speed: 500});
        </script>


    </body>
</html>


