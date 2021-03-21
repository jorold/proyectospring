<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/webhead.jsp"/>
        <title>Películas Store</title>
    </head>
    <body>
        <jsp:include page="../includes/webmenu.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Web de Películas</h1>
                    <c:if test="${peliculas != null}">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Cartel</th>
                                <th>Precio</th>
                                <th>Detalles</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${peliculas}" var="peli">
                            <tr>
                                <td class="align-middle"><c:out value="${peli.titulo}"/></td>
                                <td><img src="PELICULAS/CARTELES/${peli.foto}" alt=""/></td>
                                <td class="align-middle"><c:out value="${peli.precio}"/>€</td>
                                <td class="align-middle"><a class="btn-outline-success" href="webtiendapeliculas.htm?action=detalles&idpelicula=${peli.idPelicula}">Detalles</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                        <c:set var="numeropagina" value="1"/>
                        <c:forEach begin="0" end="${numeroregistros}" varStatus="loop" step="5">
                            <c:set var="aux" value="${loop.index + 1}"/>
                            <a href="webtiendapeliculas.htm?action=start&posicion=${aux}">
                                <c:out value="${numeropagina}"/>
                            </a>
                                <c:set var="numeropagina" value="${numeropagina + 1}"/>
                        </c:forEach>
                    </c:if>
                    <hr/>                    
                    <c:if test="${detalles != null}">
                    <h2 class="text-success">Detalles Película</h2>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Foto</th>
                                <th>Actores</th>
                                <th>Argumento</th>
                            </tr>
                        <tbody>
                            
                                <tr>
                                    <td><c:out value="${detalles.titulo}"/></td>
                                    <td><img src="PELICULAS/CARTELES/${detalles.foto}"/></td>
                                    <td><c:out value="${detalles.actores}"/></td>
                                    <td><c:out value="${detalles.argumento}"/></td>
                                </tr>
                        </tbody>
                        </thead>
                    </table>
                        <a class="btn-outline-info" href="#">Comprar</a>
                        <a class="btn-outline-success" href="webtiendapeliculas.htm?action=start">Volver</a>
                    </c:if>
                </div>
            </main>
        </section>
        <jsp:include page="../includes/webfooter.jsp"/>
    </body>
</html>
