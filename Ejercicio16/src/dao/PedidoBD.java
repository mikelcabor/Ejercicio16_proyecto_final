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
import modelo.Pedido;
import util.Conexion;

/**
 *
 * @author daw1
 */
public class PedidoBD implements PedidoDAO{

    @Override
    public List<Pedido> getPedidos() {
         List<Pedido> pedidos = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * FROM Pedidos_16");
            while(rst.next()){
                Pedido c = leerPedido(rst);
                pedidos.add(c);
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }                
        return pedidos;
    }

    @Override
    public Pedido getPedido(int idPedido) {
        Pedido c = null;
        PreparedStatement pst;
        ResultSet rst;
        
        try {
            pst = Conexion.getConexion().prepareStatement("SELECT * FROM Pedidos_16 where idPedido=?");
            pst.setInt(1, idPedido);
            rst = pst.executeQuery();
            if(rst.next()){
                c = leerPedido(rst);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    @Override
    public void nuevoPedido(Pedido p) {
        PreparedStatement pst;
        try {
            pst = Conexion.getConexion().prepareStatement("Insert into Categortias_16(idPedido,idUsuario,idFechapedido,importeTotal) "
                    + "values (?,?,?,?)");
            pst.setInt(1, p.getIdPedido());
            pst.setInt(2,p.getIdUsuario());        
            pst.setString(3,p.getIdFechapedido());
            pst.setDouble(4,p.getImporteTotal());     
            pst.executeUpdate();
            pst.close();            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPedido(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarPedido(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Pedido leerPedido(ResultSet rst) {
        Pedido c = new Pedido();
        try {
             c.setIdPedido(rst.getInt("idCategoria"));
             c.setIdPedido(rst.getInt("idPedido"));             
             c.setIdFechapedido(rst.getString("fechaPedido"));
             c.setImporteTotal(rst.getInt("importeTotal"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
}
