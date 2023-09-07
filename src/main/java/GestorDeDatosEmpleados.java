import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorDeDatosEmpleados {
    private String nombreArchivo;

    public GestorDeDatosEmpleados(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardarEmpleadosEnTXT(List<Empleado> empleados) {
        try (FileWriter archivoTXT = new FileWriter(nombreArchivo)) {
            for (Empleado empleado : empleados) {
                String tipoEmpleado;
                if (empleado instanceof EmpleadoAsalariado) {
                    tipoEmpleado = "EmpleadoAsalariado";
                } else if (empleado instanceof EmpleadoPorHoras) {
                    tipoEmpleado = "EmpleadoPorHoras";
                } else {
                    tipoEmpleado = "Empleado"; // En caso de una clase de empleado desconocida
                }

                String linea = "Tipo: " + tipoEmpleado + ", Nombre: " + empleado.nombre + ", Salario: $" + empleado.calcularSalario() + "\n";
                archivoTXT.write(linea);
            }
            System.out.println("Datos de empleados guardados exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo TXT: " + e.getMessage());
        }
    }
}
