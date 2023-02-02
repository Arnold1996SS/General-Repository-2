<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingresar paciente</h1>
        <form action="ControlPaciente" method="post">
            <label>Código</label>
            <input type="text" name="codigo"><br>
            <label>Nombre</label>
            <input type="text" name="nombre"><br>
            <label>Apellidos</label>
            <input type="text" name="apellido"><br>
            <label>Edad</label>
            <input type="text" name="edad"><br>
            <input type="submit" name="accion" value="Ingresar paciente">    
        </form>
    </body>
</html>
