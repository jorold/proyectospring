<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hospitales</h1>
        <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Hospital num</th>
                        <th>Nombre</th>
                        <th>Direccion</th>
                        <th>Teléfono</th>
                        <th>Número camas</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${hospital}" var="fila">
                        <tr>
                            <td>
                                <c:out value="${fila.idHospital}"/>
                            </td>
                            <td>
                                <c:out value="${fila.nombre}"/>
                            </td>
                            <td>
                                <c:out value="${fila.direccion}"/>
                            </td>
                            <td>
                                <c:out value="${fila.telefono}"/>
                            </td>
                            <td>
                                <c:out value="${fila.camas}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
    </body>
</html>
