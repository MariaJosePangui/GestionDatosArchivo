
class EmpleadoPorHoras extends Empleado {
    private double salarioPorHora;
    private double horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double salarioPorHora, double horasTrabajadas) {
        super(nombre, 0); // El salario base no se usa en este caso
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    double calcularSalario() {
        return salarioPorHora * horasTrabajadas;
    }
}