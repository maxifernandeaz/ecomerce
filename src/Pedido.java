import java.util.ArrayList;

public class Pedido {
    private ArrayList<LineaPedido> lineas;
    private int numeroPedido;
    private static int contadorPedidos = 1;

    public Pedido() {
        this.lineas = new ArrayList<>();
        this.numeroPedido = contadorPedidos++;
    }

    // Agregar línea de pedido
    public void agregarLinea(Producto producto, int cantidad) {
        LineaPedido linea = new LineaPedido(producto, cantidad);
        lineas.add(linea);
    }

    // Calcular total del pedido
    public double calcularTotal() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        return total;
    }

    // Mostrar detalles del pedido
    public void mostrarPedido() {
        System.out.println("\n=== Pedido #" + numeroPedido + " ===");
        for (LineaPedido linea : lineas) {
            System.out.println(linea);
        }
        System.out.println("Total: $" + calcularTotal());

    }

    // Getters
    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
}