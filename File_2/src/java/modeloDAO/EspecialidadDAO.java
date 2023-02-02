package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import misInterfaces.InterfaceEspecialidad;
import modelo.Especialidad;

public class EspecialidadDAO implements InterfaceEspecialidad{
    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Especialidad e;
    ArrayList<Especialidad> lista = new ArrayList<>();

    @Override
    public boolean agregar(Especialidad e) {
        try {
            String sql = "insert into especialidad(codesp, nomesp) values(?,?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getNombre());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from especialidad where codesp = "+codigo;
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editar(Especialidad e) {
        try {
            String sql = "update especialidad set codesp=?, nomesp=? where codesp = "+e.getCodigo();
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getNombre());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Especialidad> listarTodos() {
        try {
            String sql = "select * from especialidad";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                e = new Especialidad();
                e.setCodigo(rs.getString("codesp"));
                e.setNombre(rs.getString("nomesp"));
                lista.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Especialidad listarUno(String codigo) {
        try {
            String sql = "select * from especialidad where codesp = "+codigo;
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                e = new Especialidad();
                e.setCodigo(rs.getString("codesp"));
                e.setNombre(rs.getString("nomesp"));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
}
