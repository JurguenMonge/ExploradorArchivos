/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jurguen
 */
public final class GuiPrincipal extends JFrame{
    
    //Definimos los componentes que vamos a utilizar
    JButton padre;
    JButton home;
    JButton agregarCarpeta;
    JButton agregarTXT;
    JButton eliminar;
    JButton copiar;
    JButton pegar;
    JButton btnRuta;
    JButton btnGuardarArchivo;
    
    JTextField direccion;
    JTextField txtBuscar;
    
    JLabel txtContarElementos;
    JLabel ruta;
    
    TextArea carpetasPrincipales;
    
    TextArea txtBuscarArchivo;
   
    public GuiPrincipal(){
        this.setSize(1000, 650); // asigno tamaño del panel principal
        this.setLocationRelativeTo(null); // asigno ubicación, centro de la pantalla 
        this.setTitle("Administrador de archivos");// asigno título del panel
        this.setVisible(true); // asigno visibilidad del panel
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // asigno atributo cerrar ventana cuando deje de correr el proyecto
        this.setLayout(null); 
        this.getContentPane().setBackground(Color.DARK_GRAY); //Coloco color al JFrame
        
        //Seteo los componentes a la ventana y los agrego
        this.setBtnPadre();
        this.setBtnHome();
        this.setBtnAgregarCarpeta();
        this.setBtnAgregarTXT();
        this.setBtnEliminar();
        this.setBtnCopiar();
        this.setBtnPegar();
        this.setTxtDireccion();
        this.setLblRuta();
        this.setTextCarpetas();
        this.setBtnRuta();
        this.setTxtContarElementos();
        this.setIconImage(getIconImage());
        this.setTxtBuscarArchivos();
        this.setTxtBuscar();
        this.setBtnGuardarArchivo();
        
        this.add(btnGuardarArchivo);
        this.add(txtBuscar);
        this.add(txtBuscarArchivo);
        this.add(txtContarElementos);
        this.add(btnRuta);
        this.add(carpetasPrincipales);
        this.add(ruta);
        this.add(direccion);
        this.add(pegar);
        this.add(copiar);
        this.add(eliminar);
        this.add(agregarTXT);
        this.add(agregarCarpeta);
        this.add(padre);
        this.add(home);
    }
    
    //Metodos set y get de los componentes del JFrame
    private void setBtnPadre() {
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\flecha.png");
        this.padre = new JButton(imagen);
        this.padre.setFont(myFont1);
        this.padre.setText("Padre");
        this.padre.setForeground(Color.WHITE);
        this.padre.setBackground(Color.DARK_GRAY);
        this.padre.setBorder(null);
        this.padre.setBounds(85, 3, 90, 30);
    }

    private void setBtnHome() {
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\hogar.png");
        this.home = new JButton(imagen);
        this.home.setFont(myFont1);
        this.home.setText("Home");
        this.home.setForeground(Color.WHITE);
        this.home.setBackground(Color.DARK_GRAY);
        this.home.setBorder(null);
        this.home.setBounds(-20, 3, 120, 30);
    }

    private void setBtnAgregarCarpeta() {
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\carpeta.png");
        this.agregarCarpeta = new JButton(imagen);
        this.agregarCarpeta.setFont(myFont1);
        this.agregarCarpeta.setText("Nueva Carpeta");
        this.agregarCarpeta.setForeground(Color.WHITE);
        this.agregarCarpeta.setBackground(Color.DARK_GRAY);
        this.agregarCarpeta.setBorder(null);
        this.agregarCarpeta.setBounds(180,3, 150, 30);
    }

    private void setBtnAgregarTXT() {
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\txt.png");
        this.agregarTXT = new JButton(imagen);
        this.agregarTXT.setFont(myFont1);
        this.agregarTXT.setText("Agregar TXT");
        this.agregarTXT.setForeground(Color.WHITE);
        this.agregarTXT.setBackground(Color.DARK_GRAY);
        this.agregarTXT.setBorder(null);
        this.agregarTXT.setBounds(330,3,130,30);
    }

    private void setBtnEliminar() {
        ImageIcon imagen = new ImageIcon("src\\imagenes\\cerrar.png");
        this.eliminar = new JButton(imagen);
        this.eliminar.setText("Eliminar");
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        this.eliminar.setFont(myFont1);
        this.eliminar.setForeground(Color.WHITE);
        this.eliminar.setBackground(Color.DARK_GRAY);
        this.eliminar.setBorder(null);
        this.eliminar.setBounds(470,3,100,30);
    }

