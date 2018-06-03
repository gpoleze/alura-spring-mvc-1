<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gabriel
  Date: 2018-04-22
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Casa do Código</title>
</head>
<body>
    <nav>
        <a href="/">Home</a>
        <a href="/produtos/form">Cadastrar Produtos</a>
        <a href="/produtos">Listar Produtos</a>
    </nav>
<form action="/produtos" method="POST">
    <div>
        <label for="titulo">Título</label>
        <input type="text" id="titulo" name="titulo">
    </div>
    <div>
        <label for="descricao">Descrição</label>
        <textarea rows="10" cols="20" id="descricao" name="descricao"></textarea>
    </div>
    <div>
        <label for="paginas">Páginas</label>
        <input type="text" id="paginas" name="paginas">
    </div>

    <div title="precos">
        <c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
            <div>
                <label >${tipoPreco}
                    <input type="text" name="precos[${status.index}].valor">
                    <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}">
                </label>
            </div>
        </c:forEach>
    </div>

    <input type="submit" id="cadastrar" name="cadastrar" value="Cadastrar">
    </div>
</form>
</body>
</html>
