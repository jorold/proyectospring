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
        <h1>Empleados Almacenados</h1>
        <a class="btn-outline-info" href="web15almacenarempleados.htm">Almacenar empleados session</a>
        <c:choose>
            <c:when test="${sessionScope.listaids != null}">
                <table class="table table-bordered">
                    <c:forEach items="${empleadossession}" var="emp">
                        <tr>
                            <td><c:out value="${emp.apellido}"/></td>
                            <td><c:out value="${emp.oficio}"/></td>
                            <td><c:out value="${emp.salario}"/></td>
                            <td>
                                <a class="btn-outline-danger" href="web15mostrarempleados.htm?eliminar=${emp.idEmpleado}">
                                   Eliminar de session
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1 class="text-danger">No existen empleados almacenados</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
