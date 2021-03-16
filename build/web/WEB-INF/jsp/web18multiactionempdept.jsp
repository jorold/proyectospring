<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>SPRING page</title>
    </head>
    <body>
        <h1>MultiAction EmpDept</h1>
        <form method="post" action="web18multiactionempdept.htm">
            <!--<input type="hidden" name="accion" value="recuperarEmpleados"/>-->
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <td></td>
                        <th>Número</th>
                        <th>Nombre</th>
                        <th>Localidad</th>
                        <td></td>
                    </tr>
                </thead>
                <tbody>                
                    <c:forEach items="${departamentos}" var="dept">
                        <tr>
                            <td><input type="radio" name="iddepartamento" value="${dept.idDepartamento}"</td>
                            <td><c:out value="${dept.idDepartamento}"/></td>
                            <td><c:out value="${dept.nombre}"/></td>
                            <td><c:out value="${dept.localidad}"/></td> 
                            <td><a href="web18multiactionempdept.htm?accion=eliminarDepartamento&iddepartamento=${dept.idDepartamento}">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button class="btn-outline-info" name="accion" value="recuperarEmpleados" type="submit">Mostrar empleados</button>
            <button class="btn-outline-danger" name="accion" value="eliminarDepartamento" type="submit">Eliminar</button>
        </form>
        <hr/>
        <c:if test="${empleados != null}">
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
        </c:if>
    </body>
</html>
