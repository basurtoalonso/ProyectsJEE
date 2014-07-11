package Servlets;

import Entities.Usuario;
import Modelo.ControlDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controllerUpdate extends HttpServlet {

    //Un metodo que recibe todas las peticiones a si sea GET y POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String URLerror;

        ControlDB oControlDB = new ControlDB();
        ControlDB conexion = new ControlDB();

        Usuario usu = new Usuario();

        usu.setId(Integer.parseInt(request.getParameter("id")));
        usu.setUsername(request.getParameter("username"));
        usu.setPasword(request.getParameter("password"));
        usu.setNombres(request.getParameter("nombres"));
        usu.setApellidos(request.getParameter("apellidos"));
        usu.setEmail(request.getParameter("email"));
        usu.setTelefono(request.getParameter("telefono"));
        usu.setCp(request.getParameter("cp"));
        usu.setDomicilio(request.getParameter("domicilio"));

        if (oControlDB.conectar(conexion)) {

            if (ControlDB.actualizarUsuario(usu)) {
                response.sendRedirect("http://localhost:8080/applicationMVC/Management_User.jsp");
            }
        } else {
            URLerror = "http://localhost:8080/applicationMVC/error_msg.html?msg_error=No_Se_Actualizo_El_Usuario";
            response.sendRedirect(URLerror);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
