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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Casa do Código</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script defer src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script defer src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <style>
        .invalid-feedback {
            display: inline-block;
        }
    </style>
</head>
<body>
<nav class="nav">
    <a class="nav-link" href="/">Home</a>
    <a class="nav-link" href="/produtos/form">Cadastrar Produtos</a>
    <a class="nav-link" href="/produtos">Listar Produtos</a>
</nav>
<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST" modelAttribute="produto"
           enctype="multipart/form-data" class="container">

    <div class="form-group">
        <label for="titulo">Título</label>
        <form:input path="titulo" name="titulo" class="form-control"/>
        <div class="invalid-feedback"><form:errors path="titulo"/></div>
    </div>

    <div class="form-group">
        <label for="descricao">Descrição</label>
        <form:textarea rows="10" cols="20" path="descricao" name="descricao" class="form-control"/>
        <div class="invalid-feedback"><form:errors path="descricao"/></div>
    </div>

    <div class="form-group">
        <label for="paginas">Páginas</label>
        <form:input path="paginas" name="paginas" class="form-control"/>
        <div class="invalid-feedback"><form:errors path="paginas"/></div>
    </div>

    <div class="form-group">
        <label for="dataLancamento">Data de Lançamento</label>
        <form:input path="dataLancamento" name="dataLancamento" placeholder="dd/mm/aaaa" class="form-control"/>
        <div class="invalid-feedback"><form:errors path="dataLancamento"/></div>
    </div>

    <div title="precos" class="form-group">
        <c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}
                    <form:input path="precos[${status.index}].valor"/>
                    <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" class="form-control"/>
                </label>
            </div>
        </c:forEach>
    </div>

    <div class="form-group">
        <label for="sumario">Sumário</label>
        <input type="file" id="sumario" name="sumario" class="form-control"/>
    </div>

    <input type="submit" id="cadastrar" name="cadastrar" value="Cadastrar" class="btn btn-primary">
</form:form>
</body>
</html>
