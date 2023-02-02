package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Especialidad;
import modeloDAO.EspecialidadDAO;

@WebServlet(name = "ControlEspecialidad", urlPatterns = {"/ControlEspecialidad"})
public class ControlEspecialidad extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valor = request.getParameter("accion");
        String pagina = "";
        Especialidad e;
        EspecialidadDAO ed;

        System.out.println("LLEGA");
        if (valor.equalsIgnoreCase("paginaAgregar")) {
            pagina = "VistaEspecialidad/agregar.jsp";
        } else if (valor.equalsIgnoreCase("paginaListar")) {
            pagina = "VistaEspecialidad/listar.jsp";
        } else if (valor.equalsIgnoreCase("Ingresar especialidad")) {
            String cod = request.getParameter("codigo");
            String nom = request.getParameter("nombre");
            e = new Especialidad(cod, nom);
            ed = new EspecialidadDAO();
            ed.agregar(e);
            pagina = "VistaEspecialidad/listar.jsp";
        } else if (valor.equalsIgnoreCase("EliminarEspecialidad")) {
            String cod = request.getParameter("codigo");
            ed = new EspecialidadDAO();
            ed.eliminar(cod);
            pagina = "VistaEspecialidad/listar.jsp";
        } else if (valor.equalsIgnoreCase("ModificarEspecialidad")) {
            String cod = request.getParameter("codigo");
            ed = new EspecialidadDAO();
            e = ed.listarUno(cod);
            System.out.println("EEEE " + e.getCodigo());
            request.setAttribute("espec", e);
            pagina = "VistaEspecialidad/editar.jsp";
        } else if (valor.equalsIgnoreCase("Modificar especialidad")) {
            String cod = request.getParameter("codigo");
            String nom = request.getParameter("nombre");
            e = new Especialidad(cod, nom);
            ed = new EspecialidadDAO();
            ed.editar(e);
            pagina = "VistaEspecialidad/listar.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
