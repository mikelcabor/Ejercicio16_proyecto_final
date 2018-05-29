/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw1
 */
public class Usuario {
    private int idUsuario;
    private String nick;
    private String nombre;
    private String apellido;
    private String password;
    private String salto;
    private String foto;
    public String getSalto;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nick, String nombre, String apellido, String password,String salto, String foto) {
        this.idUsuario = idUsuario;
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.salto = salto;
        this.foto = foto;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSalto() {
        return salto;
    }

    public void setSalto(String salto) {
        this.salto = salto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
