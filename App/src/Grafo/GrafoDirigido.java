package Grafo;

public class GrafoDirigido {
    private static final int MAX_VERTICES = 500;
    private NodoArista[] adyacencias;
    private boolean[] existe;
    private int numVertices;

    public GrafoDirigido() {
        adyacencias = new NodoArista[MAX_VERTICES];
        existe = new boolean[MAX_VERTICES];
        numVertices = 0;
    }

    // Agrega un vértice
    public void agregarVertice(int id) {
        if (id >= 0 && id < MAX_VERTICES && !existe[id]) {
            existe[id] = true;
            numVertices++;
        }
    }

    // Agrega una arista dirigida origen -> destino
    public void agregarArista(int origen, int destino) {
        if (origen < 0 || origen >= MAX_VERTICES || destino < 0 || destino >= MAX_VERTICES) {
            System.out.println("Error: ID fuera de rango");
            return;
        }
        if (!existe[origen]) agregarVertice(origen);
        if (!existe[destino]) agregarVertice(destino);

        NodoArista nuevo = new NodoArista(destino);
        nuevo.setSiguiente(adyacencias[origen]);
        adyacencias[origen] = nuevo;
    }

    // Obtiene la lista de adyacentes de un vértice
    public NodoArista getAdyacentes(int origen) {
        if (origen < 0 || origen >= MAX_VERTICES) return null;
        return adyacencias[origen];
    }

    // Ordenamiento topológico
    public int[] ordenTopologico() {
        int[] resultado = new int[numVertices];
        int[] estado = new int[MAX_VERTICES]; // 0=no visitado, 1=en pila, 2=procesado
        int[] indice = new int[1];
        indice[0] = numVertices - 1;  // llenamos desde el final

        for (int i = 0; i < MAX_VERTICES; i++) {
            if (existe[i] && estado[i] == 0) {
                if (!dfsTopologico(i, estado, resultado, indice)) {
                    System.out.println("Ciclo detectado – no hay orden topológico");
                    return null;
                }
            }
        }
        return resultado;
    }

    private boolean dfsTopologico(int v, int[] estado, int[] resultado, int[] indice) {
        estado[v] = 1;
        NodoArista actual = adyacencias[v];
        while (actual != null) {
            int vecino = actual.getDestino();
            if (estado[vecino] == 1) return false;
            if (estado[vecino] == 0) {
                if (!dfsTopologico(vecino, estado, resultado, indice)) return false;
            }
            actual = actual.getSiguiente();
        }
        estado[v] = 2;
        resultado[indice[0]] = v;
        indice[0]--;
        return true;
    }

    public int getNumVertices() { return numVertices; }
    public boolean existeVertice(int id) { return id >= 0 && id < MAX_VERTICES && existe[id]; }
}