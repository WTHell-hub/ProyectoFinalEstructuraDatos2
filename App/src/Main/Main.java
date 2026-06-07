package Main;

import Integracion.PlanificadorEstudios;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        PlanificadorEstudios planificador = new PlanificadorEstudios();
        cargarDatosEjemplo(planificador);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== PLANIFICADOR DE ESTUDIOS =====");
            System.out.println("1. Mostrar árbol jerárquico de materias");
            System.out.println("2. Agregar nueva materia");
            System.out.println("3. Agregar prerrequisito");
            System.out.println("4. Ver prerrequisitos de una materia");
            System.out.println("5. Mostrar orden topológico de estudio");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    planificador.getArbol().imprimirArbol();
                    break;
                case 2:
                    System.out.print("ID de la materia: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("ID del padre (0 si es raíz): ");
                    int idPadre = scanner.nextInt();
                    planificador.agregarMateria(id, nombre, idPadre == 0 ? null : idPadre);
                    break;
                case 3:
                    System.out.print("ID de la materia que requiere prerrequisito: ");
                    int idMat = scanner.nextInt();
                    System.out.print("ID del prerrequisito: ");
                    int idPre = scanner.nextInt();
                    planificador.agregarPrerrequisito(idMat, idPre);
                    break;
                case 4:
                    System.out.print("ID de la materia: ");
                    int idMostrar = scanner.nextInt();
                    planificador.mostrarPrerrequisitos(idMostrar);
                    break;
                case 5:
                    planificador.mostrarOrdenTopologico();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
        scanner.close();
    }

    private static void cargarDatosEjemplo(PlanificadorEstudios p) {
        // Árbol: Facultad -> Departamento -> Materias
        p.agregarMateria(1, "Informática", null); // raíz
        p.agregarMateria(2, "Programación", 1);
        p.agregarMateria(3, "Matemáticas", 1);
        p.agregarMateria(4, "Programación I", 2);
        p.agregarMateria(5, "Estructura de Datos I", 2);
        p.agregarMateria(6, "Estructura de Datos II", 2);
        p.agregarMateria(7, "Álgebra", 3);
        p.agregarMateria(8, "Cálculo", 3);

        // Grafo de prerrequisitos
        p.agregarPrerrequisito(5, 4);  // ED I requiere Prog I
        p.agregarPrerrequisito(6, 5);  // ED II requiere ED I
        p.agregarPrerrequisito(6, 7);  // ED II requiere Álgebra (por decir)
        p.agregarPrerrequisito(8, 7);  // Cálculo requiere Álgebra
    }
}