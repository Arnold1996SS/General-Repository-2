<%-- 
    Document   : listar
    Created on : 27/05/2022, 09:29:07 PM
    Author     : Yuliana
--%>

<%@page import="modelo.Especialidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.EspecialidadDAO"%>
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
            EspecialidadDAO dao = new EspecialidadDAO();
            ArrayList<Especialidad> lis = dao.listarTodos();
            Especialidad e;
        %>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Acción</th>                
            </tr>            
            <%for(int i=0; i<lis.size(); i++){                                       
            %>
                <tr>
                    <td><%=lis.get(i).getCodigo()%></td>
                    <td><%=lis.get(i).getNombre()%></td>
                    <td>
                        <a href="ControlEspecialidad?accion=EliminarEspecialidad&codigo=<%=lis.get(i).getCodigo()%>">Eliminar</a>
                        <a href="ControlEspecialidad?accion=ModificarEspecialidad&codigo=<%=lis.get(i).getCodigo()%>">Modificar</a>
                    </td>                
                </tr>
            <%}%>
            
        </table>
    </body>
</html>
