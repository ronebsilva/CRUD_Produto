<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Produto</h1>
        <h2>Resultado</h2>
        <div>
            <p>Nome: <c:out value="${prod.nome}" /></p> 
            <p>Marca: <c:out value="${prod.marca}" /></p> 
            <p>Categoria:</p>
            <c:if test="${prod.categorias != null}">
                <ul>
                    <c:forEach items="${prod.categorias}" var="cat">
                        <li><c:out value="${cat}" /></li>
                    </c:forEach>
                </ul>
            </c:if>
            <p>Quantidade: <c:out value="${prod.quantidade}" /></p>
            <p>Preço compra: <fmt:formatNumber value="${prod.precoCompra}" type="currency" /></p>
            <p>Preço venda: <fmt:formatNumber value="${prod.precoVenda}" type="currency" /></p> 
            <p>Descrição: <c:out value="${prod.descricao}" /></p>
        </div>
    </body>
</html>