/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Jurguen
 */
public class Arbol {
    //Clase arbol donde se tiene referencia a su raiz
    NodoArbol raiz;
    
    //Constructor
    public Arbol() {
        this.raiz = null;
    }
    
    //Set y Get
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
}
