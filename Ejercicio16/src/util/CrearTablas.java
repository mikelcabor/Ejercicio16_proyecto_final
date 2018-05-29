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

            stmt.executeUpdate("Insert into Productos_16 Values(1,1,1,'Escoba',3,'La escoba es una herramienta que consta de un palo o vara al que se fijan en el extremo fibras duras y se utiliza para trapear o limpiar el suelo.',null,9.10,'1p.jpg')");
            stmt.executeUpdate("Insert into Productos_16 Values(2,2,3,'Cacahuete',1,'es una legumbre de la familia de las Fabaceae (fabáceas) cuyos frutos se consideran frutos secos',null,2.99,'2p.jpg')");
            stmt.executeUpdate("Insert into Productos_16 Values(3,3,2,'Camiseta',4,'Prenda interior que cubre el tronco, generalmente sin cuello.','04/04/2018',19.99,'3p.jpg')");
            stmt.executeUpdate("Insert into Productos_16 Values(4,4,2,'Destornillador',5,'Herramienta para atornillar o destornillar que consiste generalmente en una barra metálica sujeta a un mango y terminada en un extremo que se adapta a la cabeza del tornillo.',null,7.99,'4p.jpg')");
           
            
            stmt.executeUpdate("Create table Pedidos_16("                    
                    + "idPedido number(5),"
                    + "idUsuario number(3) constraint FK_USUARIOS_PEDIDOS_16 references usuarios_16,"                    
                    + "fechaPedido date,"
                    + "importeTotal number(7,2),"
                    + "constraint PK_PEDIDOS_16 primary key(idPedido))");

            stmt.executeUpdate("Insert into Pedidos_16 Values(1,1,null,10.2)");
            stmt.executeUpdate("Insert into Pedidos_16 Values(2,2,null,15.3)");
            stmt.executeUpdate("Insert into Pedidos_16 Values(3,1,null,5.3)");
            stmt.executeUpdate("Insert into Pedidos_16 Values(4,2,null,2.6)");
            /* List<Evento> eventos = new ArrayList<>();
            eventos.add(new Evento(1, 1, "Las noches de Comedy Central", "Euskaltel trae a tres de los mejores cómicos del momento a Las Noches de Comedy Central.\n"
                    + "Un evento exclusivo y gratuito para los clientes de Euskaltel.\n"
                    + "\n"
                    + "La promoción se llevará a cabo del 27/02/2018 al 05/03/2018. Exclusivo para clientes de Euskaltel. El sorteo se celebrará el 06/03/2018 publicando los nombres de los ganadores en la web el 07/03/2018. Euskaltel se pondrá en contacto con los ganadores vía telefónica.", 3, 1, new GregorianCalendar(2018, 2, 10).getTime(), 20, "comedy.png"));
            eventos.add(new Evento(2, 3, "ImagineNano", "Nanociencia & Nanotecnología\n"
                    + "\n"
                    + "THE LARGEST EUROPEAN EVENT IN NANOTECHNOLOGY", 4, 1, new GregorianCalendar(2018, 2, 13).getTime(), 250, "imagine.jpg"));
            eventos.add(new Evento(3, 1, "Berri Txarrak", "Atención: las entradas para el concierto del BEC están volando. Las entradas para pista ya se han agotado, así como los tickets especiales “experiencia intrasoinuak”. Así las cosas, ampliamos aforo y damos el salto al Bizkaia Arena, el mayor recinto del BEC. Las ENTRADAS PARA GRADA ya están a la venta. Recordad que se mantiene el precio de lanzamiento (17 € + gastos) hasta el día 26 de diciembre. A partir de esa fecha las entradas subirán de precio, y en taquilla -si quedaran-, costarán 25 €. Va a ser memorable, no lo dejes para última hora!!!\n"
                    + "\n"
                    + "20:00 Apertura de puertas\n"
                    + "00:30 Finalización concierto", 1, 1, new GregorianCalendar(2018, 2, 17).getTime(), 20, "berri.jpg"));
            eventos.add(new Evento(4, 2, "E.V.A.", "La veterana compañía catalana T de Teatre presenta E.V.A., una comedia dramática que tiene como principal eje el tema del dolor, de hecho las siglas de su título se corresponden con las de Escala Visual Analógica del Dolor. Cuatro ex compañeras de escuela nos descubren sus historias vitales para reflexionar sobre el dolor en todas sus facetas: el dolor físico, el dolor crónico, el dolor somático, el dolor neuropático, el dolor vital, el dolor moral, el dolor cotidiano, el dolor del alma… Un texto escrito conjuntamente por Marc Artigau, Cristina Genebat y Julio Manrique dirigido por el propio Manrique.", 3, 3, new GregorianCalendar(2018, 2, 23).getTime(), 20, "eva.jpg"));
            eventos.add(new Evento(5, 2, "Dany & The Champions Of The World",
                    "'Brilliant Light' es el sexto trabajo de los británicos Danny & The Champions of the World, producido por su bajista Chris Clarke Chris en los estudios londinenses de Reservoir Studios. En este último trabajo de estudio sus canciones exudan ese sabor a Stax y a toda esa localidad de Muscle Shoals en Alabama, una delicia y un claro homenaje al country, folk, bluegrass, góspel, R&B y rock.",
                    1, 2, new GregorianCalendar(2018, 2, 9).getTime(), 17, "dany.jpg"));
            eventos.add(new Evento(6, 3, "Fito y Fitipaldis", "Durante 2018, Fito & Fitipaldis llevará a cabo la gira de celebración, “20 años, 20 ciudades”.\n"
                    + "\n"
                    + "Los Fitipaldis han preparado un repertorio exclusivo de grandes éxitos que se presentará en grandes recintos de 20 únicas ciudades. En cada concierto Fito invitará a diferentes artistas y amigos a subir al escenario para compartir canciones.", 1, 1, new GregorianCalendar(2018, 4, 4).getTime(), 40, "fito.jpg"));
            eventos.add(new Evento(7, 4, "Loraldia 2018. Barruko Ametsak", "Azkuna Zentroa acoge un año más parte de la programación de Loraldia, el Festival de Primavera para la promoción de la cultura vasca en euskera, con propuestas contemporáneas de cine, música y artes escénicas.\n"
                    + "\n"
                    + "LORARTEA, ARTEA KALEAN: 'BARRUKO AMETSAK'. Raimon Bikandi\n"
                    + "\n"
                    + "'Barruko Ametsak' es una exposición artística creada por Raimon Bikandi. Las flores toman las calles horas antes del comienzo de algunos de los espectáculos de Loraldia.", 2, 3, new GregorianCalendar(2018, 2, 23).getTime(), 0, "loraldia.jfif"));
            eventos.add(new Evento(8, 2, "Los universos paralelos", "Escrito originalmente por David Lindsay-Abbaire y versionado para la ocasión por David Serrano, Los univeros paralelos es un emocionante drama protagonizado por un elenco de lujo en el que encontramos actores de la talla de Malena Alterio, Belén Cuesta, Carmen Balagué, Juan Carlos Vellido e Itzan Escamilla. Hace pocos meses, Patricia y Alberto formaban una familia feliz junto a su hijo pequeño, pero la pérdida de éste les ha sumido en una espiral de recuerdos y culpabilidades difícil de gestionar. Ahora, su decisión es intentar encontrar un camino que les permita vivir en paz.", 3, 3, new GregorianCalendar(2018, 2, 9).getTime(), 38, "universos.jpg"));
            eventos.add(new Evento(9, 2, "Thirty Seconds To Mars", "La banda multiplatino Thirty Seconds To Mars ha anunciado que se embarcarán en una gran gira europea durante marzo, abril y mayo de 2018.\n"
                    + "\n"
                    + "Jared Leto, Shannon Leto y Tomo Milicevic son actualmente una de las bandas en directo más vibrantes del mundo, lo que queda reflejado sin duda en la actuación con la que volvieron a los escenarios have unos meses en los premios MTV VMA. La actuación es toda una muestra de que Thirty Seconds To Mars son capaces de hacer, incluyendo la innovadora tecnología de ultrarojos y con la colaboración especial de Travis Scott. ‘Walk On Water’ es la canción que interpretaron y es el primer single del que será el quinto álbum de la banda. Actualmente están nominados en la categoria de Best Alternative en los próximos premios MTV European Music Awards, que se celebrarán el próximo 12 de noviembre.", 1, 1, new GregorianCalendar(2018, 2, 14).getTime(), 50, "thirty.jpg"));

            PreparedStatement pst = cnn.prepareStatement(
                    "Insert into eventos values(?,?,?,?,?,?,?,?,?)");
            for (Evento e : eventos) {
                pst.setInt(1, e.getIdEvento());
                pst.setInt(2, e.getIdUsuario());
                pst.setString(3, e.getTitulo());
                pst.setString(4, e.getDescripcion());
                pst.setInt(5, e.getIdCategoria());
                pst.setInt(6, e.getIdLugar());
                pst.setDate(7, new java.sql.Date(e.getFecha().getTime()));
                pst.setDouble(8, e.getPrecio());
                pst.setString(9, e.getFoto());
                pst.executeUpdate();
            }*/

            // Usuarios / Eventos
          /*  stmt.executeUpdate(
                "Create table usuarioEventos (" +
                "idUsuario number(6) constraint FK_USUARIOEVENTOS_USUARIOS references Usuarios," +
                "idEvento number(5) constraint FK_USUARIOEVENTOS_EVENTOS references Eventos," +
                "CONSTRAINT PK_USUARIOEVENTOS Primary Key(idUsuario,idEvento))");
            stmt.executeUpdate("insert into usuarioEventos values(1,1)");
            stmt.executeUpdate("insert into usuarioEventos values(1,3)");
            stmt.executeUpdate("insert into usuarioEventos values(2,1)");
            stmt.executeUpdate("insert into usuarioEventos values(2,2)");
            stmt.executeUpdate("insert into usuarioEventos values(3,5)");
            stmt.executeUpdate("insert into usuarioEventos values(3,7)");
            stmt.executeUpdate("insert into usuarioEventos values(4,9)");
            stmt.executeUpdate("insert into usuarioEventos values(4,2)");*/
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
