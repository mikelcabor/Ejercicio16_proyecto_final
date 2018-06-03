/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Usuario;
import service.Service;

/**
 *
 * @author daw1
 */
public class Principal extends javax.swing.JFrame {
    private Usuario usuario;
    private Service services = new Service();
    /**
     * Creates new form Principal
     */
    public Principal(Usuario usuario) {
        this.usuario = usuario;       
        initComponents();
         cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIzquierda = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        pnlSalir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        pnlTitulo = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        lblTitulo = new javax.swing.JLabel();
        lblImagenUsuario = new javax.swing.JLabel();
        pnlContenido = new javax.swing.JPanel();
        btnMisProductos = new javax.swing.JButton();
        btnProductosVentas = new javax.swing.JButton();
        btnProductosCompras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlIzquierda.setLayout(new javax.swing.BoxLayout(pnlIzquierda, javax.swing.BoxLayout.LINE_AXIS));
        pnlIzquierda.add(lblBanner);

        getContentPane().add(pnlIzquierda, java.awt.BorderLayout.WEST);

        pnlSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlSalir.add(btnSalir);

        getContentPane().add(pnlSalir, java.awt.BorderLayout.PAGE_END);

        pnlTitulo.setLayout(new java.awt.GridLayout(1, 0));
        pnlTitulo.add(filler2);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Productos asfasfasf");
        pnlTitulo.add(lblTitulo);

        lblImagenUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblImagenUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImagenUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenUsuarioMouseClicked(evt);
            }
        });
        pnlTitulo.add(lblImagenUsuario);

        getContentPane().add(pnlTitulo, java.awt.BorderLayout.PAGE_START);

        pnlContenido.setLayout(new java.awt.GridLayout(0, 3));

        btnMisProductos.setText("Mis productos");
        btnMisProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisProductosActionPerformed(evt);
            }
        });
        pnlContenido.add(btnMisProductos);

        btnProductosVentas.setText("Productos en venta");
        btnProductosVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosVentasActionPerformed(evt);
            }
        });
        pnlContenido.add(btnProductosVentas);

        btnProductosCompras.setText("Productos comprados");
        btnProductosCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosComprasActionPerformed(evt);
            }
        });
        pnlContenido.add(btnProductosCompras);

        getContentPane().add(pnlContenido, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("Principal");

        setSize(new java.awt.Dimension(668, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosVentasActionPerformed
        new VerProductosCategoria(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosVentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Quieres Salir de la aplicacion?","Cerrar aplicacion",JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
                this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lblImagenUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenUsuarioMouseClicked
        if (JOptionPane.showConfirmDialog(this, "¿Quieres cerrar la sesion?","Cerrar sesion",JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
            new Login().setVisible(true);
            this.dispose();
        }
                
    }//GEN-LAST:event_lblImagenUsuarioMouseClicked

    private void btnMisProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisProductosActionPerformed
        new ProductosLista(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMisProductosActionPerformed

    private void btnProductosComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosComprasActionPerformed
        new ProductosComprados(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosComprasActionPerformed

    /**
     * @param args the command line arguments
     */
   
    private void cargarDatos(){        
        ImageIcon imIc = new ImageIcon("images/"
                + this.usuario.getFoto());
        Image imag = imIc.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        imIc.setImage(imag);        
        lblImagenUsuario.setIcon(imIc);
        lblTitulo.setText("Productos de "+usuario.getNombre());
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMisProductos;
    private javax.swing.JButton btnProductosCompras;
    private javax.swing.JButton btnProductosVentas;
    private javax.swing.JButton btnSalir;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblImagenUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlIzquierda;
    private javax.swing.JPanel pnlSalir;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
