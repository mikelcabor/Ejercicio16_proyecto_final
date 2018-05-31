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
public class Pedido {
    private int idPedido;
    private int idUsuario;
    private String idFechapedido;
    private double importeTotal;

    public Pedido() {
    }

    public Pedido(int idPedido, int idUsuario, String idFechapedido, double importeTotal) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idFechapedido = idFechapedido;
        this.importeTotal = importeTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdFechapedido() {
        return idFechapedido;
    }

    public void setIdFechapedido(String idFechapedido) {
        this.idFechapedido = idFechapedido;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    
    
    
}
