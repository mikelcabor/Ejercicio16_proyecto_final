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
import modelo.Categoria;
import util.Conexion;

/**
 *
 * @author daw1
 */
public class CategoriaBD implements CategoriaDAO{

    @Override
    public List<Categoria> getCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * FROM categorias_16");
            while(rst.next()){
                Categoria c = leerCategoria(rst);
                categorias.add(c);
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return categorias;
    }

    @Override
    public Categoria getCategoria(int idCategoria) {
        Categoria c = null;
        PreparedStatement pst;
        ResultSet rst;
        
        try {
            pst = Conexion.getConexion().prepareStatement("SELECT * FROM categorias_16 where idCategoria=?");
            pst.setInt(1, idCategoria);
            rst = pst.executeQuery();
            if(rst.next()){
                c = leerCategoria(rst);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    @Override
    public void nuevaCategoria(Categoria c) {
       PreparedStatement pst;
        try {
            pst = Conexion.getConexion().prepareStatement("Insert into Categortias_16(idUsuario,nombre,foto) "
                    + "values (?,?,?,?,?)");
            pst.setInt(1, c.getIdCategoria());
            pst.setString(2,c.getNombre());        
            pst.setString(5,c.getFoto());
            pst.executeUpdate();
            pst.close();            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarCategoria(Categoria c) {
        PreparedStatement pst;        
        try {
            pst = Conexion.getConexion().prepareStatement("Delete From Categoria_16 where idCategoria=?");
            pst.setInt(1, c.getIdCategoria());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificarCategoria(Categoria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> getProductoCategoria(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private Categoria leerCategoria(ResultSet rst) {
       Categoria c = new Categoria();
        try {
             c.setIdCategoria(rst.getInt("idCategoria"));
             c.setNombre(rst.getString("nombre"));             
             c.setFoto(rst.getString("foto"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    
    
}
