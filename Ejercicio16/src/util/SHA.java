/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.SHA.getSHA;



/**
 *
 * @author iñigo
 */
public class SHA {

   /* private static HashMap<String, String> palabras = new HashMap<>();
    private static ArrayList<String> passwd = new ArrayList<>();
    private static ArrayList<String> elementos = new ArrayList();*/

    public static String getSHA(String password) {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            hash = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SHA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }
    

    public static String getSalt(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    
    public static void main(String[] args) {
        String salto = getSalt();
        System.out.println(salto);
        System.out.println(getSHA(""+getSHA("12345")+salto));
    }
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) throws FileNotFoundException, IOException {
        generarFichero();
        generarCombinaciones();
        leerFicheros();
        System.out.println("Buscando claves...");
        boolean encontrado = false;
        String parte1 = null;
        for (String passwd : passwd) {
            encontrado = false;
            for (Map.Entry<String, String> entry : palabras.entrySet()) {
                String[] partes = passwd.split(",");
                parte1 = partes[0];
                String parte2 = partes[1];
                if (parte2.equals(entry.getValue())) {
                    System.out.println(parte1 + ": " + entry.getKey());
                    encontrado = true;                                       
                    break; //No se debe hacer un break, 
                           //porque rompe con la programacion estructurada(pero tampoco esta mal)!!!
                }
            }
            if (!encontrado) {
                System.out.println(parte1 + ": NO ENCONTRADO");
            }
        }

    }

    private static void leerFicheros() throws FileNotFoundException, IOException {
        System.out.println("Generando mapa de claves...");
        String fichero;
        FileReader fr = new FileReader("palabras.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((fichero = br.readLine()) != null) {
            int pos = fichero.lastIndexOf(",");           
            String parte1 = fichero.substring(0, pos);
            String parte2 = fichero.substring(pos + 1);
            palabras.put(parte1, parte2);
        }

        fr.close();
        String passwdS;
        fr = new FileReader("passwd");
        br = new BufferedReader(fr);
        while ((passwdS = br.readLine()) != null) {
            passwd.add(passwdS);
        }
        fr.close();
        String ficheroCombinaciones;
        fr = new FileReader("combinaciones.txt");
        br = new BufferedReader(fr);
        while ((ficheroCombinaciones = br.readLine()) != null) {           
            int pos = ficheroCombinaciones.lastIndexOf(",");           
            String parte1 = ficheroCombinaciones.substring(0, pos);
            String parte2 = ficheroCombinaciones.substring(pos + 1);
            
            palabras.put(parte1, parte2);
        }
       
        fr.close();

        String ficheroNumeros;
        fr = new FileReader("numeros.txt");
        br = new BufferedReader(fr);
        while ((ficheroNumeros = br.readLine()) != null) {
            int pos = ficheroNumeros.lastIndexOf(",");           
            String parte1 = ficheroNumeros.substring(0, pos);
            String parte2 = ficheroNumeros.substring(pos + 1);
            palabras.put(parte1, parte2);
        }
        fr.close();

    }

    private static void generarFichero() throws IOException {
        int cont;
        String ruta = "numeros.txt";
        File numeros = new File(ruta);
        BufferedWriter bw;
        if (numeros.exists()) {
            System.out.println("ya existe");
        } else {
            bw = new BufferedWriter(new FileWriter(numeros));
            for (cont = 0; cont < 1000000; cont++) {
                bw.write(cont + "," + getSHA(Integer.toString(cont)));
                bw.newLine();

            }
            bw.flush();
            bw.close();
        }

    }

    private static void generarCombinaciones() throws IOException {
        String ruta = "combinaciones.txt";
        File combinaciones = new File(ruta);
        BufferedWriter bw;
        if (combinaciones.exists()) {
            System.out.println("ya existe");
        } else {
            bw = new BufferedWriter(new FileWriter(combinaciones));
            for (char c = '('; c < 'z' + 1; c++) {
                String s = null;
                s = s.valueOf(c);
                elementos.add(s);
            }
            String r;
            for (int i = 0; i < elementos.size(); i++) {
                r = elementos.get(i);                
                bw.write(r + "," + getSHA(r));
                bw.newLine();
                for (int j = 0; j < elementos.size(); j++) {
                    r = "" + elementos.get(i) + elementos.get(j);                    
                    bw.write(r + "," + getSHA(r));
                    bw.newLine();
                    for (int k = 0; k < elementos.size(); k++) {
                        r = elementos.get(i) + elementos.get(j) + elementos.get(k);                        
                        bw.write(r + "," + getSHA(r));
                        bw.newLine();

                    }
                }
            }
            bw.flush();
            bw.close();
        }

    }*/
}
