import java.util.Scanner;

public class ProductService {
    private Scanner scanner;

    public ProductService() {
        this.scanner = new Scanner(System.in);
    }

    public Producto crearProductoDesdeConsola() {
        System.out.println("\n====== Agregar Nuevo Producto ===");
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Precio: ");
        double precio = scanner.nextDouble();

        System.out.println("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        return new Producto(nombre, precio, stock);
    }
}