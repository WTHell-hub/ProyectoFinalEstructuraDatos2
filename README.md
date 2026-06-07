# ProyectoFinalEstructuraDatos2
Planificador de Estudios con Prerrequisitos

Proyecto final para la asignatura Estructura de Datos II (Ingenieria Informatica, 2º año). Implementa un sistema que organiza jerarquicamente las materias de una carrera y modela sus prerrequisitos utilizando un arbol general y un grafo dirigido (DAG) con ordenamiento topologico.

Caracteristicas

- Arbol general: insercion de nodos (materias, areas, departamentos), busqueda por ID o nombre, recorridos en preorden y postorden, visualizacion jerarquica con indentacion.
- Grafo dirigido (lista de adyacencia casera): agregar vertices y aristas (prerrequisitos), ordenamiento topologico con deteccion de ciclos (DFS).
- Integracion: los mismos IDs conectan el arbol y el grafo. Consultar prerrequisitos de una materia. Generar una secuencia de estudio recomendada respetando las dependencias.
- Menu interactivo por consola que permite probar todas las operaciones.

Tecnologias

Java (sin usar java.util.*, todas las estructuras implementadas manualmente). Linea de comandos (terminal).

Estructura del codigo

PlanEstudio/
 - AccionNodo.java
 - NodoLista.java
 - ListaHijos.java
 - NodoArbol.java
 - ArbolGeneral.java
 - NodoArista.java
 - GrafoDirigido.java
 - PlanificadorEstudios.java
 - Main.java

Como ejecutar

1. Compilar: javac *.java
2. Ejecutar: java Main
3. Seguir las opciones del menu para mostrar el arbol, agregar materias y prerrequisitos, consultar dependencias y calcular el orden topologico.

Ejemplo de uso

Al cargar los datos de ejemplo, el programa muestra un menu y al seleccionar la opcion 1 imprime el arbol con indentacion.

Licencia

Trabajo academico – libre para uso educativo.

Autor

Wandiliel Torres Hernández
