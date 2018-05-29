/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author daw1
 */
public interface UsuarioDAO {
    List<Usuario> getUsuarios();
    Usuario getUsuario(int idUsuario);
    
    void nuevoUsuario(Usuario u, String password);
    void eliminarUsuario(Usuario u);
    void modificarUsuario(Usuario u);
    
}
