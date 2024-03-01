/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Jurguen
 */
public class Lista {
    
    /*
        Esta es una clase lista que tiene punteros hacia el ultimo y el primero
        que va almacenar las carpetas digitadas por el usuario
    */
    private NodoLista primero;
    private NodoLista ultimo;
    
    //Constructor
    public Lista(){
        this.primero = this.ultimo = null;
    }

    //Sets and Gets
    public NodoLista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }
}
