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
        <h1>Enfermos</h1>
        <form method="post">
            <label>Introducir inscripcion </label>
            <input type="text" name="num" required/>
            <button type="submit">Eliminar</button>
        </form>
        <hr/>
        <table class="table table-bordered">
         <thead>
                    <tr>
                        <th>Inscripcion</th>
                        <th>Apellido</th>
                        <th>Direccion</th>
                        <th>Sexo</th>
                    </tr>
        </thead>
            <tbody>
                <c:forEach items="${enfermos}" var="enf">
                    <tr>
                        <td>
                            <c:out value="${enf.inscripcion}"/>
                        </td>
                        <td>
                            <c:out value="${enf.apellido}"/>
                        </td>
                        <td>
                            <c:out value="${enf.direccion}"/>
                        </td>
                        <td>
                            <c:out value="${enf.sexo}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
