<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="formatacao.css"/>
        <title>Inserir Produto</title>
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
        
        <main class="container">
            <div class="row">
                <div class="col-12">
                    <h1 style="color: white">-------Informações do Produto-------</h1>
                    <br>
                    <div>
                        <form method="post" action="${pageContext.request.contextPath}/produto/inclusao">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="nome">Nome</label>
                                <div class="col-sm-10">
                                    <input type="text" name="nome" id="nome" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="marca">Marca</label>
                                <div class="col-sm-10">
                                    <input type="text" name="marca" id="marca" />
                                </div>
                            </div>
                            <div class="form-group row">
                            <fieldset>
                                <label class="col-sm-2 col-form-label" for="categoria">Categoria</label>
                                <!--<c:forEach items="${categoria}" var="cat">
                                    <input type="checkbox" value="${cat.id}" name="cat" id="cat${cat.nome}" /> <label for="catA"><c:out value="${cat.nome}" /></label>
                                </c:forEach>-->
                                <div class="col-sm-12">
                                <input type="radio" value="1" name="cat" id="unissex" /> <label for="unissex">Unissex</label>
                                <input type="radio" value="2" name="cat" id="masculina" /> <label for="masculina">Masculina</label>
                                <input type="radio" value="3" name="cat" id="feminina" /> <label for="feminina">Feminina</label>
                                <input type="radio" value="4" name="cat" id="infantil" /> <label for="infantil">Infantil</label>
                                </div>
                            </fieldset>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="qtd">Quantidade</label>
                                <div class="col-sm-10">
                                    <input type="text" name="qtd" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="prcompra">Preço compra</label>
                                <div class="col-sm-10">
                                    <input type="text" name="prcompra" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="prvenda">Preço venda</label>
                                <div class="col-sm-10">
                                    <input type="text" name="prvenda" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="descricao">Descrição</label>
                                <div class="col-sm-10">
                                    <textarea style="width: 50%;" name="descricao"></textarea>
                                </div>
                            </div>
                            
                            <button type="submit">Salvar</button>
                            <button type="reset">Limpar</button>
                            <button type="reset" onClick="history.go(-1)">Voltar</button>
                                
                        </form>

                    </div>
                </div>
            </div>
        </main>
        
    </body>
</html>