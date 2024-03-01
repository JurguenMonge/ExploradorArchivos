/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entidades.Arbol;
import entidades.NodoArbol;


/**
 *
 * @author Jurguen
 */
public class LogicaArbol {
    
    public void LogicaArbol(){
    }
    
    //Metodo para verificar si el arbol esta vacio
    private boolean vacio(Arbol arbol){
        return arbol.getRaiz() == null; //si la raiz del arbol es null
    }
    
    //Metodo para insertar la raiz principal de manera quemada
    public void insertarRaiz (Arbol arbol, String texto){   
        NodoArbol nuevo = new NodoArbol(texto);  
        if(this.vacio(arbol)){ // si el arbol esta vacio
            arbol.setRaiz(nuevo); //le pasamos la raiz
        }
    } 
    
    //Metodo para insertar un hijo, le paso el Nodo actual e inserta en ese nodo
    public void insertar(String nombreCarpeta, Arbol arbol, NodoArbol padre, int carpeta, String texto) {
        //Si el int es 1, entonces hacemos un constructor del NodoArbol para carpeta
        if (carpeta == 1) {
            //Creo el nodo hijo con el nombre de la carpeta
            NodoArbol hijo = new NodoArbol(nombreCarpeta);
            
            if (this.vacio(arbol)) {//verifico si el arbol esta vacio
                arbol.setRaiz(hijo);
            } else {//si no esta vacio
                if (padre.getHijoIzq() == null) {//verifico si no tiene hijo izquierdo si no tiene le seteo el nodo
                    padre.setHijoIzq(hijo);
                } else if (padre.getHijoIzq() != null) {//si tiene hijo izq entonces empiezo a recorrer los hermanos y seteo el hijo
                    NodoArbol aux = padre.getHijoIzq(); //Pasamos la referencia del hijo izq a un nodo aux
                    while (aux != null) { //Mientras ese nodo aux sea diferente de null
                        if (aux.getHermanoDer() == null) { // si el hermano derecho del aux es null
                            break; //rompe el ciclo
                        }
                        aux = aux.getHermanoDer(); //Se mueve por la lista
                    }
                    aux.setHermanoDer(hijo); //setemaos el hermano derecho, el hijo
                }
                hijo.setPadre(padre); //seteamos el padre
            }
        }else{
            //En caso de que el int no es sea 1, creamos un NodoArbol para un archivo .txt
            NodoArbol hijo = new NodoArbol(nombreCarpeta, texto); //Creamos el nodo con el nombre del archivo y texto que contiene en caso de ser .txt
            if (this.vacio(arbol)) {//verifico si el arbol esta vacio
                arbol.setRaiz(hijo);
            } else {//si no esta vacio
                if (padre.getHijoIzq() == null) {//verifico si no tiene hijo izquierdo si no tiene le seteo el nodo
                    padre.setHijoIzq(hijo); 
                } else if (padre.getHijoIzq() != null) {//si tiene hijo izq entonces empiezo a recorrer los hermanos y seteo el hijo
                    NodoArbol aux = padre.getHijoIzq(); //Nodo aux que va ser igual al hijo izq
                    while (aux != null) { //Mientras aux sea diferente de null
                        if (aux.getHermanoDer() == null) { //si el hermano derecho del aux es null
                            break; //rompe el ciclo
                        }
                        aux = aux.getHermanoDer(); //Se mueve por la lista
                    }
                    aux.setHermanoDer(hijo); //setemaos el hermano derecho, el hijo
                }
                hijo.setPadre(padre); //seteamos el padre
            }  
        }
    }
    
    //Metodo para eliminar una carpeta 
    public void eliminarElementos(NodoArbol raiz, NodoArbol eliminar){//Le pasamos el nodo raiz de la carpeta a eliminar, y pasamos un nodo el cual contiene la carpeta a eliminar
        if(raiz.getHijoIzq() != null){//Verificamos que el hijo de la raiz que pasamos no sea nulo
            if(raiz.getHijoIzq().getNombre().equalsIgnoreCase(eliminar.getNombre())){ //Si el nombre que pasamos es el hijo izquierdo 
                NodoArbol aux = raiz.getHijoIzq(); //Creamos un nodo auxiliar para pasarle la posicion del hijo izquierdo de la raiz
                raiz.setHijoIzq(aux.getHermanoDer()); //Eliminamos la referencia del primer hijo izquierdo y se la pasamos al hermano
            }else{ //En caso que no sea el hijo izquierdo el que se quiere eliminar
                NodoArbol aux = raiz.getHijoIzq();  //Creamos un nodo auxiliar que apunte al hijo izquierdo para recorrer la lista de hermanos
                while(aux != null){ //Empezamos el recorrido
                    if(aux.getHermanoDer().getNombre().equalsIgnoreCase(eliminar.getNombre())){ //Si el hermano de la par tiene el mismo nombre de la carpeta a eliminar
                        NodoArbol aux2 = aux.getHermanoDer(); //Tenemos un nodo aux2 que apunta al hermano de la par del aux
                        aux.setHermanoDer(aux2.getHermanoDer()); //Al nodo aux le pasamos la referencia de ese aux2 del hermano
                        aux2.setHermanoDer(null); //Y el nodo que vamos a eliminar le pasamos la referencia a null
                        break;//rompemos el ciclo una vez que se elimina
                    }
                    aux = aux.getHermanoDer();//Recorrido de lista
                }
            }
        }
    }
    
