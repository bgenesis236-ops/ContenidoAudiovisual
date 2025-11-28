package app.view;

import app.controller.ContentController;
import app.model.ContenidoAudiovisual;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner sc = new Scanner(System.in);
    private final ContentController controller;

    public ConsoleView(ContentController controller) {
        this.controller = controller;
    }

    public void start() {

        try { 
            controller.load(); 
            System.out.println("Datos cargados correctamente.\n");
        } catch (Exception e) {
            System.out.println("No se pudo cargar archivo CSV. Se iniciará vacío.");
        }

        boolean run = true;
        while (run) {

            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar Película");
            System.out.println("2. Agregar Serie");
            System.out.println("3. Agregar Documental");
            System.out.println("4. Listar Todo el Contenido");
            System.out.println("5. Guardar en Archivo CSV");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            String option = sc.nextLine();

            switch (option) {
                case "1": addPelicula(); break;
                case "2": addSerie(); break;
                case "3": addDocumental(); break;
                case "4": listAll(); break;
                case "5": save(); break;
                case "6": 
                    System.out.println("Saliendo del sistema...");
                    run = false; 
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    // ======================================================
    //      MÉTODOS DE MENÚ
    // ======================================================

    private void addPelicula() {
        System.out.println("\n=== Nueva Película ===");

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Género: ");
        String genero = sc.nextLine();

        System.out.print("Año: ");
        int anio = readInt();

        System.out.print("Duración (minutos): ");
        int duracion = readInt();

        System.out.print("Director: ");
        String director = sc.nextLine();

        controller.addPelicula(titulo, genero, anio, duracion, director);

        System.out.println("Película agregada correctamente.");
    }

    private void addSerie() {
        System.out.println("\n=== Nueva Serie ===");

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Género: ");
        String genero = sc.nextLine();

        System.out.print("Año: ");
        int anio = readInt();

        controller.addSerie(titulo, genero, anio);

        System.out.println("Serie agregada correctamente.");
    }

    private void addDocumental() {
        System.out.println("\n=== Nuevo Documental ===");

        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Género: ");
        String genero = sc.nextLine();

        System.out.print("Año: ");
        int anio = readInt();

        System.out.print("Tema: ");
        String tema = sc.nextLine();

        System.out.print("Investigador Principal: ");
        String investigador = sc.nextLine();

        controller.addDocumental(titulo, genero, anio, tema, investigador);

        System.out.println("Documental agregado correctamente.");
    }

    private void listAll() {
        System.out.println("\n=== Lista de Contenidos ===");

        List<ContenidoAudiovisual> lista = controller.getAll();

        if (lista.isEmpty()) {
            System.out.println("No hay contenidos registrados.");
            return;
        }

        lista.forEach(System.out::println);
    }

    private void save() {
        try {
            controller.save();
            System.out.println("Datos guardados correctamente en el archivo CSV.");
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // ======================================================
    //     MÉTODO AUXILIAR PARA VALIDAR NÚMEROS
    // ======================================================

    private int readInt() {
        while (true) {
            try {
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Valor no válido. Ingrese un número: ");
            }
        }
    }
}
