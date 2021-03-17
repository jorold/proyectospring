<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>SPRING Page</title>
    </head>
    <body>
        <h1>Paginar Departamentos</h1>
        <dl class="list-group">
            <dt class="list-group-item">Número: <c:out value="${departamento.idDepartamento}"/></dt>
            <dd class="list-group-item">Nombre: <c:out value="${departamento.nombre}"/></dd>
            <dd class="list-group-item">Localidad: <c:out value="${departamento.localidad}"/></dd>
        </dl>
        <hr/>
        <a href="web20paginardepartamentos.htm?posicion=1">Primero</a>
        <a href="web20paginardepartamentos.htm?posicion=${siguiente}">Siguiente</a>
        <a href="web20paginardepartamentos.htm?posicion=${anterior}">Anterior</a>
        <a href="web20paginardepartamentos.htm?posicion=${ultimo}">Último</a>
    </body>
</html>
