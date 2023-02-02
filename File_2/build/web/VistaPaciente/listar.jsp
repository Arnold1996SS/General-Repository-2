<%@page import="modelo.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.PacienteDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar pacientes</h1>
        <%            
            PacienteDAO dao = new PacienteDAO();
            ArrayList<Paciente> lis = dao.listarTodos();
            System.out.println("Cantidad "+lis.size());
            Paciente p;
        %>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Edad</th>
                <th>Acción</th>                
            </tr>            
            <%for(int i=0; i<lis.size(); i++){                                       
            %>
                <tr>
                    <td><%=lis.get(i).getCodigo()%></td>
                    <td><%=lis.get(i).getNombre()%></td>
                    <td><%=lis.get(i).getApellido()%></td>
                    <td><%=lis.get(i).getEdad()%></td>
                    <td>
                        <a href="ControlPaciente?accion=EliminarPaciente&codigo=<%=lis.get(i).getCodigo()%>">Eliminar</a>
                        <a href="ControlPaciente?accion=ModificarPaciente&codigo=<%=lis.get(i).getCodigo()%>">Modificar</a>
                    </td>                
                </tr>
            <%}%>
            
        </table>
    </body>
</html>
