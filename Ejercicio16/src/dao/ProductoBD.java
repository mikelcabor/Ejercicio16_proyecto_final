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
import modelo.Producto;
import util.Conexion;

/**
 *
 * @author daw1
 */
public class ProductoBD implements ProductoDAO{

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * FROM Productos_16");
            while(rst.next()){
                Producto p = leerProducto(rst);
                productos.add(p);
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return productos;
    }

    @Override
    public Producto getProducto(int idProducto) {
        Producto p = null;
        PreparedStatement pst;
        ResultSet rst;
        
        try {
            pst = Conexion.getConexion().prepareStatement("SELECT * FROM Productos_16 where idProducto=?");
            pst.setInt(1, idProducto);
            rst = pst.executeQuery();
            if(rst.next()){
                p = leerProducto(rst);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }

    @Override
    public void nuevoProducto(Producto p) {
         PreparedStatement pst;
        try {
            pst = Conexion.getConexion().prepareStatement("Insert into Productos_16(idProducto,idCategoria,idUsuario,nombre,estado,descripcion,fechaVenta,precio,foto) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, p.getIdProducto());
            pst.setInt(2, p.getIdCategoria());
            pst.setInt(3, p.getIdUsuario());
            pst.setString(4, p.getNombre());
            pst.setInt(5,p.getEstado());
            
            /*String salto = SHA.getSalt();
            String hash = SHA.getSHA(password, salto);
            */
            pst.setString(6, p.getDescripcion());
            pst.setString(7,p.getFecha());
            pst.setDouble(8,p.getPrecio());
            pst.setString(9,p.getFoto());
            pst.executeUpdate();
            pst.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarProducto(Producto p) {
        PreparedStatement pst;        
        try {
            pst = Conexion.getConexion().prepareStatement("Delete From Productos_16 where idProducto=?");
            pst.setInt(1, p.getIdProducto());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificarProducto(Producto p) {
        PreparedStatement pst;
        try {
            pst = Conexion.getConexion().prepareStatement("Update productos_16 Set idCategoria=?, idUsuario=?, nombre=?, estado=?, descripcion=?, fechaVenta=?, precio=?, foto=? where idProducto=?");            
            
            pst.setInt(1, p.getIdCategoria());
            pst.setInt(2, p.getIdUsuario());
            pst.setString(3, p.getNombre());
            pst.setInt(4,p.getEstado());
            
            /*String salto = SHA.getSalt();
            String hash = SHA.getSHA(password, salto);
            */
            pst.setString(5, p.getDescripcion());
            pst.setString(6,p.getFecha());
            pst.setDouble(7,p.getPrecio());
            pst.setString(8,p.getFoto());
            pst.setInt(9, p.getIdProducto());
            pst.executeUpdate();
            pst.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Producto> getProductoCategoria(int idCategoria) {
        Producto p = null;
        PreparedStatement pst;
        ResultSet rst;
        
        try {
            pst = Conexion.getConexion().prepareStatement("SELECT * FROM Productos_16 where idCategoria=?");
            pst.setInt(1, idCategoria);
            rst = pst.executeQuery();
            if(rst.next()){
                p = leerProducto(rst);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*No hasta que punto esto esta bien !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        return (List<Producto>) p;
    }
    
    
    private Producto leerProducto(ResultSet rst) {
       Producto u = new Producto();
        try {
             u.setIdProducto(rst.getInt("idProducto"));
             u.setIdCategoria(rst.getInt("idCategoria"));
             u.setIdUsuario(rst.getInt("idUsuario"));
             u.setNombre(rst.getString("nombre"));
             u.setEstado(rst.getInt("estado"));
             u.setDescripcion(rst.getString("descripcion"));
             u.setPrecio(rst.getInt("precio"));
             u.setFoto(rst.getString("foto"));
             
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public List<Producto> getProductoUsuario(int idUsuario) {
        Producto p = null;
        PreparedStatement pst;
        ResultSet rst;
        
        try {
            pst = Conexion.getConexion().prepareStatement("SELECT * FROM Productos_16 where idUsuario=?");
            pst.setInt(1, idUsuario);
            rst = pst.executeQuery();
            if(rst.next()){
                p = leerProducto(rst);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*No hasta que punto esto esta bien !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        return (List<Producto>) p;
    }
}
