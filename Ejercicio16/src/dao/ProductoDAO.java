/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Producto;

/**
 *
 * @author daw1
 */
public interface ProductoDAO {
    List<Producto> getProductos();
    Producto getProducto(int idProducto);
    void nuevoProducto(Producto p);
    void eliminarProducto(Producto p);
    void modificarProducto(Producto p);
    List<Producto> getProductoCategoria(int idCategoria);
    List<Producto> getProductoUsuario(int idUsuario);
}
