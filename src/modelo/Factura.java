package modelo;

public class Factura extends Productos {

    int numeroFactura;
    int cantidad;
    double precioTotal;

    public Factura() {
        super();
    }

    public Factura(int idCategoria, String nombreCategoria, int referencia,
            String nombreProducto, double precio, String talla, String color,
            int cantidadDisponible, int numeroFactura, int cantidad,
            double precioTotal) {
        super(idCategoria, nombreCategoria, referencia, nombreProducto, precio,
                talla, color, cantidadDisponible);
        this.numeroFactura = numeroFactura;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

     /**
     * Método encargado de devolver los datos de una factura, para insertarlos
     * después al archivo.
     * @return 
     */
    @Override
    public String toString() {
        return super.getNombreCategoria() + " - " + super.getReferencia() + " - " + super.getNombreProducto() + " - " + super.getPrecio() + " - " + super.getTalla() + " - " + super.getColor() + " - " + super.getCantidadDisponible() + " - " + getCantidad() + " - " + getPrecioTotal();
    }

}
