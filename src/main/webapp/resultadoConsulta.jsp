<%-- 
    Document   : resultadoConsulta
    Created on : 17/10/2018, 23:04:50
    Author     : rbezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../../formatacao.css"/>
        <title>Pesquisa Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        
    </head>
    <body>
        <nav>
            <ul class="menu"></ul>
        </nav>
                <div class="col-12">
                    <br>
                    <h1 style="color: white">-------Pesquisa do Produto-------</h1>  
                    <div>
                        <br><br><br><br><br><br>
                        <div class="centralizarLogin">
                        <form method="post" action="${pageContext.request.contextPath}/produto/consulta">
                        <h1>Produto</h1>
                        <h2>Resultado</h2>
                        <div>
                            <p>ID <c:out value="${result.id}" /></p> 
                        </div>
                        </form>
                        </div>
                    </div>
                </div>
    </body>
</html>