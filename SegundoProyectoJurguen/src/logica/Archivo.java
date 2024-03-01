/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jurguen
 */
public class Archivo {
    
    public void arbolBK(String ruta, String arbol) {
        File archivo = new File(ruta + ".TEMP");
        try {
            if (archivo.createNewFile()) {
                JOptionPane.showMessageDialog(new JFrame(), "Se creo correctamente");
                try ( BufferedWriter salida = new BufferedWriter(new FileWriter(archivo))) {
                    salida.write(arbol);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
