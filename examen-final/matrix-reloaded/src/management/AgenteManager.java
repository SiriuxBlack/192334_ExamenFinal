package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AgenteManager {
    private ArrayList<Agente> agentes;

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void asignarEquipoAAgente() {
        
        // Pedir el ID del agente para asignarle un equipo
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente al que desea asignar un equipo: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        // Buscar al agente en la lista por ID
        Agente agenteEncontrado = null;
        for (Agente agente : agentes) {
            if (agente.getId() == id) {
                agenteEncontrado = agente;
                break;
            }
        }

        // Si no se encuentra el agente
        if (agenteEncontrado == null) {
            System.out.println("Agente no encontrado.");
            return;
        }
        
        if (agenteEncontrado.PerteneceEquipo()) {
            System.out.println("El agente tiene un qeuipo asignado, contacte con sus superiores para cambiarlo");
            return;
            
        }

        // Asignar equipo al agente encontrado
        String equipo = ConsoleUtils.leerTexto("Ingrese el equipo para el agente " + agenteEncontrado.getNombre() + ": ");
        agenteEncontrado.asignarEquipo(equipo);
        System.out.println("Equipo asignado correctamente al agente " + agenteEncontrado.getNombre());
        
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Asignar Equipo a un Agente");
            System.out.println("4. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); 
            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> asignarEquipoAAgente();
                case 4 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}