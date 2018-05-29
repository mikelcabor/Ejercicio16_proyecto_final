/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CategoriaBD;
import dao.CategoriaDAO;
import dao.ProductoBD;
import dao.ProductoDAO;
import dao.UsuarioBD;
import dao.UsuarioDAO;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;
import modelo.Usuario;
import util.SHA;

/**
 *
 * @author daw1
 */
public class Service {
    private UsuarioDAO usuarioDAO = new UsuarioBD();
    private CategoriaDAO categoriaDAO = new CategoriaBD();
    private ProductoDAO productoDAO = new ProductoBD();
    
    public List<Usuario> getUsuarios(){
        return usuarioDAO.getUsuarios();
    }
    public Usuario getUsuario(int idUsuario){
        return usuarioDAO.getUsuario(idUsuario);
    }
    
    public boolean nuevoUsuario(Usuario u,String pass){
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        int i;
        for(i=0; i<usuarios.size() && 
            !u.getNick().equalsIgnoreCase(
                usuarios.get(i).getNick());i++);
        if (i==usuarios.size()){
            usuarioDAO.nuevoUsuario(u,pass);
            return true;
        } else {
            return false;
        }
    }
    
    public void eliminarUsuario(Usuario c){
        usuarioDAO.eliminarUsuario(c);
    }
    
    public void modificarUsuario(Usuario c){
        usuarioDAO.modificarUsuario(c);
    }
    
    public List<Producto> getProductos(){
        return productoDAO.getProductos();
    }
    public Producto getProducto(int idProducto){
        return productoDAO.getProducto(idProducto);
    }
    public List<Producto> getProductoCategoria(int idCategoria){
        return productoDAO.getProductoCategoria(idCategoria);
        
    }
    
    
    public boolean nuevoProducto(Producto p){
        List<Producto> productos = productoDAO.getProductos();
        int i;
        for(i=0; i<productos.size() && 
            !p.getNombre().equalsIgnoreCase(
                productos.get(i).getNombre());i++);
        if (i==productos.size()){
            productoDAO.nuevoProducto(p);
            return true;
        } else {
            return false;
        }
    }
    
    public void eliminarProducto(Producto p){
       productoDAO.eliminarProducto(p);
    }
    
    public void modificarProducto(Producto p){
        productoDAO.modificarProducto(p);
    }
    
    public List<Categoria> getCategorias(){
        return categoriaDAO.getCategorias();
    }
    public Categoria getCategoria(int idCategoria){
        return categoriaDAO.getCategoria(idCategoria);
    }
    
    public boolean nuevaCategoria(Categoria c){
        List<Categoria> categorias = categoriaDAO.getCategorias();
        int i;
        for(i=0; i<categorias.size() && 
            !c.getNombre().equalsIgnoreCase(
                categorias.get(i).getNombre());i++);
        if (i==categorias.size()){
            categoriaDAO.nuevaCategoria(c);
            return true;
        } else {
            return false;
        }
    }
    
    public void eliminarCategoria(Categoria c){
       categoriaDAO.eliminarCategoria(c);
    }
    
    public void modificarCategoria(Categoria c){
        categoriaDAO.modificarCategoria(c);
    }
    
    
    public Usuario login(String nombre, String password){
        Usuario u = null;
        int i;
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        for(i=0; i<usuarios.size() && 
                !nombre.equalsIgnoreCase(
                        usuarios.get(i).getNombre());
                i++);
        if (i < usuarios.size()){
            usuarios.get(i).getPassword();
            if ((SHA.getSHA(""+SHA.getSHA(password) + usuarios.get(i).getSalto())).equals(usuarios.get(i).getPassword())){
                u = usuarios.get(i);
            }
        }
        return u;
    }
    
    public Usuario registro(String nick, String password){
        Usuario u = null;
        int i;
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        for(i=0; i<usuarios.size() && 
                !nick.equalsIgnoreCase(
                        usuarios.get(i).getNick());
                i++);
        if (i < usuarios.size()){                       
                u = usuarios.get(i);
                
        }
        return u;       
    }
    
}
