<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar especialidad</h1>
        <form action="ControlEspecialidad" method="post">
            <input type="hidden" name="codigo" value="${espec.getCodigo()}"><br>
            <label>Nombre</label>
            <input type="text" name="nombre" value="${espec.getNombre()}"><br>
            <input type="submit" name="accion" value="Modificar especialidad">    
        </form>
    </body>
</html>
