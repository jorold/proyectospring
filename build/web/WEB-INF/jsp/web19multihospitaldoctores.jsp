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
        <h1>Multi Hospital Doctores</h1>
        <form method="post" action="web19multihospitaldoctores.htm">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th></th>
                    <th>Hospital número</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Camas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hospitales}" var="hosp">
                <tr>
                    <td><input type="radio" name="idhospital" value="${hosp.idHospital}"/></td>
                    <td><c:out value="${hosp.idHospital}"/></td>
                    <td><c:out value="${hosp.nombre}"/></td>
                    <td><c:out value="${hosp.direccion}"/></td>
                    <td><c:out value="${hosp.telefono}"/></td>
                    <td><c:out value="${hosp.camas}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
            <button class="btn-outline-info" name="accion" value="recuperarDoctores" type="submit">Mostrar doctores</button>            
        </form><br/>
        <c:if test="${doctores != null}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Doctor número</th>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctores}" var="doc">
                <tr>
                    <td><c:out value="${doc.idDoctor}"/></td>
                    <td><c:out value="${doc.apellido}"/></td>
                    <td><c:out value="${doc.especialidad}"/></td>
                    <td><c:out value="${doc.salario}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
    </body>
</html>
