import java.util.Scanner;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidadStock;
    private static int ultimoId;

    // Constructor con parámetros
    public Producto(String nombre, double precio, int cantidadStock) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // Constructor vacío
    public Producto() {
        this.id = ++ultimoId;
    }



    // Getters y Setters
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getId() {
        return id;
    }



    // Método para mostrar detalles del producto
    public String detalleProducto() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- DETALLE DEL PRODUCTO ---");
        sb.append("\nID: ").append(this.id);
        sb.append("\nNombre: ").append(this.nombre);
        sb.append("\nPrecio: $").append(this.precio);
        sb.append("\nCantidad en Stock: ").append(this.cantidadStock);
        return sb.toString();
    }

    @Override
    public String toString() {
        return detalleProducto();
    }
}