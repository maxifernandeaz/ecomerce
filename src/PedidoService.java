import java.util.Scanner;

public class PedidoService {
    private Scanner scanner;

    public PedidoService() {
        this.scanner = new Scanner(System.in);
    }

    public LineaPedido crearLineaPedido(Producto producto, int cantidad) {
        return new LineaPedido(producto, cantidad);
    }

    public void mostrarPedido(Pedido pedido) {
        System.out.println("\n=== DETALLE DEL PEDIDO ===");
        for (LineaPedido linea : pedido.getLineas()) {
            System.out.println(linea);
        }
        System.out.println("TOTAL: $" + pedido.calcularTotal());
    }
}