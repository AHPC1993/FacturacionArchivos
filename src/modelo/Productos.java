package modelo;

public class Productos extends Categorias {

    private int referencia;
    private String nombreProducto;
    private double precio;
    private String talla;
    private String color;
    private int cantidadDisponible;

    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Productos(int idCategoria, String nombreCategoria, int referencia, String nombreProducto, double precio,
            String talla, String color, int cantidadDisponible) {
        super(idCategoria, nombreCategoria);
        this.referencia = referencia;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.talla = talla;
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;

    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método encargado de devolver los datos de un producto, para insertarlos
     * después al archivo.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.getNombreCategoria() + " - " + getReferencia() + " - " + getNombreProducto() + " - " + getTalla() + " - " + getColor() + " - " + getPrecio()+ " - " + getCantidadDisponible() + "\n";
    }

}
