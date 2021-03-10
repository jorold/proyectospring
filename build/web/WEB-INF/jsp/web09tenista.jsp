<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tenis</h1>
        <h1>
            <c:out value="${tenista.nombre}"/>
        </h1><br/>
        <h2>
            <c:out value="${tenista.palmares}"/> títulos GRAND SLAM
        </h2><br/>
        <img src="${tenista.imagen}"/>
    </body>
</html>
