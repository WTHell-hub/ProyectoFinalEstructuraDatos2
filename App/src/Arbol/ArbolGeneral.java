package Arbol;

public class ArbolGeneral {
    private NodoArbol raiz;

    public ArbolGeneral() { raiz = null; }

    public boolean estaVacio() { return raiz == null; }
    public NodoArbol getRaiz() { return raiz; }
    public void setRaiz(NodoArbol raiz) { this.raiz = raiz; }

    public void insertar(NodoArbol padre, NodoArbol hijo) {
        if (padre == null) {
            if (estaVacio()) raiz = hijo;
            else System.out.println("Error: No se puede insertar sin padre y árbol no vacío.");
        } else padre.agregarHijo(hijo);
    }

    public boolean insertarPorId(int padreId, NodoArbol hijo) {
        NodoArbol padre = buscarPorId(padreId);
        if (padre != null) { padre.agregarHijo(hijo); return true; }
        System.out.println("No se encontró ID " + padreId);
        return false;
    }

    public boolean insertarPorNombre(String padreNombre, NodoArbol hijo) {
        NodoArbol padre = buscarPorNombre(padreNombre);
        if (padre != null) { padre.agregarHijo(hijo); return true; }
        System.out.println("No se encontró nombre " + padreNombre);
        return false;
    }

    public NodoArbol buscarPorId(int id) { return buscarPorIdRecursivo(raiz, id); }
    private NodoArbol buscarPorIdRecursivo(NodoArbol actual, int id) {
        if (actual == null) return null;
        if (actual.getId() == id) return actual;
        ListaHijos hijos = actual.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            NodoArbol encontrado = buscarPorIdRecursivo(hijos.obtener(i), id);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    public NodoArbol buscarPorNombre(String nombre) { return buscarPorNombreRecursivo(raiz, nombre); }
    private NodoArbol buscarPorNombreRecursivo(NodoArbol actual, String nombre) {
        if (actual == null) return null;
        if (actual.getNombre().equals(nombre)) return actual;
        ListaHijos hijos = actual.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            NodoArbol encontrado = buscarPorNombreRecursivo(hijos.obtener(i), nombre);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    public void recorrerPreorden(AccionNodo accion) {
        recorrerPreordenRecursivo(raiz, accion);
    }
    private void recorrerPreordenRecursivo(NodoArbol nodo, AccionNodo accion) {
        if (nodo == null) return;
        accion.ejecutar(nodo);
        ListaHijos hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            recorrerPreordenRecursivo(hijos.obtener(i), accion);
        }
    }

    public void recorrerPostorden(AccionNodo accion) {
        recorrerPostordenRecursivo(raiz, accion);
    }
    private void recorrerPostordenRecursivo(NodoArbol nodo, AccionNodo accion) {
        if (nodo == null) return;
        ListaHijos hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            recorrerPostordenRecursivo(hijos.obtener(i), accion);
        }
        accion.ejecutar(nodo);
    }

    public void imprimirArbol() {
        imprimirArbolRecursivo(raiz, 0);
    }
    private void imprimirArbolRecursivo(NodoArbol nodo, int nivel) {
        if (nodo == null) return;
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println(nodo.getId() + " - " + nodo.getNombre());
        ListaHijos hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            imprimirArbolRecursivo(hijos.obtener(i), nivel + 1);
        }
    }

    public int contarNodos() { return contarNodosRecursivo(raiz); }
    private int contarNodosRecursivo(NodoArbol nodo) {
        if (nodo == null) return 0;
        int contador = 1;
        ListaHijos hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            contador += contarNodosRecursivo(hijos.obtener(i));
        }
        return contador;
    }
}