package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import misInterfaces.InterfacePaciente;
import modelo.Paciente;

public class PacienteDAO implements InterfacePaciente{
    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Paciente p;
    ArrayList<Paciente> lista = new ArrayList<>();
    

    @Override
    public boolean agregar(Paciente p) {        
        try {
            String sql = "insert into paciente(codpac, nompac, apepac, edapac) values(?,?,?,?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setInt(4, p.getEdad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from paciente where codpac = "+codigo;
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editar(Paciente p) {
        try {
            String sql = "update paciente set codpac=?, nompac=?, apepac=?, edapac=? where codpac = "+p.getCodigo();
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setInt(4, p.getEdad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Paciente> listarTodos() {
        try {
            String sql = "select * from paciente";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new Paciente();
                p.setCodigo(rs.getString("codpac"));
                p.setNombre(rs.getString("nompac"));
                p.setApellido(rs.getString("apepac"));
                p.setEdad(rs.getInt("edapac"));
                lista.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Paciente listarUno(String codigo) {
        try {
            String sql = "select * from paciente where codpac = "+codigo;
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new Paciente();
                p.setCodigo(rs.getString("codpac"));
                p.setNombre(rs.getString("nompac"));
                p.setApellido(rs.getString("apepac"));
                p.setEdad(rs.getInt("edapac"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
