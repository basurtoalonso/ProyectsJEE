package Modelo;

import Entities.Usuario;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public List<Usuario> listarUsuario() {
        List<Usuario> lc = new ArrayList<Usuario>();
        Connection cn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;

        try {
            Conexion conexion = new Conexion();
            cn = conexion.getConexion();
            String sql = "SELECT FROM cliente";

            pr = cn.prepareStatement(sql);
            rs = pr.executeQuery();

            while (rs.next()) {
                Usuario Ousuario = new Usuario();
                   Ousuario.setId(rs.getInt("id"));
                   Ousuario.setUsername(rs.getString("username"));
                   Ousuario.setPasword(rs.getString("pasword"));
                   Ousuario.setNombres(rs.getString("nombres"));
                   Ousuario.setApellidos(rs.getString("apellidos"));
                   Ousuario.setApellidos(rs.getString("telefono"));
                   Ousuario.setEmail(rs.getString("email"));
                   Ousuario.setCp(rs.getString("cp"));
                   Ousuario.setDomicilio(rs.getString("domicilio"));
                lc.add(Ousuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            lc = null;
        } finally {
            try {
                rs.close();
                pr.close();
                cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lc;
    }

    public String eliminar(String eliminar) {
        return eliminar;
    }

    public List<Usuario> listar(String nombres, String tipoBuscar) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";


        try {
            Conexion conexion = new Conexion();
            cn = conexion.getConexion();

            if ("tipoBuscar".equals("busCliente")) {
                sql = "SELECT FROM cliente WHERE nombres LIKE ? ORDER BY nombre ASC";
            } else if ("tipoBuscar".equals("busCodigo")) {
                sql = "SELECT FROM cliente WHERE id LIKE ? ORDER BY id ASC";
            } else if ("tipoBuscar".equals("busRuc")) {
                sql = "SELECT FROM cliente WHERE apellidos LIKE ? ORDER BY apellidos ASC";
            } else {
                sql = "SELECT FROM cliente WHERE email LIKE ? ORDER BY email ASC";
            }

            ps = cn.prepareStatement(sql);
            ps.setString(1, nombres.concat("%"));
            rs = ps.executeQuery();

            List<Usuario> lista = new ArrayList<Usuario>();
            Usuario usu = null;

            while (rs.next()) {
                usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUsername(rs.getString("username"));
                usu.setPasword(rs.getString("pasword"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                 usu.setApellidos(rs.getString("telefono"));
                usu.setEmail(rs.getString("email"));
                usu.setCp(rs.getString("cp"));
                usu.setDomicilio(rs.getString("domicilio"));
                lista.add(usu);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}
