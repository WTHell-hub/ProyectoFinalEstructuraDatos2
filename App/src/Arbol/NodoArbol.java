package Arbol;

public class NodoArbol {
    private int id;
    private String nombre;
    private ListaHijos hijos;

    public NodoArbol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.hijos = new ListaHijos();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaHijos getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoArbol hijo) {
        hijos.agregar(hijo);
    }

    public NodoArbol buscarHijoPorNombre(String nombre) {
        return hijos.buscarPorNombre(nombre);
    }

    public int cantidadHijos() {
        return hijos.size();
    }
}