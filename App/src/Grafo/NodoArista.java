package Grafo;

public class NodoArista {
    private int destino;
    private NodoArista siguiente;

    public NodoArista(int destino) {
        this.destino = destino;
        this.siguiente = null;
    }

    public int getDestino() { return destino; }
    public void setDestino(int destino) { this.destino = destino; }
    public NodoArista getSiguiente() { return siguiente; }
    public void setSiguiente(NodoArista siguiente) { this.siguiente = siguiente; }
}