    //Cuenta los elementos de la raiz 
    public int contarElementos(NodoArbol actual, int contador){//Le pasamos el nodo actual en el que se encuentra el usuario
        if (actual != null) { // si ese nodo no es null
            if (actual.getHijoIzq() != null) { //y el primer hijo tampoco es null
                NodoArbol aux = actual.getHijoIzq(); // Creamos un nodo aux que apunte al hijo
                    while (aux != null) { //Empezamos a recorrer los hermanos
                        contador++; //Cada vez que entra se le suma uno
                        aux = aux.getHermanoDer();//se empieza el ciclo hasta que termine la lista de hermanos
                    }
            }
        }
        return contador;//Nos retorna el contador
    }
    
    //Este metodo me encuentra el nodo que queremos eliminar y lo almacenamos para luego encontrar ese nombre de carpeta en el metodo de eliminar elementos
    public NodoArbol nodoEliminar(String nombreCarpeta, NodoArbol raiz){
        if(raiz != null){ //Si la raiz no es nula y el hijo tampoco
            if(raiz.getHijoIzq() != null){ 
                if(raiz.getHijoIzq().getNombre().equalsIgnoreCase(nombreCarpeta)){ //verificamos si el hijo izq es el que se busca
                    return raiz.getHijoIzq(); //Si es entonces devolvemos ese puntero, nodo o  direccion de memoria
                }else{ // Si no es el hijo izq
                    NodoArbol aux = raiz.getHijoIzq(); //pasamos la referecia del hijo izq a un nodo aux
                    while(aux != null){ // empezamos el recorrido de hermanos
                        if(aux.getNombre().equalsIgnoreCase(nombreCarpeta)){ //si en alguno de los hermanos encuenta el nombre de la carpeta
                            return aux; // nos retorna puntero, nodo o  direccion de memoria
                        }
                        aux = aux.getHermanoDer(); //empieza a moverse por la lista
                    }
                }
            }
        }
        return null; //si el nodo a buscar no se encontro en todo los hijos de la raiz, entonces nos devuelve null
    }
    
    //Este metodo me va mantener en el ultimo nodo que es valido, el nodoActual de controladora
    public NodoArbol buscarNodo(String[] ruta, NodoArbol raiz, NodoArbol encontrar, int contador){
        if (raiz != null) {
            contador++; //Un contador para aumentar lo que tiene el vector en cada pos
            encontrar = raiz; //actualizamos el nodo al que lleva en el parametro
            if (raiz.getHijoIzq() != null) { //verificamos que el hijo izq no sea null
                NodoArbol aux = raiz.getHijoIzq(); //Nodo aux con referencia al que lleva por parametro
                if (contador < ruta.length) { //Contador para verificar que no se desborda el vector
                    while (aux != null) { //Mientras el nodo sea != null
                        if (aux.getNombre().equalsIgnoreCase(ruta[contador])) { //verificamos que el nombre del nodo y lo que lleva el vector es el mismo
                            encontrar = buscarNodo(ruta, aux, encontrar, contador); //Si es asi lo almacenamos en el nodo que se quiere encontrar
                        }
                        aux = aux.getHermanoDer(); //recorremos el nodo raiz
                    }
                }
            }
        }
        return encontrar; //retorna el ultimo nodo encontrado
    }
    
