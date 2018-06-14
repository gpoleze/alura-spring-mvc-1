<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
    <style>
    </style>
</head>
<body>
<nav>
    <a href="/">Home</a>
    <a href="/produtos/form">Cadastrar Produtos</a>
    <a href="/produtos">Listar Produtos</a>
</nav>
<h1>Lista de Produtos</h1>

<div>${sucesso}</div>

<table>
    <thead>
    <tr>
        <th>Título</th>
        <th>Descrição</th>
        <th>Páginas</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${produtos}" var="produto">
        <tr>
            <td>
                <a href="${spring:mvcUrl('PC#detalhe').arg(0,produto.id).build()}">${produto.titulo}</a>
            </td>
            <td>${produto.descricao}</td>
            <td>${produto.paginas}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
