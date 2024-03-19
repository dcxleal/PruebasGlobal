import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventario {
    private Map<String, ArrayList<String>> productos;
    private Map<String, ArrayList<Integer>> stock;

    public Inventario() {
        productos = new HashMap<>();
        stock = new HashMap<>();
        productos.put("lacteos", new ArrayList<>());
        productos.put("limpieza", new ArrayList<>());
        productos.put("granos", new ArrayList<>());
        stock.put("lacteos", new ArrayList<>());
        stock.put("limpieza", new ArrayList<>());
        stock.put("granos", new ArrayList<>());
    }

    public void agregarProducto(String nombre, int cantidad, String grupo) {
        if (!productos.containsKey(grupo)) {
            System.out.println("Grupo no reconocido.");
            return;
        }

        ArrayList<String> listaProductos = productos.get(grupo);
        ArrayList<Integer> listaStock = stock.get(grupo);

        if (listaProductos.contains(nombre)) {
            int indice = listaProductos.indexOf(nombre);
            listaStock.set(indice, listaStock.get(indice) + cantidad);
        } else {
            listaProductos.add(nombre);
            listaStock.add(cantidad);
        }
    }

    public void mostrarInventario() {
        for (String grupo : productos.keySet()) {
            System.out.println("Inventario de " + grupo.substring(0, 1).toUpperCase() + grupo.substring(1) + ":");
            ArrayList<String> listaProductos = productos.get(grupo);
            ArrayList<Integer> listaStock = stock.get(grupo);
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.println(listaProductos.get(i) + " - " + listaStock.get(i) + " unidades");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Salir");

            System.out.print("Ingrese su opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese el grupo (lacteos, limpieza, granos): ");
                    String grupo = scanner.nextLine().toLowerCase();
                    inventario.agregarProducto(nombre, cantidad, grupo);
                    System.out.println("¡Producto agregado/actualizado exitosamente!");
                    break;
                case "2":
                    inventario.mostrarInventario();
                    break;
                case "3":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
    }
}