     //Valida que el nombre de la carpeta no se repita en la raiz
    public boolean validarNombre(NodoArbol actual, String nombre){
        if (actual.getHijoIzq() != null) { //verificamos si el hijo izq no es null
            if (actual.getHijoIzq().getNombre().equalsIgnoreCase(nombre+".txt") || actual.getHijoIzq().getNombre().equalsIgnoreCase(nombre)) { //Si el nombre es igual al hijo izq retorna false, es decir existe el nombre
                return false; // retornamos false, es decir el nombre existe y no se puede agregar esa carpeta o archivo
            } else { // si no es el hijo izq
                NodoArbol aux = actual.getHijoIzq(); //una referencia a hijo izq para recorrer los hermanos
                while (aux != null) {//empezamos el recorrido
                    if (aux.getNombre().equalsIgnoreCase(nombre+".txt") || actual.getHijoIzq().getNombre().equalsIgnoreCase(nombre)) { //si en alguno de los hermanos encontramos el nombre
                        return false; // retornamos false, es decir el nombre existe y no se puede agregar esa carpeta o archivo
                    }
                    aux = aux.getHermanoDer();//se mueve por la lista
                }
            }
        }
        return true;//si no encontro el nombre en ningun hijo entonces retorna true, y deja insertar el nodo
    }
    
    //Muestra el arbol, le pasamos la raiz y luego va recorriendo sus hijos
    public String mostrarArbol(NodoArbol raiz){
        String mostrar = ""; //iniciamos el String para concatenar los nodos.toString
        if (raiz != null) { //si el nodo que pasamos no es null
            if (raiz.getHijoIzq() != null) { //y si el hijo izq no es null
                NodoArbol aux = raiz.getHijoIzq(); //referencia al hijo izq
                while (aux != null) { //recorre la lista de hermanos
                    mostrar += aux.getNombre()+ "\n"; //concatena el toString de cada nodo
                    aux = aux.getHermanoDer(); //se va moviendo entre nodos, en la lista de hermanos
                }
            }
        }
        return mostrar; //retornamos el string de todos los nodos
    }
    
    //Muestra los nodo txt
    public String mostrarTXT(NodoArbol raiz){
        return raiz.getTexto(); //muestra el texto del nodo
    }
    
    public String[] separarRuta(String texto){
        return texto.split(">"); //metodo para separar el texto ruta, por medio de >
    }
    
    //Me corta la ruta para cuando le da al boton padre
    public String cortarRuta(String[] ruta){
        String nuevo = ""; //El nuevo texto a devolver
        for (int i = 0; i < ruta.length - 1; i++) { //recorro el vector de palabras, pero elimino la ultima palabra
            nuevo += ruta[i] + ">"; //concatena cada palabra con la >
        }
        return nuevo; //retorna el nuevo texto completo sin la ultima palabra
    }
    
    //Metodo que nos devuelve la ruta ultima ruta valida
    public String validarCamino(String[] rutaSeparada, NodoArbol raiz, String ruta, int contador){
        if (raiz != null) { //verifica que el nodo raiz que pasamos no esta null
            contador++; //aumentamos el contador para el vector
            ruta += raiz.getNombre()+">"; //obtiene el nombre de cada nodo recursivo y le concatena >
            if (raiz.getHijoIzq() != null) { //si el hijo izq el diferente de null
                NodoArbol aux = raiz.getHijoIzq(); // crea una referencia en nodo hijo izq
                if (contador < rutaSeparada.length) { // si el contador es menor que el vector para que no se desborde
                    while (aux != null) { // empieza a recorrer la lista de hijo y hermanos
                        if (aux.getNombre().equalsIgnoreCase(rutaSeparada[contador])) { //si el nodo auxiliar tiene el nombre que lo que lleva el vector en esa posicion
                            ruta = validarCamino(rutaSeparada, aux, ruta, contador); //ruta va ser igual al nodo aux.getNombre
                        }
                        aux = aux.getHermanoDer(); //empieza a moverse por la lista
                    }
                }
            }
        }
        return ruta; //al final nos devuelve la ruta valida
    }
    
