package Arbol;

public class ListaHijos {
    private NodoLista cabeza;
    private int size;

    public ListaHijos() {
        this.cabeza = null;
        this.size = 0;
    }

    // Agregar un hijo al final de la lista
    public void agregar(NodoArbol hijo) {
        NodoLista nuevo = new NodoLista(hijo);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    // Obtener un hijo por índice
    public NodoArbol obtener(int indice) {
        if (indice < 0 || indice >= size) {
            return null;
        }
        NodoLista actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getHijo();
    }

    // Buscar un hijo por nombre
    public NodoArbol buscarPorNombre(String nombre) {
        NodoLista actual = cabeza;
        while (actual != null) {
            if (actual.getHijo().getNombre().equals(nombre)) {
                return actual.getHijo();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public void paraCada(AccionNodo accion) {
        NodoLista actual = cabeza;
        while (actual != null) {
            accion.ejecutar(actual.getHijo());
            actual = actual.getSiguiente();
        }
    }
}