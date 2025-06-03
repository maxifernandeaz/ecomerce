import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Producto> productos;
    Scanner scanner = new Scanner(System.in);


    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos para eliminar");
            return; // Salir del método si no hay productos
        }

        mostrarProductos();
        System.out.print("Ingrese el Id del producto que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto productoEliminar = buscarProductoPorId(id);

        if (productoEliminar != null) {
            productos.remove(productoEliminar);
            System.out.println("\nProducto eliminado correctamente: " + id);
            System.out.println("\nLista actualizada:");
            mostrarProductos();
        } else {
            System.out.println("\nNo se encontró el producto con ID: " + id);
        }
        // Elimina el scanner.nextLine() final si no es necesario
    }



    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
            return;
        }

        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto p : productos) {
            System.out.println(p.detalleProducto());
            System.out.println("--------------------------");
        }
    }
}