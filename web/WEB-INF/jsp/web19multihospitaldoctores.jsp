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
            <label>Introducir incremento</label>
            <input type="text" name="incremento"/>
            <button class="btn-outline-success" name="accion" value="incrementarSalarios" type="submit">Incrementar salario</button>
            <h2 class="text-success">Para incrementar salarios elegir hospital, introducir incremento y pulsar botón incrementar.</h2>
        </form><br/>        
        <c:if test="${doctores != null}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Doctor número</th>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctores}" var="doc">
                <tr>                    
                    <td><c:out value="${doc.idDoctor}"/></td>
                    <td><c:out value="${doc.apellido}"/></td>
                    <td><c:out value="${doc.especialidad}"/></td>
                    <td><c:out value="${doc.salario}"/></td>
                    <td><a href="web19multihospitaldoctores.htm?accion=eliminarDoctor&iddoctor=${doc.idDoctor}&idhospital=${doc.idHospital}" class="btn-outline-danger">Eliminar</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
    </body>
</html>
