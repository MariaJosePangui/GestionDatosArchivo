
class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    double calcularSalario() {
        return salarioBase;
    }
}