    private void setBtnCopiar() {
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\copiar.png");
        this.copiar = new JButton(imagen);
        this.copiar.setFont(myFont1);
        this.copiar.setText("Copiar");
        this.copiar.setForeground(Color.WHITE);
        this.copiar.setBackground(Color.DARK_GRAY);
        this.copiar.setBorder(null);
        this.copiar.setBounds(590,3,95,30);
        
    }

    private void setBtnPegar() {
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\pegar.png");
        this.pegar = new JButton(imagen);
        this.pegar.setFont(myFont1);
        this.pegar.setText("Pegar");
        this.pegar.setForeground(Color.WHITE);
        this.pegar.setBackground(Color.DARK_GRAY);
        this.pegar.setBorder(null);
        this.pegar.setBounds(680,3,95,30);
    }
    
    private void setTxtDireccion(){
        this.direccion = new JTextField();
        this.direccion.setBorder(null);
        this.direccion.setBounds(55, 55, 310, 25);
    }
    
    private void setLblRuta(){
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        this.ruta = new JLabel();
        this.ruta.setFont(myFont1);
        this.ruta.setText("Ruta:");
        this.ruta.setForeground(Color.WHITE);
        this.ruta.setBounds(20, 55, 70, 25);
    }
    
    private void setTextCarpetas(){
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        this.carpetasPrincipales = new TextArea();
        this.carpetasPrincipales.setEditable(false);
        this.carpetasPrincipales.setFont(myFont1);
        this.carpetasPrincipales.setBounds(20, 90, 450, 450);
    }
    
    private void setBtnRuta(){
        ImageIcon imagen = new ImageIcon("src\\imagenes\\lupa.png");
        this.btnRuta = new JButton(imagen);
        this.btnRuta.setText("Buscar");
        this.btnRuta.setBounds(370, 55, 100, 25);
    }
    
    private void setTxtContarElementos(){
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        this.txtContarElementos = new JLabel();
        this.txtContarElementos.setFont(myFont1);
        this.txtContarElementos.setForeground(Color.WHITE);
        this.txtContarElementos.setBounds(20, 545, 100, 18);      
    }
    
    private void setTxtBuscarArchivos(){
        this.txtBuscarArchivo = new TextArea();
        this.txtBuscarArchivo.setBounds(680, 90, 285, 100);
    }
    
    private void setTxtBuscar(){
        this.txtBuscar = new JTextField();
        this.txtBuscar.setBorder(null);
        this.txtBuscar.setBounds(680, 55, 285, 25);    
    }
    
    private void setBtnGuardarArchivo(){
        Font myFont1 = new Font("JetBrains Mono", Font.BOLD, 12);
        ImageIcon imagen = new ImageIcon("src\\imagenes\\disquete.png");
        this.btnGuardarArchivo = new JButton(imagen);
        this.btnGuardarArchivo.setFont(myFont1);
        this.btnGuardarArchivo.setBorder(null);
        this.btnGuardarArchivo.setText("Guardar BK");
        this.btnGuardarArchivo.setForeground(Color.WHITE);
        this.btnGuardarArchivo.setBackground(Color.DARK_GRAY);
        this.btnGuardarArchivo.setBounds(860,545,100,18);
    }
    
    public JButton getBtnGuardarArchivo(){
        return btnGuardarArchivo;
    }
    
    public JTextField getTxtBuscar(){
        return txtBuscar;
    }
    
    public TextArea getTxtBuscarArchivos(){
        return txtBuscarArchivo;
    }
    
    public JLabel getTxtContarElementos(){
        return txtContarElementos;
    }
    
    public JButton getBtnRuta(){
        return btnRuta;
    }
    
    public TextArea getTextCarpetas(){
        return carpetasPrincipales;
    }
    
    public JLabel getLblRuta(){
        return ruta;
    }
    
    public JTextField getTxtDireccion(){
        return direccion;
    }

    public JButton getBtnPadre() {
        return padre;
    }

    public JButton getBtnHome() {
        return home;
    }

    public JButton getBtnAgregarCarpeta() {
        return agregarCarpeta;
    }

    public JButton getBtnAgregarTXT() {
        return agregarTXT;
    }

    public JButton getBtnEliminar() {
        return eliminar;
    }

    public JButton getBtnCopiar() {
        return copiar;
    }

    public JButton getBtnPegar() {
        return pegar;
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes\\archivo.png"));
        return retValue;
    }
}