    //Metodo que crea un subArbol para luego copiarlo en otro lugar
    public void insertarSubArbol(NodoArbol raiz, String nombreCarpeta) {
        if (raiz != null) { //Si la raiz que pasamos no esta null
            if (raiz.getHijoIzq().getNombre().equalsIgnoreCase(nombreCarpeta)) { //Si el hijo izq de la raiz tiene el nombre de la carpeta que buscamos
                this.insertarRaiz(Utils.subArbol, raiz.getHijoIzq().getNombre()); //Esa seria la raiz de nuestro sub arbol
                NodoArbol aux = raiz.getHijoIzq(); //Creamos un nodo aux donde apunte a la raiz.getHijoIzq
                NodoArbol aux2 = aux.getHijoIzq(); //Otro nodo aux2 para que apunte al hijo izq del anterior aux
                while (aux2 != null) { //Empezamos a recorrer el hijo y hermamos y los vamos insertando como hijos de la raiz del subArbol
                    if (aux2.getNombre().contains(".txt")) { //Si contiene un .txt es un archivo
                        if(this.validarNombre(Utils.subArbol.getRaiz(), aux2.getNombre())){ //Valida que el nombre no este repetido
                            String nombre = aux.getNombre().replace(".txt", ""); //Reemplazo para que no se repita
                            insertar(nombre, Utils.subArbol, Utils.subArbol.getRaiz(), 0, aux2.getTexto()); //Inserta
                        }
                    } else { //Si no es .txt
                        if(this.validarNombre(Utils.subArbol.getRaiz(), aux2.getNombre())){ //Valida el nombre de la carpeta
                            insertar(aux2.getNombre(), Utils.subArbol, Utils.subArbol.getRaiz(), 1, ""); //Inserta la carpeta en el subArbol
                        }
                    }
                    aux2 = aux2.getHermanoDer(); //Recorre todos los hermanos
                }
            } else { //Si lo que se quiere copiar no es el hijo izq de la raiz debemos recorrer a los hermanos
                NodoArbol aux = raiz.getHijoIzq().getHermanoDer(); //Un puntero que empieze en el hermano del hijo izq
                while (aux != null) { // Mientras sea diferente de null recorra
                    if (aux.getNombre().equalsIgnoreCase(nombreCarpeta)) { //si ese hermano es el que se busca entonces
                        this.insertarRaiz(Utils.subArbol, nombreCarpeta); //Se inserta como la raiz del subarbol
                    }
                    NodoArbol aux2 = aux.getHijoIzq(); //Un aux2 que apunte al hijo izq del aux
                    while (aux2 != null) { //Mientras el aux2 sea diferente de null recorra
                        if (aux.getNombre().contains(".txt")) { //Si el archivo contiene .txt, entonces 
                            String nombre = aux.getNombre().replace(".txt", ""); //Reemplazo para que no se repita
                            insertar(nombre, Utils.subArbol, Utils.subArbol.getRaiz(), 0, aux.getTexto()); //Inserta
                        } else {
                            insertar(aux2.getNombre(), Utils.subArbol, Utils.subArbol.getRaiz(), 1, ""); //Inseta carpeta
                        }
                        aux2 = aux2.getHermanoDer(); //Empieza a recorrer los hermanos de la raiz
                    }
                    aux = aux.getHermanoDer(); //Recorre todos los hermanos de la raiz principal
                }
            }
        }
    }
    
    //Metodo para pegar el subArbol en un nodo raiz
    public void pegarSubArbol(NodoArbol raiz){
        if(raiz != null){//Se verifica que el nodo no este null
            if(raiz.getHijoIzq() == null){ //Si no tiene hijo izq
                raiz.setHijoIzq(Utils.subArbol.getRaiz()); //El sub arbol se setea al hijo izq de la raiz
                Utils.subArbol.getRaiz().setPadre(raiz); //Le pasamos el padre a la raiz del sub arbol
            }else{ //Si tiene hijo izq
                NodoArbol aux = raiz.getHijoIzq(); //Pasamos la referencia a aux del hijo izq
                while(aux != null){ //Mientras sea diferente de null
                    if(aux.getHermanoDer() == null){ //Si el siguiente nodo esta vacio le seteamos el arbol
                        aux.setHermanoDer(Utils.subArbol.getRaiz()); //seteo
                        Utils.subArbol.getRaiz().setPadre(aux); //Le pasamos el padre a la raiz del arbol
                    } 
                    aux = aux.getHermanoDer(); //Recorremos los nodos
                }
            }
        }
    }
    
    //Muestra la estructura del arbol en el backup
    public String mostrarEstructuraArbol(NodoArbol nodo){
        String recorrido = "";
        if(nodo != null){ //Si el nodo que va en el recorrido no es null
            if(nodo.getPadre()!=null){ //Si tiene padre 
                if (nodo.getNombre().contains(".txt")) {
                    recorrido += nodo.getPadre() + " -> " + nodo.getNombre() + " Contenido: " + nodo.getTexto() + "\n"; //Muestra el padre, el hijo y el contenido
                } else {
                    recorrido += nodo.getPadre() + " -> " + nodo.getNombre() + "\n"; //Muestra el padre y el hijo
                }
            }
            recorrido += mostrarEstructuraArbol(nodo.getHijoIzq());  //Llama el metodo recursivo
            recorrido += mostrarEstructuraArbol(nodo.getHermanoDer()); //Llama el metodo recursivo
        }
        return recorrido; //Devuelve el recorrido
    }
}