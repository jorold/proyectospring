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
        <h1>Almacenar empleados session</h1>
        <a class="btn-outline-info" href="web15mostrarempleados.htm">Mostar empleados session</a>
        <c:if test="${almacenados != null}">
            <h1 class="text-info">Empleados almacenados: <c:out value="${almacenados}"/></h1>
        </c:if>
        <ul class="list-group">
            <c:forEach items="${empleados}" var="empleado">
                <li class="list-group-item">
                    <c:out value="${empleado.apellido}"/>
                    <a class="btn-outline-info" href="web15almacenarempleados.htm?id=${empleado.idEmpleado}">
                        Almacenar empleado
                    </a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
