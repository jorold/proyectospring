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
        <h1>Contador Session</h1>
        <form method="post">
            <button type="submint" name="incremento" value="1">
                Incrementar contador
            </button>
        </form>
        <h1 class="bg-info">Contador: <c:out value="${contador}"/></h1>
    </body>
</html>
