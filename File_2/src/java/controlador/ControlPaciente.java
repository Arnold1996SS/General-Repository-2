package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Paciente;
import modeloDAO.PacienteDAO;

@WebServlet(name = "ControlPaciente", urlPatterns = {"/ControlPaciente"})
public class ControlPaciente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String valor = request.getParameter("accion");
        String pagina = "";
        Paciente p;
        PacienteDAO pd = new PacienteDAO();
        
        if(valor.equalsIgnoreCase("paginaAgregar")){
            pagina = "VistaPaciente/agregar.jsp";
        }
        else if(valor.equalsIgnoreCase("paginaListar")){
            pagina = "VistaPaciente/listar.jsp";
        }
        else if(valor.equalsIgnoreCase("Ingresar paciente")){
            System.out.println("HHHHHHHH");
            String cod, nom, ape;
            int eda;
            cod = request.getParameter("codigo");
            nom = request.getParameter("nombre");
            ape = request.getParameter("apellido");
            eda = Integer.parseInt(request.getParameter("edad"));
            p = new Paciente(cod, nom, ape, eda);
            pd.agregar(p);
            pagina = "VistaPaciente/listar.jsp";
        }
        else if(valor.equalsIgnoreCase("EliminarPaciente")){
            String cod = request.getParameter("codigo");
            pd.eliminar(cod);
            pagina = "VistaPaciente/listar.jsp";
        }
        else if(valor.equalsIgnoreCase("ModificarPaciente")){
            String cod = request.getParameter("codigo");
            p=new Paciente();
            p=pd.listarUno(cod);
            request.setAttribute("pac", p);
            pagina = "VistaPaciente/editar.jsp";
        }
        else if(valor.equalsIgnoreCase("Actualizar paciente")){
            String cod, nom, ape;
            int eda;
            cod = request.getParameter("codigo");
            nom = request.getParameter("nombre");
            ape = request.getParameter("apellido");
            eda = Integer.parseInt(request.getParameter("edad"));
            p = new Paciente(cod, nom, ape, eda);
            pd.editar(p);
            pagina = "VistaPaciente/listar.jsp";
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
