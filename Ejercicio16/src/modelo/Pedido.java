/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author daw1
 */
public class Pedido {
    private int idPedido;
    private int idUsuario;
    private int idProducto;
    private Date idFechapedido;
    private double importeTotal;

    public Pedido() {
    }

    public Pedido(int idPedido, int idUsuario,int idProducto, Date idFechapedido, double importeTotal) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.idFechapedido = idFechapedido;
        this.importeTotal = importeTotal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public Date getIdFechapedido() {
        return idFechapedido;
    }

    public void setIdFechapedido(Date idFechapedido) {
        this.idFechapedido = idFechapedido;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (Double.doubleToLongBits(this.importeTotal) != Double.doubleToLongBits(other.importeTotal)) {
            return false;
        }
        if (!Objects.equals(this.idFechapedido, other.idFechapedido)) {
            return false;
        }
        return true;
    }
    
    
    
}
