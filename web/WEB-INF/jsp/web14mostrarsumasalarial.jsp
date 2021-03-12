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
        <h1>Suma salarial session</h1>
        <c:choose>
            <c:when test="${sessionScope.sumasalarial != null}">
                <h1 class="text-info">
                    La suma salarial es: <c:out value="${sessionScope.sumasalarial}"/>
                </h1>
            </c:when>
            <c:otherwise>
                <h1 class="text-danger">No existen salarios almacenados</h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
