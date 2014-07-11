package Servlets;

import Entities.Usuario;
import Modelo.ControlDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AgregarUsuario", urlPatterns = {"/AgregarUsuario"})
public class AgregarUsuario extends HttpServlet {
    
    //Un metodo que recibe todas las peticiones a si sea GET y POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String URLerror;

        if (request.getParameter("Txt_Username").toString().length() > 0
                && request.getParameter("Txt_Password").toString().length() > 0
                && request.getParameter("Txt_Nombres").toString().length() > 0
                && request.getParameter("Txt_Apellidos").toString().length() > 0
                && request.getParameter("Txt_Email").toString().length() > 0
                && request.getParameter("Txt_Cel").toString().length() > 0
                && request.getParameter("Txt_CP").toString().length() > 0
                && request.getParameter("Txt_Domicilio").toString().length() > 0) {

            ControlDB oControlDB = new ControlDB();
            ControlDB conexion = new ControlDB();

            Usuario oUsuario = new Usuario();
          //request.getParameter --> Sirve para obtener los valores de las cajas de texto
            oUsuario.setUsername(request.getParameter("Txt_Username"));
            oUsuario.setPasword(request.getParameter("Txt_Password"));
            oUsuario.setNombres(request.getParameter("Txt_Nombres"));
            oUsuario.setApellidos(request.getParameter("Txt_Apellidos"));
            oUsuario.setEmail(request.getParameter("Txt_Email"));
            oUsuario.setTelefono(request.getParameter("Txt_Cel"));
            oUsuario.setCp(request.getParameter("Txt_CP"));
            oUsuario.setDomicilio(request.getParameter("Txt_Domicilio"));

            if (oControlDB.conectar(conexion)) {

                if (ControlDB.registrarUsuarios(oUsuario)) {
                    response.sendRedirect("http://localhost:8080/applicationMVC/register_User.jsp");
                }           
            }
    
        } else {
            URLerror = "http://localhost:8080/applicationMVC/error_msg.html?msg_error=faltan_parametros_por_llenar";
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



