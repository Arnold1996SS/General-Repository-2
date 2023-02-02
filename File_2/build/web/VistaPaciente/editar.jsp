<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar paciente</h1>
        <form action="ControlPaciente" method="post">
            <input type="hidden" name="codigo" value="${pac.getCodigo()}"><br>
            <label>Nombre</label>
            <input type="text" name="nombre" value="${pac.getNombre()}"><br>
            <label>Apellidos</label>
            <input type="text" name="apellido" value="${pac.getApellido()}"><br>
            <label>Edad</label>
            <input type="text" name="edad" value="${pac.getEdad()}"><br>
            <input type="submit" name="accion" value="Actualizar paciente">    
        </form>
    </body>
</html>
