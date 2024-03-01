/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Jurguen
 */
public class NodoLista {
    /*
        Esta clase contiene un nodo que forma una lista simple con un puntero siguiente y
        va contener cada uno de los nombres de las carpetas que digita el usuario
        para luego listarlos
    */
    private NodoLista siguiente;
    private String nombrePadre;
    private String nombre;
    
    //Constructor
    public NodoLista(String nombre, String nombrePadre){
        this.siguiente = null;
        this.nombre = nombre;
        this.nombrePadre = nombrePadre;
    }

    //Set and Get
    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    @Override
    public String toString() {
        return nombrePadre + " -> " + nombre;
    }  
}
