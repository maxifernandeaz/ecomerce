import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Producto> productos;
    private Scanner scanner; // Scanner agregado

    public Inventario() {
        this.productos = new ArrayList<>();
        this.scanner = new Scanner(System.in); // Inicializar scanner
    }

    public void agregarProducto() {
        System.out.println("\n--- AGREGAR NUEVO PRODUCTO ---");

        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad en stock: ");
        int cantidadStock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto nuevo = new Producto(nombre, precio, cantidadStock);
        productos.add(nuevo);
        System.out.println("Producto agregado! ID: " + nuevo.getId());
    }

    public void mostrarProductos() {
        if(productos.isEmpty()) {
            System.out.println("\nNo hay productos para mostrar");
            return;
        }

        System.out.println("\n==== Lista de Productos =====");
        for (Producto producto : productos) { // Cambiado el nombre de la variable
            System.out.println(producto.detalleProducto());
            System.out.println("--------------------------");
        }
    }

    public void actualizarProducto() {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos para actualizar");
            return;
        }
        mostrarProductos();

        System.out.println("\nInrese el ID que desea actualizar");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto productoActualizar = null;

        for (Producto producto : productos) {
            if(producto.getId() == id) {
                productoActualizar = producto;
            break;
            }
        }
        if (productoActualizar == null) {
            System.out.println("\nNo se encontro ID del producto para actualizar: " + id);
            return;
        }

        System.out.println("Nuevo Nombre: " );
        String nuevoNombre = scanner.nextLine();
        productoActualizar.setNombre(nuevoNombre);
        System.out.println("Nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        productoActualizar.setPrecio(nuevoPrecio);
        System.out.println("Nuevo Stock: ");
        int nuevoStock = scanner.nextInt();
        productoActualizar.setCantidadStock(nuevoStock);
        System.out.println("Producto actualizado");
        scanner.nextLine();


    }

    public void eliminarProducto() {
        if(productos.isEmpty()) {
            System.out.println("\nNo hay productos para eliminar");
        }
        mostrarProductos();
        System.out.println("Ingrese el ID del producto que desea eliminar ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto productoEliniar = null;

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productoEliniar = producto;
                break;
            }
        }
        if (productoEliniar != null) {
            productos.remove(productoEliniar);
            System.out.println("\nProducto eliminado correctamente");
            mostrarProductos();
        } else {
            System.out.println("\nNo se encontro el ID del producto: " + id);

        }

    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n=================================");
            System.out.println("    SISTEMA DE GESTION - TecLab");
            System.out.println("==================================");

            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    System.out.println("Opción no implementada aún");
                    break;
                case 6:
                    System.out.println("Opción no implementada aún");
                    break;
                case 7:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7); // Cambiado a 7 para que coincida con la opción de salida
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.menu();
    }
}