package Integracion;

import Arbol.ArbolGeneral;
import Arbol.NodoArbol;
import Grafo.GrafoDirigido;
import Grafo.NodoArista;

public class PlanificadorEstudios {
    private ArbolGeneral arbol;
    private GrafoDirigido grafo;

    public PlanificadorEstudios() {
        arbol = new ArbolGeneral();
        grafo = new GrafoDirigido();
    }

    public ArbolGeneral getArbol() {
        return arbol;
    }

    public GrafoDirigido getGrafo() {
        return grafo;
    }

    // Agrega una materia al árbol y al grafo como vértice
    public void agregarMateria(int id, String nombre, Integer padreId) {
        NodoArbol nueva = new NodoArbol(id, nombre);
        if (padreId == null) {
            arbol.setRaiz(nueva);
        } else {
            arbol.insertarPorId(padreId, nueva);
        }
        grafo.agregarVertice(id);
    }

    // Agrega prerrequisito: materiaA necesita materiaB
    public void agregarPrerrequisito(int idMateria, int idPrerrequisito) {
        grafo.agregarArista(idMateria, idPrerrequisito);
    }

    // Muestra el orden topológico de estudio
    public void mostrarOrdenTopologico() {
        int[] orden = grafo.ordenTopologico();
        if (orden == null) {
            System.out.println("No se puede generar orden: hay ciclos en los prerrequisitos.");
            return;
        }
        System.out.println("Orden de estudio recomendado:");
        for (int i = 0; i < orden.length; i++) {
            NodoArbol nodo = arbol.buscarPorId(orden[i]);
            String nombre = (nodo != null) ? nodo.getNombre() : "Desconocido";
            System.out.println((i+1) + ". " + nombre + " (ID: " + orden[i] + ")");
        }
    }

    // Muestra prerrequisitos de una materia
    public void mostrarPrerrequisitos(int idMateria) {
        NodoArista aristas = grafo.getAdyacentes(idMateria);
        if (aristas == null) {
            System.out.println("La materia no tiene prerrequisitos.");
            return;
        }
        System.out.println("Prerrequisitos de " + idMateria + ":");
        NodoArista actual = aristas;
        while (actual != null) {
            int prereqId = actual.getDestino();
            NodoArbol nodo = arbol.buscarPorId(prereqId);
            String nombre = (nodo != null) ? nodo.getNombre() : "Desconocido";
            System.out.println(" - " + nombre + " (ID: " + prereqId + ")");
            actual = actual.getSiguiente();
        }
    }
}