import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        PedidoService pedidoService = new PedidoService();
        Inventario inventario = new Inventario();


        int opcion;
        do {
            System.out.println("\n=================================");
            System.out.println("    SISTEMA DE GESTION - TecLab");
            System.out.println("==================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar Producto/Actualizar");
            System.out.println("4) Eliminar Producto");
            System.out.println("5) Crear pedido");
            System.out.println("6) Lista de pedidos");
            System.out.println("7) Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    Producto nuevoProducto = productService.crearProductoDesdeConsola();
                    inventario.agregarProducto(nuevoProducto);
                    System.out.println("✅ Producto agregado con ID: " + nuevoProducto.getId());
                    break;

                case 2:
                    inventario.mostrarProductos();
                    break;

                case 3:
                    System.out.println("El producto es: " +
                            inventario.buscarProductoPorId(productService.pedirIdProducto()));
                    break;

                case 4:
                    inventario.eliminarProducto();
                    break;

                case 5:
                    if (inventario.getProductos().isEmpty()) {
                        System.out.println("\n⚠️ No hay productos para crear pedidos.");
                        break;
                    }

                    Pedido nuevoPedido = new Pedido();
                    boolean agregarMas = true;

                    do {
                        inventario.mostrarProductos();
                        int idProducto = productService.pedirIdProducto();
                        Producto producto = inventario.buscarProductoPorId(idProducto);

                        if (producto == null) {
                            System.out.println("❌ ID no válido.");
                            continue;
                        }

                        int cantidad = productService.pedirCantidad();
                        nuevoPedido.agregarLinea(producto, cantidad);

                        System.out.print("¿Desea agregar más productos? (s/n): ");
                        agregarMas = scanner.nextLine().equalsIgnoreCase("s");
                    } while (agregarMas);

                    pedidoService.mostrarPedido(nuevoPedido);
                    break;

                case 6:
                    Pedido listaPedido = new Pedido();
                    System.out.println(listaPedido.getNumeroPedido());

                    break;

                case 7:
                    System.out.println("👋 ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 7); // Cambiado a 7 para coincidir con la opción de salir

        scanner.close();
    }
}