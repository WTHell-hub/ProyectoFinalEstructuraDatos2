package Arbol;

public class NodoLista {
    private NodoArbol hijo;
    private NodoLista siguiente;

    public NodoLista(NodoArbol hijo) {
        this.hijo = hijo;
        this.siguiente = null;
    }

    public NodoArbol getHijo() {
        return hijo;
    }

    public void setHijo(NodoArbol hijo) {
        this.hijo = hijo;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}