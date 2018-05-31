/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Component;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;
import modelo.Categoria;
import modelo.Pedido;
import modelo.Producto;
import modelo.Usuario;
import service.Service;

/**
 *
 * @author daw1
 */
public class VerProductosCategoria extends javax.swing.JFrame {
    private Usuario usuario;
    private Categoria categoria;
    private Service services = new Service();
     private DefaultMutableTreeNode trRaiz;
    /**
     * Creates new form VerProductosCategoria
     */
    public VerProductosCategoria(Usuario usuario) {
        this.usuario = usuario;        
        //cargarProductosCategoria(services.getCategoria(2));
        initComponents();
        crearArbolCategorias();
        jTree.setCellRenderer(new CategoriasRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlContenido = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        pnlArbol = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnComprar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnCancelar);

        getContentPane().add(pnlBotones, java.awt.BorderLayout.PAGE_END);

        pnlContenido.setLayout(new java.awt.BorderLayout());

        pnlTabla.setLayout(new java.awt.BorderLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Vendedor", "Precio", "Estado", "Fecha", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        pnlTabla.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(pnlTabla);

        pnlArbol.setLayout(new java.awt.BorderLayout());

        jTree.setModel(null);
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                seleccionCategoria(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        pnlArbol.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(pnlArbol);

        pnlContenido.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlContenido, java.awt.BorderLayout.CENTER);

        lblTitulo.setText("Ver Productos Categoria");
        pnlTitulo.add(lblTitulo);

        getContentPane().add(pnlTitulo, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(651, 485));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Volver sin guardar?","Volver",JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
            new Principal(usuario).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void seleccionCategoria(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_seleccionCategoria
       TreePath path = evt.getPath();
        if (path.getPathCount() == 2) {
            DefaultMutableTreeNode treCategoria = (DefaultMutableTreeNode) path.getLastPathComponent();
            //DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) path.getPathComponent(2);
            Categoria c = (Categoria) treCategoria.getUserObject();
            cargarProductosCategoria(c);
        }
       
    }//GEN-LAST:event_seleccionCategoria

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        comprarProducto();
    }//GEN-LAST:event_btnComprarActionPerformed
    
    private void comprarProducto(){
        
           /* Pedido e = new Producto();   
            e.setIdPedido(services.getProductos().size()+1);
            e.setIdUsuario(tblProductos.getColumn(0).get);
            e.setIdUsuario(usuario.getIdUsuario());
            e.setNombre(txtNombre.getText());
            //e.setIdCategoria(txtCategoria.get);
            e.setDescripcion(txtDescripcion.getText());            
            e.setEstado(slEstado.getValue());
            e.setFecha(lblFecha.getText());            
            e.setPrecio(Double.valueOf(String.valueOf(txtPrecio.getValue())));
            e.setFoto(String.valueOf(lblImagen.getIcon()));
            services.nuevoProducto(e);
            JOptionPane.showMessageDialog(this, "Evento guardado correctamente");
            */
        
    }
    
    private void crearArbolCategorias() {
        trRaiz = new DefaultMutableTreeNode("Categorias");
        for (Categoria c : services.getCategorias()) {
            DefaultMutableTreeNode trCat = new DefaultMutableTreeNode(c);    
            trRaiz.add(trCat);
        }       
        TreeModel model = new DefaultTreeModel(trRaiz);
        jTree.setModel(model);
    } 
    
    
    
     private void cargarProductosCategoria(Categoria c) {
        String[] titulos = {"Nombre", "Vendedor","Precio","Estado","Fecha","Foto"};
        List<Producto> productos = services.getProductoCategoria(c.getIdCategoria());
        Object[][] datos = new Object[productos.size()][6] ;
        for(int i=0; i<productos.size(); i++){
            datos[i][0] = productos.get(i);
            datos[i][1] = String.valueOf(productos.get(i).getIdUsuario());
            datos[i][2] = String.valueOf(productos.get(i).getPrecio());
            datos[i][3] = String.valueOf(productos.get(i).getEstado());
            datos[i][4] = String.valueOf(productos.get(i).getFecha());
            datos[i][5] = String.valueOf(productos.get(i).getFoto());
        }
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        tblProductos.setModel(modelo);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlArbol;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
    
    
    class CategoriasRenderer implements TreeCellRenderer{

        @Override
        public Component getTreeCellRendererComponent(
                JTree tree, 
                Object value, 
                boolean selected, 
                boolean expanded, 
                boolean leaf, 
                int row, 
                boolean hasFocus) {
            JLabel lbl = new JLabel();
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
            if (row == 0){
                lbl.setText("Categoria");                
                 
            } else {
                lbl.setText(nodo.getUserObject().toString());  
               
            }
            
            return lbl;
        }
        
    }
    
    
}
