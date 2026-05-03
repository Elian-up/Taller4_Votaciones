package herencia;

public class Empleado extends Persona {
    int num_legajo;
    String cargo;
    Double sueldo;

    public Empleado() {
    }

    public Empleado(int id, String dni, String nombre, String apellido, String domicilio, String telefono, Double sueldo, String cargo, int num_legajo) {
        super(id, dni, nombre, apellido, domicilio, telefono);
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.num_legajo = num_legajo;
    }
}
