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
        <h1>MultiAction Controller</h1>
        <form method="POST" action="web16multiaction.htm?accion=operar">
            <input type="hidden" name="accion" value="operar"
            <label>Número 1: </label>
            <input type="text" name="numero1" required/><br/>
            <label>Número 2: </label>
            <input type="text" name="numero2" required/><br/>
            <button class="btn-outline-info" type="submit" name="tipooperacion" value="sumar">
                Sumar números
            </button>
            <button class="btn-outline-success" type="submit" name="tipooperacion" value="multiplicar">
                Multiplicar números
            </button>
        </form>
        <ul class="list-group">
            <li class="list-group-item">
                <a href="web16multiaction.htm?accion=alta">Action Alta</a>
            </li>
            <li class="list-group-item">
                <a href="web16multiaction.htm?accion=baja">Action Baja</a>
            </li>
        </ul>
        <h1 class="text-success"><c:out value="${mensaje}"/></h1>
    </body>
</html>
