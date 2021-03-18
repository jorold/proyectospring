<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>SPRING PAGE</title>
    </head>
    <body>
        <h1>Paginar empleados</h1>
        <table class="table table-bordered">
        <thead>
            <tr>
                <th>Apellido</th>
                <th>Oficio</th>
                <th>Salario</th>
                <th>Departamento</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${empleados}" var="emp">
                <tr>
                    <td><c:out value="${emp.apellido}"/></td>
                    <td><c:out value="${emp.oficio}"/></td>
                    <td><c:out value="${emp.salario}"/></td>
                    <td><c:out value="${emp.departamento}"/></td>
            </tr>
            </c:forEach>            
        </tbody>
        </table>
            <c:set var="numeropagina" value="1"/>
            <c:forEach begin="0" end="${numeroregistros}" varStatus="loop" step="5">
                <c:set var="aux" value="${loop.index + 1}"/>
                <a href="web21paginarempleados.htm?posicion=${aux}">
                    <c:out value="${numeropagina}"/>
                </a>
            <c:set var="numeropagina" value="${numeropagina + 1}"/>
            </c:forEach>
    </body>
</html>
