
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingresar especialidad</h1>
        <form action="ControlEspecialidad" method="post">
            <label>Código</label>
            <input type="text" name="codigo"><br>
            <label>Nombre</label>
            <input type="text" name="nombre"><br>
            <input type="submit" name="accion" value="Ingresar especialidad">    
        </form>
    </body>
</html>
