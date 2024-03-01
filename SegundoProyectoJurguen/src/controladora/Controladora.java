/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladora;

import entidades.NodoArbol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Archivo;
import logica.LogicaArbol;
import logica.LogicaLista;
import logica.Utils;
import vista.GuiPrincipal;

/**
 *
 * @author Jurguen
 */
public final class Controladora implements ActionListener, KeyListener {

    //iniciamos variables globales
    private final GuiPrincipal guiPrincipal;
    private final LogicaArbol logica;
    private final LogicaLista logicaLista;
    private final Archivo archivo;
    private NodoArbol nodoActual;
    private NodoArbol nodoEliminar;

    //Constructor de la controladora
    public Controladora() {
        this.guiPrincipal = new GuiPrincipal(); //instanciamos la clase guiPrincipal
        this.logica = new LogicaArbol(); //instanciamos la clase logica arbol
        this.logicaLista = new LogicaLista(); //instanciamos la clase logica lista
        this.archivo = new Archivo();
        this.logica.insertarRaiz(Utils.arbol, "(D:)"); //insertamos una raiz quemada apenas levanta el programa
        guiPrincipal.getTxtDireccion().setText("(D:)>"); //quemamos la direccion en la cual se encuentra al inicio
        this.nodoActual = Utils.arbol.getRaiz(); //iniciamos el nodo actual en la raiz del arbol para poder empezar a insertar
        guiPrincipal.getTxtContarElementos().setText(logica.contarElementos(nodoActual, 0) + " Elementos"); //contamos los elementos de la raiz
        guiPrincipal.getBtnPegar().setEnabled(false);
        inicializador(); //llamamos el metodo
    }

