import java.util.Scanner;

public class ProductService {
    private Scanner scanner;

    public ProductService() {
        this.scanner = new Scanner(System.in);
    }

    public Producto crearProductoDesdeConsola() {
        System.out.println("\n====== Agregar Nuevo Producto ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        return new Producto(nombre, precio, stock);
    }

    public int pedirIdProducto() {
        System.out.print("\nIngrese el ID del producto: ");
        return scanner.nextInt();
    }

    public int pedirCantidad() {
        System.out.print("Ingrese la cantidad: ");
        return scanner.nextInt();
    }
}