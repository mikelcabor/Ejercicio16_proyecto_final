/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import util.Conexion;
import util.SHA;

/**
 *
 * @author daw1
 */
public class UsuarioBD implements UsuarioDAO{

    
    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * FROM usuarios_16");
            while(rst.next()){
                Usuario u = leerUsuario(rst);
                usuarios.add(u);
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return usuarios;
    }

    @Override
    public Usuario getUsuario(int idUsuario) {
       Usuario u = null;
        PreparedStatement pst;
        ResultSet rst;
        
        try {
            pst = Conexion.getConexion().prepareStatement("SELECT * FROM usuarios_16 where idUsuario=?");
            pst.setInt(1, idUsuario);
            rst = pst.executeQuery();
            if(rst.next()){
                u = leerUsuario(rst);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
    }

    
    @Override
    public void nuevoUsuario(Usuario c, String password) {
         PreparedStatement pst;
        try {
            pst = Conexion.getConexion().prepareStatement("Insert into Usuarios_16(idUsuario,nick,nombre,apellido,password,salto,foto) "
                    + "values (?,?,?,?,?,?,?)");
            pst.setInt(1, c.getIdUsuario());
            pst.setString(2,c.getNick());
            pst.setString(3,c.getNombre());
            pst.setString(4,c.getApellido());
            String salto = c.getSalto();
            String hash = SHA.getSHA(""+SHA.getSHA(c.getPassword())+salto);            
            pst.setString(5, hash);
            pst.setString(6,c.getSalto());
            pst.setString(7,c.getFoto());
            pst.executeUpdate();
            pst.close();            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUsuario(Usuario c) {
       PreparedStatement pst;        
        try {
            pst = Conexion.getConexion().prepareStatement("Delete From usuarios_16 where idUsuario=?");
            pst.setInt(1, c.getIdUsuario());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificarUsuario(Usuario c) {
        
    }

    private Usuario leerUsuario(ResultSet rst) {
       Usuario u = new Usuario();
        try {
             u.setIdUsuario(rst.getInt("idUsuario"));
             u.setNick(rst.getString("nick"));
             u.setNombre(rst.getString("nombre"));
             u.setApellido(rst.getString("apellido"));             
             u.setPassword(rst.getString("password"));
             u.setSalto(rst.getString("salto"));
             u.setFoto(rst.getString("foto"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
   
    public static void main(String[] args) {
       
    }
    
}
