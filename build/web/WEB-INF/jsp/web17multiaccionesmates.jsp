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
        <h1>MultiAction Mates</h1>
        <form method="POST" action="web17multiaccionesmates.htm">
            <input type="hidden" name="accion" value="operar"
            <label>Introducir número </label>
            <input type="text" name="numero" required/><br/>            
            <button class="btn-outline-info" type="submit" name="operacion" value="tablamultiplicar">
                Tabla multiplicar
            </button>
            <button class="btn-outline-success" type="submit" name="operacion" value="numerospares">
                Números pares
            </button>
        </form>
        <hr/>
        <c:if test="${numeros != null}">
            <table class="table">
            <c:forEach items="${numeros}" var="num">
            <tr>
                <td>
                    <c:out value="${num}"/>
                </td>
            </tr>
            </c:forEach>
            </table>
        </c:if>
    </body>
</html>
