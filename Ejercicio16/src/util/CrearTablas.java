/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw1
 * Hay que ejecutarlo dos veces para crear las tablas correctamente!
 */
public class CrearTablas {
    
    public static void main(String[] args) {
        Connection cnn = null;
        Statement stmt = null;
        try {
            // Registrar el driver de la BBDD
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Conexión a la BBDD
            cnn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:ORCL",
                    "scott", "tiger");
            stmt = cnn.createStatement();           
           
            try {
                stmt.executeUpdate("Drop table Productos_16");
            } catch (SQLException ex) {
            }
            try {
                stmt.executeUpdate("Drop table Usuarios_16");
            } catch (SQLException ex) {
            }
            try {
                stmt.executeUpdate("Drop table Pedidos_16");
            } catch (SQLException ex) {
            }
            
            
            try {
                stmt.executeUpdate("Drop table Categorias_16");
            } catch (SQLException ex) {
            }
            
            // Categorías
            stmt.executeUpdate(
                    "Create Table Categorias_16 ("
                    + "idCategoria number(3) constraint PK_CATEGORIAS_16 primary key,"
                    + "nombre varchar2(120) not null," 
                    + "foto varchar2(20))");
            stmt.executeUpdate("Insert into Categorias_16 values(1,'Limpieza','1c.jpg')");
            stmt.executeUpdate("Insert into Categorias_16 values(2,'Alimentos','2c.jpg')");
            stmt.executeUpdate("Insert into Categorias_16 values(3,'Ropa','3c.jpg')");
            stmt.executeUpdate("Insert into Categorias_16 values(4,'Herramientas','4c.jpg')");

            //Lugares
            
            //Usuarios            
            stmt.executeUpdate("Create table Usuarios_16("
                    + "idUsuario number(6) constraint PK_USUARIOS_16 primary key,"
                    + "nick varchar2(120) not null,"
                    + "nombre varchar2(120) not null,"
                    + "apellido varchar2(120) not null,"
                    + "password varchar2(255) not null,"
                    + "salto varchar(40) not null,"
                    + "foto varchar2(120))");
            stmt.executeUpdate("Insert into Usuarios_16 Values(1,'Juan360','Juan','López','46f47894a089a02c1c0d687ed3eb3645150bc8f43403e38e5db43e126b5a59b1','1H1B2C0OQLWW83ZME9','1.jpg')");
            stmt.executeUpdate("Insert into Usuarios_16 Values(2,'Anamarin','Ana','Marín','0281b1dfa7ae07a707439760345589569d662299b0fc2497e328dfdbd42ddda9','BIBZDCN4TNT2LKZDGM','2.jpg')");
            stmt.executeUpdate("Insert into Usuarios_16 Values(3,'Sarita','Sara','Sanz','e161f2ebcf937e14837446b1b7b40a1066d4384c50a5a11a376749dfde34ff53','02KMJU756ZPKGXP07J','3.jpg')");
            stmt.executeUpdate("Insert into Usuarios_16 Values(4,'CarlosMatos','Carlos','Ginés','c8098c46d69a07c2405894d7b960b0837f6482092c4717efc9c97402ae27f947','BYI9VQKYMHU0HJC4YQ','4.jpg')");

            //Productos
            stmt.executeUpdate("Create table Productos_16("
                    + "idProducto number(5) constraint PK_PRODUCTOS_16 primary key,"
                    + "idCategoria number(3) constraint FK_PRODUCTOS_CATEGORIAS_2 references categorias_16,"
                    + "idUsuario number(3) constraint FK_PRODUCTOS_USUARIOS_16 references usuarios_16,"                    
                    + "nombre varchar2(120) not null,"
                    + "estado number(2) constraint CHK_ESTADOS2 check (estado BETWEEN 1 and 5),"
                    + "descripcion varchar2(2000),"                    
                    + "fechaVenta date,"
                    + "precio number(7,2),"
                    + "foto varchar2(120))");

            stmt.executeUpdate("Insert into Productos_16 Values(1,1,1,'Escoba',3,'La escoba es una herramienta que consta de un palo o vara al que se fijan en el extremo fibras duras y se utiliza para trapear o limpiar el suelo.','08/06/2015',9.10,'1p.jpg')");
            stmt.executeUpdate("Insert into Productos_16 Values(2,2,3,'Cacahuete',1,'es una legumbre de la familia de las Fabaceae (fabáceas) cuyos frutos se consideran frutos secos','06/04/2014',2.99,'2p.jpg')");
            stmt.executeUpdate("Insert into Productos_16 Values(3,3,2,'Camiseta',4,'Prenda interior que cubre el tronco, generalmente sin cuello.','04/04/2018',19.99,'3p.jpg')");
            stmt.executeUpdate("Insert into Productos_16 Values(4,4,2,'Destornillador',5,'Herramienta para atornillar o destornillar que consiste generalmente en una barra metálica sujeta a un mango y terminada en un extremo que se adapta a la cabeza del tornillo.','08/09/2007',7.99,'4p.jpg')");
            
           
            
            stmt.executeUpdate("Create table Pedidos_16("                    
                    + "idPedido number(5),"
                    + "idUsuario number(3) constraint FK_USUARIOS_PEDIDOS_16 references usuarios_16," 
                    + "idProducto number(3) constraint FK_Productos_PEDIDOS_16 references productos_16,"  
                    + "fechaPedido date,"
                    + "importeTotal number(7,2),"
                    + "constraint PK_PEDIDOS_16 primary key(idPedido))");

            stmt.executeUpdate("Insert into Pedidos_16 Values(1,1,2,'10/10/2015',10.2)");
            stmt.executeUpdate("Insert into Pedidos_16 Values(2,2,3,'10/10/2016',15.3)");
            stmt.executeUpdate("Insert into Pedidos_16 Values(3,1,1,'10/10/2014',5.3)");
            stmt.executeUpdate("Insert into Pedidos_16 Values(4,2,3,'10/10/2017',2.6)");
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearTablas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearTablas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
            }
            try {
                cnn.close();
            } catch (Exception ex) {
            }
        }
    }
}
