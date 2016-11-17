package modelo;

public class Clientes extends Persona {

    int idCliente;

    public Clientes() {
        super();
    }

    public Clientes(String nombre, String apellido, int cedula,
            int telefono) {
        super(nombre, apellido, cedula, telefono);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método encargado de devolver los datos de un cliente, para insertarlos
     * después al archivo.
     * @return 
     */
    @Override
    public String toString() {
        return super.getNombre() + " - " + super.getApellido() + " - " + super.getCedula() + " - " + super.getTelefono()+"\n";
    }

}
