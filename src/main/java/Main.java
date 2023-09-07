import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del empleado o escriba 'salir' para terminar: ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("¿Es un empleado asalariado? (Sí/No): ");
            String tipoEmpleado = scanner.nextLine();

            Empleado empleado;

            if (tipoEmpleado.equalsIgnoreCase("Sí")) {
                System.out.println("Ingrese el salario base del empleado: ");
                double salarioBase = Double.parseDouble(scanner.nextLine());
                empleado = new EmpleadoAsalariado(nombre, salarioBase);
            } else if (tipoEmpleado.equalsIgnoreCase("No")) {
                System.out.println("Ingrese el salario por hora del empleado: ");
                double salarioPorHora = Double.parseDouble(scanner.nextLine());

                System.out.println("Ingrese las horas trabajadas por el empleado: ");
                double horasTrabajadas = Double.parseDouble(scanner.nextLine());

                empleado = new EmpleadoPorHoras(nombre, salarioPorHora, horasTrabajadas);
            } else {
                System.out.println("Respuesta no válida. Por favor, responda 'Sí' o 'No'.");
                continue; // Regresar al inicio del bucle
            }

            listaEmpleados.add(empleado);
        }

        scanner.close();

        // Guardar los datos en un archivo TXT
        GestorDeDatosEmpleados gestor = new GestorDeDatosEmpleados("empleados.txt");
        gestor.guardarEmpleadosEnTXT(listaEmpleados);
    }
}
