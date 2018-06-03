/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Pedido;

/**
 *
 * @author daw1
 */
public interface PedidoDAO {
    List<Pedido> getPedidos();
    Pedido getPedido(int idPedido);
    void nuevoPedido(Pedido p);
    void eliminarPedido(Pedido p);
    void modificarPedido(Pedido p);
    List<Pedido> getProductoPedido(int idProducto);
    
}