    //Agrego el actionListener a los botones de la interfaz
    public void inicializador() {
        guiPrincipal.getBtnPadre().addActionListener(this);
        guiPrincipal.getBtnHome().addActionListener(this);
        guiPrincipal.getBtnAgregarCarpeta().addActionListener(this);
        guiPrincipal.getBtnAgregarTXT().addActionListener(this);
        guiPrincipal.getBtnEliminar().addActionListener(this);
        guiPrincipal.getBtnCopiar().addActionListener(this);
        guiPrincipal.getBtnPegar().addActionListener(this);
        guiPrincipal.getBtnRuta().addActionListener(this);
        guiPrincipal.getTxtDireccion().addKeyListener(this);
        guiPrincipal.getTxtBuscar().addKeyListener(this);
        guiPrincipal.getBtnGuardarArchivo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si tocamos el boton padre
        if (e.getSource() == guiPrincipal.getBtnPadre()) {
            if (nodoActual != Utils.arbol.getRaiz()) {  //validamos que el nodo actual no sea la raiz
                nodoActual = nodoActual.getPadre(); //el nodo que se encuentra actualmente pasa a ser el padre de ese nodo
                String ruta = guiPrincipal.getTxtDireccion().getText(); //obtenemos la ruta completa
                String rutaSeparada[] = logica.separarRuta(ruta); //separamos la ruta
                String textoNuevo = logica.cortarRuta(rutaSeparada); //Le cortamos la ultima palabra
                guiPrincipal.getTxtDireccion().setText(textoNuevo); //Le pasamos esa direccion sin la ultima palabra al JTextField
                guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual)); //Mostramos el arbol en el JTextArea
                guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); //contamos los elementos y se lo paso al JLabel
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No se puede ir al padre, es la Raiz", "Error no tiene padre", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Si tocamos el boton home
        if (e.getSource() == guiPrincipal.getBtnHome()) {
            nodoActual = Utils.arbol.getRaiz(); //El nodo actual va ser la raiz porque nos volvimos a home
            guiPrincipal.getTxtDireccion().setText("(D:)>"); //Seteamos la direccion quemada
            guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual)); //mostramos el arbol a partir del nodo actual
            guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); //contamos los elementos y se lo paso al Jlabel
        }
        //Si tocamos el boton agregar
        if (e.getSource() == guiPrincipal.getBtnAgregarCarpeta()) {
            String nombre = JOptionPane.showInputDialog(new JFrame(), "Nombre de la carpeta: ", "Nueva Carpeta"); //Pedimos el nombre de la carpeta
            if (nombre != null && !"".equals(nombre)) { //Valido que el nombre no sea null o vacio
                if (logica.validarNombre(nodoActual, nombre)) { //valido el nombre de la carpeta en esa raiz
                    logica.insertar(nombre, Utils.arbol, nodoActual, 1, ""); //Inserto la carpeta en la raiz actual
                    logicaLista.insertarLista(Utils.lista, nombre, nodoActual.getNombre()); //insertamos las carpetas en la lista
                    guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual)); //muestro el arbol
                    guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); //cuento los elementos para actualizarlos
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "No se puede crear esa carpeta", "Nombre Existente", JOptionPane.ERROR_MESSAGE); //En caso que el nombre exista
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No se puede crear esa carpeta", "Nombre Invalido", JOptionPane.ERROR_MESSAGE);
                //En caso que el nombre sea invalido
            }
        }
        //Si tocamos el boton agregarTXT
        if (e.getSource() == guiPrincipal.getBtnAgregarTXT()) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del archivo TXT: "); //Pido el nombre del archivo
            if (nombre != null && !"".equals(nombre)) { //valido que nombre y el texto no sea null o vacio
                if (logica.validarNombre(nodoActual, nombre)) { //validamos el nombre del archivo para saber si existe
                    String texto = JOptionPane.showInputDialog("Ingrese el texto del archivo TXT: "); //Pido el texto del archivo
                    logica.insertar(nombre, Utils.arbol, nodoActual, 0, texto); //insertamos el nodo con la extension txt, por medio del parametro 0
                    logicaLista.insertarLista(Utils.lista, nombre,nodoActual.getNombre());//insertamos los txt en la lista
                    guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual)); //Mostramos el arbol
                    guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); // contamos los elemetos
                } else {
                    //Si el nombre ya existe
                    JOptionPane.showMessageDialog(new JFrame(), "No se puede crear ese archivo", "Nombre Existente", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                //Si el nombre el null o vacio
                JOptionPane.showMessageDialog(new JFrame(), "No se puede crear ese archivo", "Nombre Invalido", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Si tocamos el boton buscar ruta
        if (e.getSource() == guiPrincipal.getBtnRuta()) {
            String textoDireccion = guiPrincipal.getTxtDireccion().getText(); //Obtenemos el texto completo del JTextField
            String[] ruta = logica.separarRuta(textoDireccion); //Aplicamos split al texto y lo pasamos a un vector
            String nuevaRuta = logica.validarCamino(ruta, Utils.arbol.getRaiz(), "", 0); //validamos el camino por medio del vector de palabras
            guiPrincipal.getTxtDireccion().setText(nuevaRuta); //Pasamos al JTextField la nueva ruta correcta
            ruta = logica.separarRuta(nuevaRuta); //La nueva ruta correcta la almacenamos de nuevo
            nodoActual = logica.buscarNodo(ruta, Utils.arbol.getRaiz(), null, 0); //Almacenamos el nodo por medio de la ruta en el nodo actual
            if(nodoActual.getNombre().contains(".txt")){
                guiPrincipal.getTextCarpetas().setText(logica.mostrarTXT(nodoActual));
                guiPrincipal.getTxtContarElementos().setText(String.valueOf(0 + " Elementos"));
            }else{
                guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual));   //mostramos el arbol de ese nodo
                guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); //Contamos los elementos
            }          
        }
        //Si tocamos el boton eliminar
        if (e.getSource() == guiPrincipal.getBtnEliminar()) {
            String nombreCarpeta = JOptionPane.showInputDialog("Ingrese el nombre de la Carpeta que desea eliminar: "); //Pedimos el nombre de la carpeta a eliminar
            if (logica.nodoEliminar(nombreCarpeta, nodoActual) != null) { //Validamos el nodo que se quiere eliminar y el nombre de la carpeta
                int i = JOptionPane.showConfirmDialog(new JFrame(), "Seguro que quieres eliminar la carpeta " + nombreCarpeta, "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (i == 0) {
                    nodoEliminar = logica.nodoEliminar(nombreCarpeta, nodoActual); //Almacenamos el nodo a eliminar en una varible 
                    logica.eliminarElementos(nodoActual, nodoEliminar); //Eliminamos el nodo
                    JOptionPane.showMessageDialog(new JFrame(), "Se elimino la carpeta " + nombreCarpeta, "Eliminacion correcta", JOptionPane.INFORMATION_MESSAGE);
                    guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual)); //Mostramos el arbol nuevamente
                    guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); //Contamos los elementos
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No se encontro esa carpeta", "Nombre Invalido", JOptionPane.WARNING_MESSAGE); //No se encontro la carpeta
            }
        }
        //Si tocamos el boton copiar
        if (e.getSource() == guiPrincipal.getBtnCopiar()) {
            String nombreCarpeta = JOptionPane.showInputDialog("Ingrese el nombre de la Carpeta que desea copiar: "); //Pedimos el nombre de la carpeta a copiar
            if (logica.nodoEliminar(nombreCarpeta, nodoActual) != null) {
                logica.insertarSubArbol(nodoActual, nombreCarpeta);
                guiPrincipal.getBtnPegar().setEnabled(true);
                JOptionPane.showMessageDialog(new JFrame(), "Se copio la carpeta " + nombreCarpeta, "Copia correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No se encontro esa carpeta", "Nombre Invalido", JOptionPane.WARNING_MESSAGE); //No se encontro la carpeta
            }
        }
        //Si tocamos el boton pegar
        if (e.getSource() == guiPrincipal.getBtnPegar()) {
            String ruta = guiPrincipal.getTxtDireccion().getText();
            String[] rutaS = logica.separarRuta(ruta);
            nodoActual = logica.buscarNodo(rutaS, Utils.arbol.getRaiz(), null, 0);
            if (logica.validarNombre(nodoActual, Utils.subArbol.getRaiz().getNombre())) {
                logica.pegarSubArbol(nodoActual);
                JOptionPane.showMessageDialog(new JFrame(), "Se pego la carpeta en " + nodoActual.getNombre(), "Pegado correcto", JOptionPane.INFORMATION_MESSAGE);
                guiPrincipal.getTextCarpetas().setText(logica.mostrarArbol(nodoActual)); //Mostramos el arbol nuevamente
                guiPrincipal.getTxtContarElementos().setText(String.valueOf(logica.contarElementos(nodoActual, 0)) + " Elementos"); //Contamos los elementos
                guiPrincipal.getBtnPegar().setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No se puede pegar ese archivo", "Nombre Existente", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == guiPrincipal.getBtnGuardarArchivo()){
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = fc.showSaveDialog(guiPrincipal);
            
            if(seleccion == JFileChooser.APPROVE_OPTION){
                String ruta = fc.getSelectedFile().getAbsolutePath();
                archivo.arbolBK(ruta,logica.mostrarEstructuraArbol(Utils.arbol.getRaiz()));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Metodo para que cada vez que el usuario digite una letra se ejecute
        if (e.getSource() == guiPrincipal.getTxtBuscar()) {
            if (!guiPrincipal.getTxtBuscar().getText().isEmpty()) { //Si el JtextField no esta vacio
                String palabra = guiPrincipal.getTxtBuscar().getText(); //Almacenamos lo que hay en el JTextField
                String texto = logicaLista.mostrar(Utils.lista, palabra); //Almacenamos lo que nos devuelve la lista
                guiPrincipal.getTxtBuscarArchivos().setText(texto); //Lo mostramos
            } else {
                guiPrincipal.getTxtBuscarArchivos().setText(""); //Si esta vacio limpia
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Metodo para poder darle enter en el JTextFiel de la direccion
        if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            if (!guiPrincipal.getTxtDireccion().getText().isEmpty()) {
                guiPrincipal.getBtnRuta().requestFocus();
                guiPrincipal.getBtnRuta().doClick();
            }
        }
    }
}
