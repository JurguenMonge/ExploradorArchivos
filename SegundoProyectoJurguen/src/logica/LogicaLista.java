/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Lista;
import entidades.NodoLista;

/**
 *
 * @author Jurguen
 */
public class LogicaLista {
    
    //Metodo para validar si la lista esta vacia
    private boolean vacia(Lista lista){
        return lista.getPrimero() == null; //Devuelve si el primero de la lista esta null
    }
    
    //Metodo para insertar en un lista simple
    public void insertarLista(Lista lista, String nombre, String nombrePadre){
        NodoLista nuevo = new NodoLista(nombre, nombrePadre); //Creamos un nodo con el nombre de la carpeta
        if (this.vacia(lista)) { //Si la lista esta vacia
            lista.setPrimero(nuevo); //Seteamos el primero de la lista al nuevo nodo
            lista.setUltimo(nuevo); //Seteamos el ultimo de la lista al nuevo nodo
        } else { //Si la lista ya contiene algo
            lista.getUltimo().setSiguiente(nuevo); //Le decimos que el ultimo apunta al siguiente nodo nuevo
            lista.setUltimo(nuevo); //El ultimo nodo pasa a ser el nuevo
        }
    }
    
    //Metodo para mostrar la lista de carpetas relacionadas a la busqueda
    public String mostrar(Lista lista, String busqueda){
        String mostrar = ""; //Declaramos la variable String
        NodoLista recorre = lista.getPrimero(); //Nodo que va recorrer la lista, apunta al primero de la lista
        
        while(recorre != null){ //Mientras el nodo que recorre sea diferente de null
            if(recorre.getNombre().contains(busqueda)){ //Si donde esta el puntero que recorre la lista contiene la cadena de caracteres que digita el usuario
                mostrar += recorre.toString()+ "\n"; //Concatena ese nombre de ese nodo
            }
            recorre = recorre.getSiguiente(); //Se mueve por la lista
        }
        return mostrar; //Retorna el mostrar
    }
}
