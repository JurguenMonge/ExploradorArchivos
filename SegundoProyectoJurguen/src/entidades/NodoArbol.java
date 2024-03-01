/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Jurguen
 */
public class NodoArbol {
   /*
        Esta clase es un nodo que contiene punteros hacia el padre, hijoIzq y hermano derecho, ademas tiene dos atributos
        que son el nombre de la carpeta o archivo y el texto en caso de que se un archivo
    */
    private NodoArbol padre;
    private NodoArbol hijoIzq;
    private NodoArbol hermanoDer;
    private String nombre;
    private String texto;
    
    //Constructor para las carpetas
    public NodoArbol(String nombre) {
        this.padre = this.hijoIzq = this.hermanoDer = null;
        this.nombre = nombre;
    }
    
    //Constructor para los txt
    public NodoArbol(String nombre, String texto){
        this.nombre = nombre+".txt";
        this.texto = texto;
    }
    
    //Sets and gets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreCarpeta) {
        this.nombre = nombreCarpeta;
    }
    
    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    public NodoArbol getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArbol hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoArbol getHermanoDer() {
        return hermanoDer;
    }

    public void setHermanoDer(NodoArbol hermanoDer) {
        this.hermanoDer = hermanoDer;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    //ToString
    @Override
    public String toString() {
        String mostrar="";
        if(this.nombre.contains(".txt")){
            mostrar = this.nombre + "\n" + this.texto;
        }else{
            mostrar = this.nombre;
        }
        return mostrar;
    }
    
}
