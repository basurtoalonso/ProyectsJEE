package Modelo;

import Entities.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Manejo de operaciones con la base de datos relacional (Clase de logica de negocio)
public class ControlDB {

    private static Connection con = null;
    private static String lastError = null;
    private static PreparedStatement ps = null;
    private static String host = "localhost";
    private static String bd = "bdusuario";
    private static String user = "root";
    private static String password = "1714";
    private static String server = "jdbc:mysql://" + host + "/" + bd;

    public String getLastError() {
        return lastError;
    }

    public boolean conectar(ControlDB conexion) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(server, user, password);
            return true;

        } catch (ClassNotFoundException cnfe) {
            lastError = cnfe.getMessage();
            return false;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
            return false;
        }
    }

    public boolean desconectar() {
        try {
            if (con != null) {
                con.close();
                con = null;
                return true;
            }
        } catch (Exception e) {
            lastError = e.getMessage();
            return false;
        }
        return false;
    }

    //implementado
    public static synchronized boolean registrarUsuarios(Usuario oUsuario) {
        String sql = "INSERT INTO cliente VALUES ('" + oUsuario.getId() + "','" + oUsuario.getUsername() + "','" + oUsuario.getPasword() + "','" + oUsuario.getNombres() + "','" + oUsuario.getApellidos() + "','" + oUsuario.getEmail() + "','" + oUsuario.getTelefono() + "','" + oUsuario.getCp() + "','" + oUsuario.getDomicilio() + "');";

        try {
            //creamos el objeto statement
            Statement stm = con.createStatement();
            int filasAfectadas = stm.executeUpdate(sql);

            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
            return false;
        }
    }

    //implementado
   //public static synchronized ArrayList<Usuario> searchUser(String nombres) {
   public static synchronized ArrayList<Usuario> mostrarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Connection cn = null; CallableStatement cl = null; ResultSet rs = null;
        try {
                String call = "{CALL proc_cliente()}";
                cn = Conexion.getConexion(); cl = cn.prepareCall(call); 
                //cl.setString(1, nombres);
                 
                rs = cl.executeQuery();
          
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPasword(rs.getString("pasword"));
                    u.setNombres(rs.getString("nombres"));
                    u.setApellidos(rs.getString("apellidos"));
                    u.setEmail(rs.getString("email"));
                    u.setTelefono(rs.getString("telefono"));
                    u.setCp(rs.getString("cp"));
                    u.setDomicilio(rs.getString("domicilio"));
                    lista.add(u);
                }
        } catch (SQLException e) {
            e.printStackTrace(); Conexion.cerrarCall(cl); Conexion.cerrarConexion(cn);
        } 
        return lista;
    }

    //implementado
    public static synchronized Usuario obtenerUsuario(int codigo) {
        Usuario u = new Usuario();
        Connection cn = null;
        CallableStatement cl = null;
        ResultSet rs = null;
        try {
            String call = "{CALL cliente_one(?)}";
            cn = Conexion.getConexion();
            cl = cn.prepareCall(call);
            cl.setInt(1, codigo);
            rs = cl.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPasword(rs.getString("pasword"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setCp(rs.getString("cp"));
                u.setDomicilio(rs.getString("domicilio"));
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        return u;
    }

    //implementado
    public static synchronized boolean actualizarUsuario(Usuario oUusario) {
        Connection cn = null;
        CallableStatement cl = null;
        boolean rpta = false;
        try {
            //Nombre del procedimiento almacenado y como espera tres parametros
            //le ponemos 3 interrogantes
            String call = "{CALL spU_usuario(?,?,?,?,?,?,?,?,?)}";
            //Obtenemos la conexion
            cn = Conexion.getConexion();
            //Decimos que vamos a crear una transaccion
            cn.setAutoCommit(false);
            //Preparamos la sentecia
            cl = cn.prepareCall(call);
            //El primer parametro del procedimiento almacenado es el codigo
            cl.setInt(1, oUusario.getId());
            //El siguiente parametro del procedimiento almacenado es el nombre
            cl.setString(2, oUusario.getUsername());
            //Y por ultimo el precio
            cl.setString(3, oUusario.getPasword());
            cl.setString(4, oUusario.getNombres());
            cl.setString(5, oUusario.getApellidos());
            cl.setString(6, oUusario.getEmail());
            cl.setString(7, oUusario.getTelefono());
            cl.setString(8, oUusario.getCp());
            cl.setString(9, oUusario.getDomicilio());
            //Ejecutamos la sentencia y si nos devuelve el valor de 1 es porque
            //registro de forma correcta los datos
            rpta = cl.executeUpdate() == 1 ? true : false;
            if (rpta) {
                //Confirmamos la transaccion
                cn.commit();
            } else {
                //Negamos la transaccion
                Conexion.deshacerCambios(cn);
            }
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
            Conexion.deshacerCambios(cn);
            Conexion.cerrarCall(cl);
            Conexion.cerrarConexion(cn);
        }
        return rpta;
    }

    public static synchronized boolean borrarCliente(Usuario usu) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id=" + usu.getId();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        return true;
    }
}
